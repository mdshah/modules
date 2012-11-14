package modules.HTMLparsing.filter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import modules.HTMLparsing.URLGrabberFilter;
import modules.entities.Course;
import opennlp.tools.util.InvalidFormatException;

import org.jsoup.nodes.Document;

public class OneLevelDownFilter implements Filter {
	@Override
	public List<Course> apply(Document d) throws InvalidFormatException,
			IOException {
		List<Course> courseList = new LinkedList<Course>();
		List<String> validURLS = URLGrabberFilter.getListOfValidURLs(d);
		for(String url : validURLS){
			courseList.add(CourseFactory.generateCourseUsingPtag(url));
		}
		
		return courseList;
	}
}
