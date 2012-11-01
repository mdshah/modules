import java.util.HashMap;

public class Course {
	
	private String name;
	private String school;
	private String courseNum;
	private String desc;
	private HashMap<String, Double> weightVector;
	private HashMap<String, Integer> termFreq;
	private double norm; 
	
	private Course(Builder builder) {
		name = builder.name;
		school = builder.school;
		courseNum = builder.courseNum;
		desc = builder.desc;
		
	}
	
	public static class Builder{
		private String school;
		private String name="NA";
		private String courseNum="NA";
		private String desc="NA";
		private HashMap<String, Double> weightVector;
		private HashMap<String, Integer> termFreq;
		private double norm; 
		
		public Builder(String school){
			this.school = school;
		}
		public Builder name(String name){
			this.name = name;return this;
		}
		public Builder courseNum(String courseNum){
			this.courseNum = courseNum;return this;
		}
		public Builder desc(String desc){
			this.desc = desc;return this;
		}
		public Course build(){
			return new Course(this);
		}
		
		
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
	
	public String toString(){
		return "-------------------\n" +
				"[School]" + school + "\n" +
			   "[Name]" + name + "\n" +
			   "[CourseNum]" + courseNum + "\n" +
			   "[Desc]" + desc;
	}
}
