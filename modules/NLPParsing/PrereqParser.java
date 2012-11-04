package modules.NLPParsing;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrereqParser {

	//returns the list of prerequisite given the course description
	public static List<String> prereqOf(String s){
		List<String> prereqs = new LinkedList();
		//This may need some more sophistications
		String pattern ="[A-Z]{3,}\\s*\\d+";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		while(m.find())
			prereqs.add(m.group());
		return prereqs;
	}
	
	public static void main(String[] args) {
		String desc = "This course examines the physiological adaptation of animals, invertebrates and vertebrates, to their particular environmental and behavioral niches. Structural, functional, and molecular adaptations of the basic organ systems are discussed. Prerequisites: BILD 2, Chem 6A-B-C. BILD 3 is recommended.";
		PrereqParser prep = new PrereqParser();
		System.out.println(prep.prereqOf(desc))
		;
	}
}
