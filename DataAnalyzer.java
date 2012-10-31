import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class DataAnalyzer {

	private static final double SIM_THRESH = 0.5;
	private List<University> universities; 
	private HashMap<String, Integer> freq_term;
	private HashMap<String, Integer> freq_doc;
	private HashSet<String> stopwords;
	private HashMap<Course, List<Course>> similarCourses;
	private int n; 

	public DataAnalyzer(List<University> universities) {
		this.universities = universities;
		this.freq_term = new HashMap<String, Integer>();
		this.freq_doc = new HashMap<String, Integer>();
		this.stopwords = new HashSet<String>();
		this.similarCourses = new HashMap<Course, List<Course>>();
		createStopWordslist();
		calculateN();
		computeTF_IDF();
		computeWeightVectors();
		computeCosineSimilarity();
	}

	/**
	 * Read all stopwords from stopwords.txt file and add to the set stopwords. 
	 */
	private void createStopWordslist() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("stopwords.txt"));
			stopwords.add(reader.readLine());
			String line;
			while((line = reader.readLine()) != null)
				stopwords.add(line);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void calculateN() { 
		for(University u : universities) 
			n += u.getCourses().size();
	}

	public void computeTF_IDF() {
		for(University univ : universities)
			for(Course c : univ.getCourses()) { 
				HashSet<String> terms = new HashSet<String>();
				HashMap<String, Integer> termFreq = new HashMap<String, Integer>();

				//term frequency
				for(String s : c.getDesc().split(" ")) {
					s = s.toLowerCase().trim().replaceAll("[^\\p{L}\\p{N}]", "");
					if(!s.equals("") && !stopwords.contains(s)) {

						//globally across all courses
						Integer count = freq_term.get(s);
						if (count == null) freq_term.put(s, 1);				
						else freq_term.put(s, count + 1);

						//locally for the course
						Integer count2 = termFreq.get(s);
						if (count2 == null) termFreq.put(s, 1);				
						else termFreq.put(s, count2 + 1);

					}
					terms.add(s);
				}

				//document frequency
				for(String s : terms) {
					Integer count = freq_doc.get(s);
					if (count == null) freq_doc.put(s, 1);				
					else freq_doc.put(s, count + 1);
				}					

				c.setTermFreqs(termFreq);
			}
		System.out.print("");
	}

	public void computeWeightVectors() {
		for(University univ : universities)
			for(Course c : univ.getCourses()) { 
				HashMap<String, Double> weightVector = new HashMap<String, Double>();
				for(String s : c.getTermFreqs().keySet()) {
					weightVector.put(s, c.getTermFreqs().get(s) * Math.log10(n / freq_doc.get(s)));
				}
				c.setWeightVector(weightVector);
			}
	}

	public void computeCosineSimilarity() {
		University pivot = universities.get(0);
		for(Course orig : pivot.getCourses()) {
			List<Course> simCourses = new ArrayList<Course>();
			for(University univ : universities) 
				for(Course test : univ.getCourses()) {
					double sim = 0.0;
					for(String s : orig.getWeightVector().keySet()) {
						Double weight = test.getWeightVector().get(s);
						if (weight != null) sim += orig.getWeightVector().get(s) * weight;
					}
					sim = sim / (orig.getL2Norm() * test.getL2Norm());
					
					if(sim > SIM_THRESH) {
						System.out.println(orig.getDesc() + " : " + test.getDesc());
						System.out.println(" ");
						simCourses.add(test);
					}
				}
			similarCourses.put(orig, simCourses);
		}
		System.out.print("");
	}
}