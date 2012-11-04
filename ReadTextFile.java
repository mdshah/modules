import java.io.*;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
    
    private static void applyFilter(University university, Filter filter){
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
    	
    	log("--------------------ALL Documents Successfully Loaded");
    	//--------------------------First Filter: Using a "class" name in html ------------------------
    	Filter descFilter = new ClassByDescFilter();
    	for(University u : universityList)
    		applyFilter(u, descFilter);
    	
    	//--------------------------Second Filter: Brute force HTML Parsing ------------------------
    	//for those have zero courses. we will use more brute force approach to get the data
    	List<University> firstFilterFailed = new LinkedList();
    	for(University u : universityList)
    		if(u.getCourses().isEmpty())
    			firstFilterFailed.add(u);
    	    	
    	Filter trFitler = new TableLengthFilter();
    	for(University u : firstFilterFailed)
    		applyFilter(u, trFitler);
    	 	
    	for(University u : universityList){
    		log(u.toString());
    	} 
    	
    	DataAnalyzer courses = new DataAnalyzer(universityList);

//    	File outFile = new File("out.txt");
//    	writeFile(outFile,output.toString());
    	System.out.println("Done!");
    }
}
