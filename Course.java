
public class Course {
	private String name;
	private String school;
	private String courseNum;
	private String desc;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String name, String school, String courseNum) {
		this.name = name;
		this.school=school;
		this.courseNum=courseNum;		
	}


	public String getName() {
		return name;
	}

	public String getSchool() {
		return school;
	}

	public String getCourseNum() {
		return courseNum;
	}
	
	public String getDesc(){
		return desc;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
