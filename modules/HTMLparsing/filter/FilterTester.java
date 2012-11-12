package modules.HTMLparsing.filter;

import java.io.IOException;
import java.util.List;

import modules.entities.Course;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FilterTester {
	public static void main(String[] args) throws IOException {
		//Given filter and a document
		String url = "http://explorecourses.stanford.edu/CourseSearch/search?view=catalog&filter-coursestatus-Active=on&page=0&catalog=&q=central+menu&collapse=";
		Document d = Jsoup.connect(url).get();
		
		Filter ft = new ClassByDescFilter();
		List<Course> results =ft.apply(d);
		
		for(Course c : results){
			System.out.println(c);
			System.out.println("---------------");
		}
	}
}
