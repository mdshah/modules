package modules.NLPParsing;

import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import modules.entities.Course;

public class SentenceTester {
	public static void main(String[] args) throws Exception {
		Course c = new Course.Builder("junk").desc("@ 4.0. cr; Prereq-4603 or 5615 or # ; spring, every year. Sequel to MATH 4603. Topology of n-dimensional Euclidian space. Rigorous treatment of multivariable differentiation and integration, including chain rule, Taylor's Theorem, implicit function theorem, Fubini's Theorem, change of variables, Stokes' Theorem. Effective: Spring 2011.").build();
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
