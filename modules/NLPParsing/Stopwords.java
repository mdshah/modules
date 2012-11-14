package modules.NLPParsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Stopwords {
	public static Set<String> stopwords;
	public static Set<String> stopwordsModule;
	public static Set<String> validwords;
	public static Set<String> meaninglessUnigram;
	public static boolean first = true;

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
				if(first) {
					first = false; 
					isStopword("");
					isMeaninglessUnigram("");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		boolean isStopWordModule = false; 
		String[] module = s.split(" ");
		int count = 0; 
		for(int i = 0; i < module.length; i++) {
			if(stopwords.contains(module[i]) || meaninglessUnigram.contains(module[i]))
				count++; 
		}

		if(count > 1) isStopWordModule = true;

		return stopwordsModule.contains(s) || isStopWordModule;
	}

	/**
	 * check if a given string is a meaningless unigram
	 * @param s
	 * @return
	 */
	public static boolean isMeaninglessUnigram(String s){
		if(meaninglessUnigram == null){
			meaninglessUnigram = new HashSet<String>();
			try {
				for(BufferedReader reader2 = new BufferedReader(new FileReader("meaninglessUnigram.txt")); reader2.ready();){
					meaninglessUnigram.add(reader2.readLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return meaninglessUnigram.contains(s);
	}

	/**
	 * checks if String s is a valid english
	 * @param s
	 * @return
	 */
	public static boolean isValidWord(String s) {
		if(validwords == null){
			validwords = new HashSet<String>();
			try {
				for(BufferedReader reader2 = new BufferedReader(new FileReader("validwords.txt")); reader2.ready();){
					validwords.add(reader2.readLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return validwords.contains(s);
	}
	
	/**
	 * check if String s contains a number
	 * @param s
	 * @return
	 */
	public static boolean containsNumber(String s) {
		Pattern p = Pattern.compile("\\d");
		return p.matcher(s).find();
	}
	
	public static boolean containsPunctuation(String str){
		Pattern pattern = Pattern.compile("[!@#$%^&*\\(\\)]");
		return pattern.matcher(str).find();
	}
	
	public static void main(String[] args) {
		String s = "sfsfs f3";
		System.out.println(containsPunctuation(s));
	}
}
