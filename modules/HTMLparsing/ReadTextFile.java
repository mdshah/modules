package modules.HTMLparsing;


import java.io.*;
import java.util.*;
import modules.HTMLparsing.filter.ClassByDescFilter;
import modules.HTMLparsing.filter.Filter;
import modules.NLPParsing.DataAnalyzer;
import modules.entities.Course;
import modules.entities.University;
import modules.testData.ToyData;
import opennlp.tools.util.InvalidFormatException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Jeremy, Manushi, Albert
 */
public class ReadTextFile 
{
	public static final boolean DEBUG = true;
	public static final boolean OVERWRITE=false;
	public static List<University> universityList = new LinkedList();
	/**
	 * getContentsArr -  returns the array of urls in strings
	 * @param aFile
	 * @return
	 */
	public static String[] getContentsArr(File aFile){
		List<String> urlList = new LinkedList();
		try{
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try{
				String line = null;
				
				while(( line = input.readLine()) != null){
					urlList.add(line);
				}
			} finally{
				input.close();
			}
		} catch(IOException ex){
			ex.printStackTrace();
		}
		return urlList.toArray(new String[0]);
	}
	
	public static String getContents(File aFile) throws FileNotFoundException {
		StringBuilder contents = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(aFile));
		try {
			String line = null;
			while(( line = br.readLine()) != null ){
				contents.append(line);
			}
		} catch(IOException ex){
			ex.printStackTrace();
		}
		return contents.toString();
	}
	
	/**
	 * log - to turn on/off our debug messages
	 * @param message
	 */
	public static void log(String message){
		if(DEBUG){
			System.out.println(message);
		}
	}
	
	public static void writeFile(File aFile, String aContents) throws IOException {
		if (aFile == null){
			throw new IllegalArgumentException("Fill should not be null!");
		}
		Writer output = new BufferedWriter(new FileWriter(aFile));
		try{
			output.write(aContents);
		} finally{
			output.close();
		}
	}
	
	private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
    
    private static void applyFilter(University university, Filter filter) throws InvalidFormatException, IOException{
		Document doc = university.getDoc();
		List<Course> courseList = new LinkedList();
    	courseList = filter.apply(doc);
    	for(Course c : courseList) {
    		university.addCourse(c);
    	}
    }
    public static void main(String args[]) throws IOException,java.net.SocketTimeoutException
    {
    	File urlFile = new File("g4_Biology_Updated.txt");
    	
    	// obtain the array of urls
    	String[] urlArr = getContentsArr(urlFile);    	
    	StringBuilder output = new StringBuilder();
    	
    	log("---------------------------Loading HTML Docs-----------------------");
    	//Loading up HTML Files
    	File htmlDir = new File("html");
    	if(!htmlDir.exists() || OVERWRITE){
    		log("File's are being downloaded into html folder...");
    		//check if the directory is present
    		if(!htmlDir.exists())
    			htmlDir.mkdir();
    		for (int i=0; i < urlArr.length; i++){
    			Document doc = Jsoup.connect(urlArr[i]).get();

    			String dirName = "html";
    			String fileName = "Univ" + i + ".html";
    			String path = dirName + "//" + fileName;
    			File aFile = new File(path);
    			writeFile(aFile, doc.toString());
    			
    			
    	    	University univ = new University(fileName, doc);
    	    	universityList.add(univ);
        	}
    		log("done downloading!");
    	} else {
    		for(File f : htmlDir.listFiles()){
    			System.out.println(f);
    			Document doc = Jsoup.parse(getContents(f));
    			University univ = new University(f.getName(), doc);
    	    	universityList.add(univ);
    		}
    	}
    	
    	//----------------------------Trying to see if there is a description
//    	for(University u : universityList){
//    		System.out.println("------------------------------------->" + u.getId());
//    		Document d = u.getDoc();
//    		Elements els = d.select("[class~=(?i).*desc.*]");
//    		for(Element e : els){
//    			System.out.println("e.text():  "+ e.text());
//    			System.out.println("e.data():  " + e.data());
//    			System.out.println("e.tagName(): " + e.tagName());
//    			System.out.println("e.html(): " + e.html());
//    			System.out.println("-------");
//    		}
//    		System.out.println("--------------------");
//    	}
 
    	//---------------------------Trying to classify HTML-----------------------
    	List<Map<String,Integer>> featureList = new LinkedList<Map<String,Integer>>();
    	Set<String> stopTags=new HashSet<String>();
    	stopTags.add("html");
    	stopTags.add("#root");
    	stopTags.add("body");
    	stopTags.add("head");
    	
    	Set<String> used = new HashSet<String>();
    	for (University u : universityList) {
    		System.out.println("id:" + u.getId());
			Document doc = u.getDoc();
			Elements el = doc.select("*");
			Map<String,Integer> feature = new HashMap<String,Integer>();
			for(Element e : el){
				String tag = e.tagName();
				if(feature.containsKey(tag)){
					int count=feature.get(tag);
					feature.put(tag, ++count);
				} else {
					feature.put(tag, 1);
					used.add(tag);
				}
					
				System.out.println("tagName: " + tag);
			}
			featureList.add(feature);
		}
    	
    	//header
    	Iterator<String> hitr = used.iterator();
    	while(hitr.hasNext())
    		System.out.print(hitr.next()+"\t");
    	System.out.println();
    	
    	for(Map<String,Integer> feature : featureList){
    		Iterator<String> itr = used.iterator();
    		while(itr.hasNext()){
    			String tag = itr.next();
//    			System.out.print(tag+"\t");
    			if(feature.containsKey(tag)){
//    				System.out.print(String.format("%02d",feature.get(tag))+" ");
    				System.out.print(feature.get(tag)+ "\t");
    			}
    			else
    				System.out.print("0\t");
//    			System.out.println();
    		}
    		System.out.println();
//    		for (Map.Entry<String, Integer> entry : feature.entrySet()) {
//    			System.out.println("Key: " + entry.getKey() + " --> Val:" + entry.getValue());
//				
//			}
//    		System.exit(-1);
    	}
    	
    	//---------------------------Trying to classify HTML ENDS-----------------------
    	
    	log("--------------------ALL Documents Successfully Loaded");
    	//--------------------------First Filter: Using a "class" name in html ------------------------
    	Filter descFilter = new ClassByDescFilter();
    	for(University u : universityList)
    		applyFilter(u, descFilter);
    	
    	//--------------------------Second Filter: Brute force HTML Parsing ------------------------
    	//for those have zero courses. we will use more brute force approach to get the data

//    	List<University> firstFilterFailed = new LinkedList<University>();
//    	for(University u : universityList)
//    		if(u.getCourses().size() == 0)
//    			firstFilterFailed.add(u);
//    	    	
//    	Filter trFitler = new TableLengthFilter();
//    	for(University u : firstFilterFailed)
//    		applyFilter(u, trFitler);
//    	 	
//    	for(University u : universityList){
//    		log(u.toString());
//    	} 

    	
    	University ucsd = new University("0");
    	ToyData td = new ToyData();
    	ucsd.setCourses(td.getCourseList());
    	List<University> univ = new ArrayList<University>();
    	univ.add(ucsd);
    	
    	DataAnalyzer courses = new DataAnalyzer(univ);

//    	File outFile = new File("out.txt");
//    	writeFile(outFile,output.toString());
    	System.out.println("Done!");
    }
}
