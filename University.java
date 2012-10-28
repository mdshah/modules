import java.util.ArrayList;
import java.util.List;


public class University {
	
	private List<Course> courses;
	private String url;
	
	public University(String url) {
		courses = new ArrayList<Course>();
		this.url = url; 
	}
	
	public void addCourse(Course c) {
		courses.add(c);
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
	
	public String toString(){
		return "University:[" + url + "] | " + "numberOfCourses:" + courses.size();
	}
	
}
