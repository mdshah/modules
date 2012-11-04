package modules.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modules.NLPParsing.Sentence;
import modules.NLPParsing.TextParser;
import opennlp.tools.util.InvalidFormatException;

/**
 * Course is a representation is a course in university
 * it can have
 * - name : name of the course. "Introduction to biology"
 * - school : what school this course is offered. the origin 
 * - courseNum : the course number associated 
 * - desc : the raw description extracted from the html webpage. may not be perfect depending on parsing techniques
 * - descParsed: it contains the list of Sentence objects
 *
 * @author Insight
 *
 */
public class Course {
	
	private String name;
	private String school;
	private String courseNum;
	private String desc;
	private List<Sentence> descParsed;
	private HashMap<String, Double> weightVector;
	private HashMap<String, Integer> termFreq;
	private double norm; 
	
	private Course(Builder builder) {
		name = builder.name;
		school = builder.school;
		courseNum = builder.courseNum;
		desc = builder.desc;
		descParsed = builder.descParsed;
		
	}
	public static class Builder{
		private String school;
		private String name="NA";
		private String courseNum="NA";
		private String desc="NA";
		private List<Sentence> descParsed = new ArrayList<Sentence>();
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
		public Builder desc(String desc) throws InvalidFormatException, IOException{
			this.desc = desc;
			descParsed = TextParser.parseDesc(desc);
			return this;
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
	
	public List<Sentence> getDescParsed(){
		return descParsed;
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
			   "[Desc]" + desc + "\n" +
			   "[Parsed]" + descParsed;
	}
	
	

	
}
