package modules.NLPParsing;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

	/**
	 * For each sentence in course description
	 * getWords()
	 * getStems()
	 * getPosTags()
	 * getChunks()
	 * getNouns()
	 * @author Albert
	 *
	 */
	public class Sentence {
		List<String> words;
		List<String> stems;
		List<String> posTags;
		List<String> chunks;
		//Parse parseTree;
		
		/**
		 * Do NOT remove any words
		 * @param words: word sequence
		 * @param stems: word sequence after stemming
		 * @param posTags: POS tag sequence
		 */
		public Sentence (List<String> words, List<String> stems, List<String> posTags, List<String> chunks) {
			this.words = words;
			this.stems = stems;
			this.posTags = posTags;
			this.chunks = chunks;
		}
		
		@Override
		public String toString() {
			String s = "";
			for(int i = 0; i < words.size(); ++ i) {
				if(posTags.size() != 0)
					s += (words.get(i) + "/" + posTags.get(i) + " ");
				else
					s += (words.get(i) + " ");
			}
			return s;
		}

		public List<String> getWords() {
			return words;
		}

		public List<String> getStems() {
			return stems;
		}

		public List<String> getPosTags() {
			return posTags;
		}

		public List<String> getChunks() {
			return chunks;
		}
		
		public List<String> getNouns() {
			List<String> nouns = new LinkedList<String>();
			for (int i = 0; i < words.size(); i++) {
				if(posTags.get(i).startsWith("N"))
					nouns.add(words.get(i));
			}
			return nouns;
		}
		
		public List<String> getNgrams(int n){
			List<String> ngrams = new LinkedList<String>();
			for(int i=0; i < words.size()-n+1; i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j < n; j++){
					sb.append(words.get(i+j));
					sb.append(" ");
				}
				ngrams.add(sb.toString().trim());
			}
			return ngrams;
		}
		
		public List<String> getNgramsPosTags(int n){
			List<String> ngramsPosTags = new LinkedList<String>();
			for(int i=0; i < posTags.size()-n+1; i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j < n; j++){
					sb.append(posTags.get(i+j));
					sb.append(" ");
				}
				ngramsPosTags.add(sb.toString().trim());
			}
			return ngramsPosTags;
		}
	
		/**
		 * returns the list of n-gram string that is recoganized as a module entity
		 * rule-based
		 * @param ngram
		 * @return
		 * @throws Exception 
		 */
		public List<String> getModuleEntity(int ngram) throws Exception{
			List<String> ngramWORDList = getNgrams(ngram);
			List<String> ngramPOSList = getNgramsPosTags(ngram);
			if(ngramWORDList.size() != ngramPOSList.size())
				throw new Exception("SHOULD BE EQUAL!!");
			Set<String> ruleset = new HashSet<String>();
			
			//define rules
			//need to get more sophisticated
			ruleset.add("JJ NN");
			ruleset.add("JJ NNS"); 
			ruleset.add("JJ NNP"); 
			ruleset.add("JJ NNPS"); 
			ruleset.add("NN NN");
			ruleset.add("NNS IN NN"); //ex) principles of heridity
			ruleset.add("NNP NN"); //TCA Cycle
			
			List<String> moduleEntityList = new LinkedList<String>();
			for(int i=0; i<ngramPOSList.size();i++){
				if(ruleset.contains(ngramPOSList.get(i))){
					String[] words = ngramWORDList.get(i).split(" ");
					boolean isStopword = false;
					for(String s : words){
						if(Stopwords.isStopwordModule(s)){
							isStopword = true;
							break;
						} 
					}
					if(!isStopword)
						moduleEntityList.add(ngramWORDList.get(i));
				}
			}
			
			
			
			return moduleEntityList;
			
			
		}
	}