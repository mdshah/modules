import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;


public class University {
	
	private Document doc;
	private List<Course> courses;
	private String id;
	
	public University(String id, Document doc) {
		this.courses = new ArrayList<Course>();
		this.id = id; 
		this.doc = doc;
	}
	
	public void addCourse(Course c) {
		courses.add(c);
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public String getId() {
		return id;
	}

	public Document getDoc(){
		return doc;
	}
	public String toString(){
		return "University:[" + id + "] | " + "numberOfCourses:" + courses.size();
	}
	
}
