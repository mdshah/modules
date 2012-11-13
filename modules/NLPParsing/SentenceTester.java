package modules.NLPParsing;

import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import modules.entities.Course;

public class SentenceTester {
	public static void main(String[] args) throws Exception {
		Course c = new Course.Builder("junk").desc("Albert Lee Mr.Lee Harvard Theory and practice of recombinant DNA and molecular biology techniques. Includes construction and screening of DNA libraries, DNA sequencing, PCR and its applications, bioinformatics, and RNA analysis. Prerequisites: BILD 1. Students may not enroll in or receive credit for both BIMM 101 and BIEB 123, or BIMM 101 and Chem 109 (formerly Chem 112B). BIMM 100 recommended.").build();
		System.out.println(c.getDescParsed().get(1));
		System.out.println(c.getModuleEntity());
//		System.out.println(firstSubstring("yes wow nice"));
	}
	
	/**
	 * return the first character of word delimited by white space in a string
	 * e.g. if given "yes wow nice", the function returns "y w n"
	 * @param s
	 * @return
	 */
	public static String firstSubstring(String s) {
		String[] tmp = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(String k : tmp){
			sb.append(k.charAt(0));
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}
