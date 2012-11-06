package modules.NLPParsing;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modules.entities.Course;
import opennlp.tools.util.InvalidFormatException;

public class PrereqParser {

	//	returns the list of prerequisite given the course description
	public static List<String> getPrereqs(Course c){
		List<String> prereqs = new LinkedList<String>();
		boolean prereqExist = false;
		StringBuilder prereqSentenceBuilder = new StringBuilder();
		for(Sentence s : c.getDescParsed()){
			//detenct the setence that starts with pre, prerequisite, or prerequisites
			if(s.getWords().get(0).toLowerCase().equals("pre") || s.getWords().get(0).toLowerCase().equals("prerequsite") || s.getWords().get(0).toLowerCase().equals("prerequisites")){
				prereqExist = true;
			}	
			//append words 
			if(prereqExist == true){
				for(String word : s.getWords() ){
					prereqSentenceBuilder.append(word);
					prereqSentenceBuilder.append(" ");					
				}
			}
		}
		String prereqSentence = prereqSentenceBuilder.toString().trim();
		String pattern = "[A-Z]([A-Za-z]*\\s*)?\\d+[A-Za-z]?";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(prereqSentence);
		while(m.find())
			prereqs.add(m.group());
		return prereqs;
	}
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		String desc = "This course examines the physiological adaptation of animals, invertebrates and vertebrates, to their particular environmental and behavioral niches. Structural, functional, and molecular adaptations of the basic organ systems are discussed. Prerequisites: BILD 2, Chem 6A-B-C. BILD 3 is recommended.";
		Course c = new Course.Builder("test").desc(desc).build();
		System.out.println(PrereqParser.getPrereqs(c));
	}
}
