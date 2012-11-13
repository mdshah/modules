package modules.HTMLparsing.filter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modules.entities.Course;
import opennlp.tools.util.InvalidFormatException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ParagraphFilter implements Filter{

	private static final boolean DEBUG = false;
	@Override
	public List<Course> apply(Document doc) throws InvalidFormatException, IOException {
		List<Course> courseList = new LinkedList<Course>();
		Elements ElementCourses = doc.getElementsByTag("p");

		/* go through each element and see if it contains
        	description
		 */ 	
		for (Element element : ElementCourses) {
			Course c = new Course.Builder(doc.title()).desc(element.text()).build();
			courseList.add(c);
		} 
		return courseList;
	}


	public void log(String s){
		if(DEBUG)
			System.out.println(s);
	}



}
