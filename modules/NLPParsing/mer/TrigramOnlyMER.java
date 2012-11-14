package modules.NLPParsing.mer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.Etc;

import modules.NLPParsing.Sentence;
import modules.NLPParsing.Stopwords;

public class TrigramOnlyMER implements ModuleEntityRecognizer{
	@Override
	public List<String> inferModuleFromSentence(Sentence s) {
		List<String> moduleEntityList = new LinkedList<String>();

		//Trigram filter
		List<String> trigramWORDList = s.getNgrams(3);
		List<String> trigramPOSList = s.getNgramsPosTags(3);
		
		Set<String> ruleset = new HashSet<String>();
		ruleset.add("N P N"); //Taylor's theorem
		ruleset.add("N I N");
		ruleset.add("J N N");
		for(int i=0; i< trigramPOSList.size();i++){
//			System.out.println(getFirstChar(trigramPOSList.get(i)));
			if(ruleset.contains(Etc.getFirstChar(trigramPOSList.get(i)))){
				String[] tmp = trigramWORDList.get(i).split(" ");
//				System.out.println("-------------------->" + tmp[0].toLowerCase());
				//liberal. just check the first word to filter out stop module
				if(!Stopwords.containsPunctuation(trigramWORDList.get(i)) && !Stopwords.isStopwordModule(tmp[0].toLowerCase())&& !Stopwords.isStopwordModule(tmp[1].toLowerCase()) && !Stopwords.isStopwordModule(tmp[2].toLowerCase()) && !Stopwords.containsNumber(trigramWORDList.get(i)) && (s.getNER().get(i).equals("O") || s.getNER().get(i).equals("PERSON"))){
//					System.out.println("added---->" + tmp[0].toLowerCase());
					String candidate=trigramWORDList.get(i).toLowerCase();
					if(candidate.contains(" 's"))
						candidate=candidate.replace(" 's","'s");
					if(candidate.contains("formulum"))
						candidate=candidate.replace("formulum", "formula");
					if(candidate.contains("datum"))
						candidate=candidate.replace("datum", "data");
					moduleEntityList.add(candidate);
				}
			}
		}
		return moduleEntityList;
	}
}
