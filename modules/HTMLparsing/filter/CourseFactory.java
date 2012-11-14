package modules.HTMLparsing.filter;

import java.io.IOException;

import modules.entities.Course;

import opennlp.tools.util.InvalidFormatException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CourseFactory {

	public static Course generateCourseUsingPtag(String url) throws InvalidFormatException, IOException{
		Document doc = Jsoup.connect(url).get();
		Elements ElementCourses = doc.getElementsByTag("p");

		/* go through each element and see if it contains
        	description
		 */ 	
		StringBuilder description = new StringBuilder();
		for (Element element : ElementCourses) {
			description.append(element.text());
		} 
		return new Course.Builder(doc.title()).desc(description.toString()).build();
	}
}
