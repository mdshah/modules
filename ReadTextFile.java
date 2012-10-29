import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay, Manushi, Albert
 */
public class ReadTextFile 
{
	public static final boolean DEBUG = false;
	public static List<Course> courseList;
	public static List<University> universityList = new LinkedList<University>();
	public static Map<String, Document> url2Doc = new HashMap<String,Document>();
	/**
	 * getContentsArr -  returns the array of urls in strings
	 * @param aFile
	 * @return
	 */
	public static String[] getContentsArr(File aFile){
		List<String> urlList = new LinkedList<String>();
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
    public static void main(String args[]) throws IOException,java.net.SocketTimeoutException
    {
    	File urlFile = new File("g4_Biology_Updated.txt");
    	
    	// obtain the array of urls
    	String[] urlArr = getContentsArr(urlFile);
    	
    	//--------------------------First Filter: Using a "class" name in html ------------------------
//    	String courseNumPattern = "courseNumber|courseNum|description|name|title|desc";
    	String courseNumPattern = "description|desc";
    	courseList = new LinkedList<Course>();
    	
    	Pattern p = Pattern.compile(courseNumPattern,Pattern.CASE_INSENSITIVE);
    	StringBuilder output = new StringBuilder();
    	
    	for (String url : urlArr){
	    	System.out.println("TESTING: " + url);
	    	System.out.println("--------------------------------------------------");
	    	Document doc = Jsoup.connect(url).get();
	        Elements coursesCrap = doc.select("[class~=(?i)course]");
	        
	        //Store HTML docs for a later use
	        url2Doc.put(url, doc);
	        
	        //Update the university list
	        University univ = new University(url);
	        universityList.add(univ);
	        
	        /* go through each element and see if it contains
	        	description
	        */ 
	        for (Element element : coursesCrap) {
	        	Matcher m = p.matcher(element.className());
	        	if(m.find()){
		          	if(!element.text().equals("")){
		          		log("matched by: " + m.group());
			          	log("| text | "+ element.text());
			          	Course c = new Course();
			          	c.setDesc(element.text());
			          	courseList.add(c);
			          	univ.addCourse(c);
		          	}
	        	} 
	
	        } 
    	}
    	
    	//--------------------------Second Filter: Brute force HTML Parsing ------------------------
    	//for those have zero courses. we will use more brute force approach to get the data
    	List<University> firstFilterFailed = new LinkedList<University>();
    	for(University u : universityList)
    		if(u.getCourses().size() == 0)
    			firstFilterFailed.add(u);
    	 
    	for(University u : firstFilterFailed){
    		Document doc = url2Doc.get(u.getUrl());
    		System.out.println("URL: " + u.getUrl());
    		System.out.println("Title" + doc.title());
    		// System.out.println("Body" + doc.body());
    		// System.out.println("head" + doc.head());
    		// System.out.println("nodeName" + doc.nodeName());
     		Elements links = doc.select("a[href]");
//     		Elements media = doc.select("[src]");
//     		Elements imports = doc.select("link[href]");
//			 print("\nMedia: (%d)", media.size());
//	         for (Element src : media) {
//	             if (src.tagName().equals("img"))
//	                 print(" * %s: <%s> %sx%s (%s)",
//	                         src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
//	                         trim(src.attr("alt"), 20));
//	             else
//	                 print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
//	         }

	  //       print("\nImports: (%d)", imports.size());
	  //       for (Element link : imports) {
	  //           print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
	  //       }
//
//       		print("\nLinks: (%d)", links.size());
//			 for (Element link : links) {
//			     print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//			 }
    		System.out.println("--------------------------------------------------");
    	}
    	
    	 	
    	for(University u : universityList){
    		log(u.toString());
    	}
    	
    	DataAnalyzer courses = new DataAnalyzer(courseList);
    	courses.createFeatureVector();
//    	File outFile = new File("out.txt");
//    	writeFile(outFile,output.toString());
    	System.out.println("Done!");
    }
}
