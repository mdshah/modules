package modules.NLPParsing;

import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import modules.entities.Course;

public class SentenceTester {
	public static void main(String[] args) throws Exception {
		Course c = new Course.Builder("junk").desc("Course is about calculus, integral, and principle of ecology").build();
		System.out.println(c.getModuleEntity());
	}
}
