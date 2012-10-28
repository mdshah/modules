import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class DataAnalyzer {

	private List<Course> courseList; 
	private HashMap<String, Integer> freq_vect;
	private HashSet<String> stopwords;

	public DataAnalyzer(List<Course> courseList) {
		this.courseList = courseList;
		this.freq_vect = new HashMap<String, Integer>();
		this.stopwords = new HashSet<String>();
		createStopWordslist();
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

	public void createFeatureVector() {
		for(Course c : courseList) 
			for(String s : c.getDesc().split(" ")) {
				s = s.toLowerCase().trim().replaceAll("[^\\p{L}\\p{N}]", "");
				if(!s.equals("") && !stopwords.contains(s)) {
					Integer count = freq_vect.get(s);
					if (count == null) freq_vect.put(s, 1);				
					else freq_vect.put(s, count + 1);
				}
			}
		System.out.print("");
	}

}