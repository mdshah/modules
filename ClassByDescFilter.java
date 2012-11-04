import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import opennlp.tools.util.InvalidFormatException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ClassByDescFilter implements Filter{

	private static final boolean DEBUG = false;
	@Override
	public List<Course> apply(Document doc) throws InvalidFormatException, IOException {
		List<Course> courseList = new LinkedList<Course>();
		Elements ElementCourses = doc.select("[class~=(?i)course]");
             
        /* go through each element and see if it contains
        	description
        */ 
		String courseNumPattern = "description|desc";
		Pattern p = Pattern.compile(courseNumPattern,Pattern.CASE_INSENSITIVE);
		
        for (Element element : ElementCourses) {
        	Matcher m = p.matcher(element.className());
        	if(m.find()){
	          	if(!element.text().equals("")){
//	          		log("matched by: " + m.group());
//		          	log("| text | "+ element.text());
		          	Course c = new Course.Builder(doc.title()).desc(element.text()).build();
		          	courseList.add(c);
	          	}
        	} 

        } 
		return courseList;
	}
	
	
	public void log(String s){
		if(DEBUG)
			System.out.println(s);
	}
	
	

}
