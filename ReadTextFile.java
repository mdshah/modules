
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
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay
 */
public class ReadTextFile 
{
	public static final boolean DEBUG = false;
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
    public static void main(String args[]) throws IOException,java.net.SocketTimeoutException
    {
    	File urlFile = new File("g4_Biology_Updated.txt");
    	
    	// obtain the array of urls
    	String[] urlArr = getContentsArr(urlFile);
    	for(String url : urlArr){
    		log(url);
    	}
    	
//    	String courseNumPattern = "courseNumber|courseNum|description|name|title|desc";
    	String courseNumPattern = "description|desc";
    	List<Course> courseList = new LinkedList<Course>();
    	
    	Pattern p = Pattern.compile(courseNumPattern,Pattern.CASE_INSENSITIVE);
    	StringBuilder output = new StringBuilder();
    	for (String test : urlArr){
	    	System.out.println("TESTING: " + test);
	    	System.out.println("--------------------------------------------------");
	    	Document doc = Jsoup.connect(test).get();
	        Elements coursesCrap = doc.select("[class~=(?i)course]");
	        
	        /* go through each element and see if it contains
	        	description
	        */ 
	        for (Element element : coursesCrap) {
	        	Matcher m = p.matcher(element.className());
	        	if(m.find()){
		          	if(!element.text().equals("")){
		          		System.out.println("matched by: " + m.group());
			          	System.out.println("| text | "+ element.text());
			          	output.append(element.text());
			          	output.append(System.getProperty("line.separator"));
			          	Course c = new Course();
			          	c.setDesc(element.text());
			          	courseList.add(c);
		          	}
	        	} 
	
	        } 
    	}
    	File outFile = new File("out.txt");
    	writeFile(outFile,output.toString());
    	System.out.println("Done!");
    }
}
