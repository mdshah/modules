package modules.NLPParsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Stopwords {
	public static Set<String> stopwords;
	public static Set<String> stopwordsModule;
	
	/**
	 * Test if s is a stopword
	 */
	public static boolean isStopword(String s) {
		if(stopwords == null) {
			stopwords = new HashSet<String>();
			try {
				for(BufferedReader reader = new BufferedReader(new FileReader("stopwords.txt")); reader.ready(); ) {
					stopwords.add(reader.readLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stopwords.contains(s);
	}
	
	/**
	 * Test if s is a stopwordModule
	 */
	public static boolean isStopwordModule(String s) {
		if(stopwordsModule == null){
			stopwordsModule = new HashSet<String>();
			try {
				for(BufferedReader reader2 = new BufferedReader(new FileReader("stopwordsModule.txt")); reader2.ready();){
					stopwordsModule.add(reader2.readLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stopwordsModule.contains(s);
	}
	
}
