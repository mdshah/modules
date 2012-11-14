package modules.NLPParsing.mer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import modules.NLPParsing.Sentence;
import modules.NLPParsing.Stopwords;
import util.Etc;

public class BigramOnlyMER implements ModuleEntityRecognizer {

	/**
	 * detects nn and nn
	 * detects nn,nn,nn,nn
	 */
	@Override
	public List<String> inferModuleFromSentence(Sentence s) {
		List<String> moduleEntityList = new LinkedList();

		Set<String> ruleset = new HashSet();
		ruleset.add("N N");
		ruleset.add("J N");

		List<String> bigramPOSList = s.getNgramsPosTags(2);
		List<String> bigramWORDList = s.getNgrams(2);
		bigramPOSList = s.getNgramsPosTags(2);
		for(int i=0; i < bigramPOSList.size();i++){
			String posIni = Etc.getFirstChar(bigramPOSList.get(i));
			//add only if the next one is comma or period
			if(ruleset.contains(Etc.getFirstChar(bigramPOSList.get(i)))){
				String[] wordsSplits = bigramWORDList.get(i).split(" ");
				boolean isStopword = false;
				for(String split : wordsSplits){
					if(Stopwords.isStopwordModule(split)){
						//						System.out.println("DEBUG: " + bigramWORDList.get(i)+ ":"+ s);
						isStopword = true;
						break;
					} 
				}
				if(!Stopwords.containsPunctuation(bigramWORDList.get(i)) && !isStopword && !Stopwords.containsNumber(bigramWORDList.get(i)) && (s.getNER().get(i).equals("O"))){
					String candidate=bigramWORDList.get(i).toLowerCase();
					if(candidate.contains("formulum"))
						candidate=candidate.replace("formulum", "formula");
					if(candidate.contains("datum"))
						candidate=candidate.replace("datum", "data");
					moduleEntityList.add(candidate);
					//bigram
				}
			}

		}

		return moduleEntityList;
	}
}
