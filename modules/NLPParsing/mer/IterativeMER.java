package modules.NLPParsing.mer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import modules.NLPParsing.Sentence;
import modules.NLPParsing.Stopwords;

import util.Etc;

public class IterativeMER implements ModuleEntityRecognizer {
	
	@Override
	public List<String> inferModuleFromSentence(Sentence s) {
		List<String> moduleEntityList = new LinkedList<String>();
		//to keep track of one words that are used as an entity
		boolean[] used = new boolean[s.getStems().size()];
		for(int i=0;i<used.length;i++)
			used[i] = false;
			
		
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
					if(Etc.getFirstChar(trigramPOSList.get(i)).equals("N P N") && candidate.contains("'s"))
						candidate=candidate.replace(" 's","'s");
					if(Etc.getFirstChar(trigramPOSList.get(i)).equals("N P N") && candidate.contains("formulum"))
						candidate=candidate.replace("formulum", "formula");
					moduleEntityList.add(candidate);
					int offset=i;
					used[offset]=true;
					used[offset+1]=true;
					used[offset+2]=true;
				}
			}
		}
		
		//Bigram filter
		List<String> bigramWORDList = s.getNgrams(2);
		List<String> bigramPOSList = s.getNgramsPosTags(2);
		
		//define rules
		//need to get more sophisticated
		ruleset.add("J N");
		ruleset.add("N N");
		for(int i=0; i<bigramPOSList.size();i++){
			if(used[i]){
				continue;
			}
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
				if(!Stopwords.containsPunctuation(bigramWORDList.get(i)) && !isStopword && !Stopwords.containsNumber(bigramWORDList.get(i)) && (s.getNER().get(i).equals("O") || s.getNER().get(i).equals("PERSON"))){
					moduleEntityList.add(bigramWORDList.get(i).toLowerCase());
					//bigram
					int offset=i;
					used[offset]=true;
					used[offset+1]=true;
				}
			}
		}
		
		ruleset.add("N");
		List<String> unigramWORDList = s.getNgrams(1);
		List<String> unigramPOSList = s.getNgramsPosTags(1);
		//unigram
		for(int i=0;i < used.length;i++){
			if(used[i])
				continue;
			String uniwordPOS = Etc.getFirstChar(unigramPOSList.get(i));
			String uniword = unigramWORDList.get(i);
			//Stopwords.isValidWord(uniword.toLowerCase()) &&
			if(!Stopwords.containsPunctuation(uniword.toLowerCase()) && s.getNER().get(i).equals("O") && !Stopwords.containsNumber(uniword.toLowerCase()) && ruleset.contains(uniwordPOS) && !Stopwords.isStopwordModule(uniword.toLowerCase()) &&  !Stopwords.isMeaninglessUnigram(uniword.toLowerCase())){
					moduleEntityList.add(uniword.toLowerCase());
			}
		} 
		
		return moduleEntityList;
	}

}
