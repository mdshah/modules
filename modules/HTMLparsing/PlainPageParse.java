package modules.HTMLparsing;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modules.HTMLparsing.filter.ClassByDescFilter;
import modules.HTMLparsing.filter.Filter;
import modules.HTMLparsing.filter.OneLevelDownFilter;
import modules.HTMLparsing.filter.ParagraphFilter;
import modules.entities.Course;

import opennlp.tools.util.InvalidFormatException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PlainPageParse {
	public static void main(String[] args) throws Exception {
		String url ="http://www.ucsd.edu/catalog/courses/MATH.html";
		String url2 ="http://www.ucsd.edu/catalog/courses/MATH.html";
		String url3 ="http://www.statistics.northwestern.edu/undergraduate/full-course-list.html";
		String url4 ="http://www.math.ucla.edu/ugrad/courses/index.shtml";
		List<Course> courseList = parseCoursesFromUrl(url4,new OneLevelDownFilter());
		for(Course c : courseList){
			System.out.println(c.getModuleEntity());
		}
		
//		System.out.println(parseCourseFromUrl(url2).getModuleEntity());
	}
	
	public static Course parseCourseFromUrl(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		String desc=doc.text();
		Course c = new Course.Builder(inferSchoolName(url)).desc(desc).build();
		return c;
	}

	public static List<Course> parseCoursesFromUrl(String url) throws InvalidFormatException, IOException{
		Document doc = Jsoup.connect(url).get();
		Filter ft = new ClassByDescFilter();
		return ft.apply(doc);
	}
	
	public static List<Course> parseCoursesFromUrl(String url, Filter ft) throws InvalidFormatException, IOException{
		Document doc = Jsoup.connect(url).get();
		return ft.apply(doc);
	}
	private static String inferSchoolName(String url){
		Pattern p = Pattern.compile("http://(.*?)/");
		Matcher m = p.matcher(url);
		String name = "NA";
		if(m.find()){
			name = m.group(1);
		}
		return name;
	}
}
