import java.util.HashMap;

public class Course {
	
	private String name;
	private String school;
	private String courseNum;
	private String desc;
	private HashMap<String, Double> weightVector;
	private HashMap<String, Integer> termFreq;
	private double norm; 
	
	public Course() {
		
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
	
	public HashMap<String, Double> getWeightVector() {
		return weightVector;
	}
	
	public void setWeightVector(HashMap<String, Double> weightVector) {
		this.weightVector = weightVector;
		computeL2Norm();
	}
	
	public HashMap<String, Integer> getTermFreqs() {
		return termFreq;
	}
	
	public void setTermFreqs(HashMap<String, Integer> termFreq) {
		this.termFreq = termFreq;
	}
	
	public void computeL2Norm() {
		double norm = 0; 
		for(Double weight : weightVector.values()) {
			norm += weight;
		}
		this.norm = Math.sqrt(norm);
	}
	
	public double getL2Norm() {
		return norm;
	}
}
