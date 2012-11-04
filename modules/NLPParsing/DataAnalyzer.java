package modules.NLPParsing;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import modules.entities.Course;
import modules.entities.Module;
import modules.entities.University;


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
		createDotFile(createModuleStructure());
		generateMap("modules");
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
	
	public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                return (m2.getValue()).compareTo(m1.getValue());
            }
        });

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
	
	public List<Module> createModuleStructure() {
		List<Module> list = new ArrayList<Module>();
		
		Map<String, Integer> wordFreq = sortByValue(freq_term);
		int count = 0; 
		//consider top 30 frequent terms
		for(String s : wordFreq.keySet()) {
			if(count > 30) continue;
			Module m = new Module(s);
			list.add(m);
			count++;
		}
		
		//add children to each module based on preReqs
		return list;
	}
	
	public void createDotFile(List<Module> modules) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("modules.dot", false));
			out.write("graph {" + "\n");
			for(Module module : modules) {
				if(module.getChildren().size() > 0)
					for(Module child : module.getChildren())
						out.write( module.getName() + " -- " + child.getName() + "\n");
				else out.write( module.getName() + "\n");
			}
			out.write("}");
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void generateMap(String fileName) {		
        try {      	
            String cmdline[] = {"/usr/bin/dot", "-Tpdf", fileName + ".dot", ">", fileName + ".pdf"};
            Process p = Runtime.getRuntime().exec(cmdline);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
	}
}