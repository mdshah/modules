package modules.NLPParsing;

import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import modules.entities.Course;

public class SentenceTester {
	public static void main(String[] args) throws Exception {
		Course c = new Course.Builder("junk").desc("Calculus, calculus,calculus are fun").build();
		System.out.println(c.getDescParsed().get(0));
		System.out.println(c.getDescParsed().get(0).getChunks());
		System.out.println(c.getDescParsed().get(0).getPosTags());
		System.out.println(c.getDescParsed().get(0).getRaw());
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
