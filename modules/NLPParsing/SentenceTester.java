package modules.NLPParsing;

import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import modules.entities.Course;

public class SentenceTester {
	public static void main(String[] args) throws Exception {
		Course c = new Course.Builder("junk").desc("[11:20:01 PM] manu.shah89: Prereq-2243, [2283 or 3283]; Credit will not be granted if credit has been received for: 5705, 5707; fall, spring, every year. Existence, enumeration, construction, algorithms, optimization. Pigeonhole principle, bijective combinatorics, inclusion-exclusion, recursions, graph modeling, isomorphism. Degree sequences and edge counting. Connectivity, Eulerian graphs, trees, Euler.s formula, network flows, matching theory. Emphasizes mathematical induction as proof techniqu").build();
		System.out.println(c.getDescParsed().get(0));
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
