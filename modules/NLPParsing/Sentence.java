package modules.NLPParsing;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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
		List<String> ner;
		//Parse parseTree;
		
		/**
		 * Do NOT remove any words
		 * @param words: word sequence
		 * @param stems: word sequence after stemming
		 * @param posTags: POS tag sequence
		 */
		public Sentence (List<String> words, List<String> stems, List<String> posTags, List<String> chunks, List<String> ner) {
			this.words = words;
			this.stems = stems;
			this.posTags = posTags;
			this.chunks = chunks;
			this.ner = ner;
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
			for (int i = 0; i < stems.size(); i++) {
				if(posTags.get(i).startsWith("N"))
					nouns.add(stems.get(i));
			}
			return nouns;
		}
		
		public List<String> getNgrams(int n){
			List<String> ngrams = new LinkedList<String>();
			for(int i=0; i < stems.size()-n+1; i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j < n; j++){
					sb.append(stems.get(i+j));
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
		public List<String> getModuleEntity() throws Exception{
			//need to take care of trigram
			
			List<String> moduleEntityList = new LinkedList<String>();
			
			//to keep track of one words that are used as an entity
			boolean[] used = new boolean[stems.size()];
			
			for(int i=0;i<used.length;i++)
				used[i] = false;
				
			
			//Trigram filter
			List<String> trigramWORDList = getNgrams(3);
			List<String> trigramPOSList = getNgramsPosTags(3);
			
			Set<String> ruleset = new HashSet<String>();
			ruleset.add("N I N");
			ruleset.add("J N N");
			for(int i=0; i< trigramPOSList.size();i++){
//				System.out.println(getFirstChar(trigramPOSList.get(i)));
				if(ruleset.contains(getFirstChar(trigramPOSList.get(i)))){
					String[] tmp = trigramWORDList.get(i).split(" ");
//					System.out.println("-------------------->" + tmp[0].toLowerCase());
					//liberal. just check the first word to filter out stop module
					if(!Stopwords.isStopwordModule(tmp[0].toLowerCase()) && !Stopwords.containsNumber(trigramWORDList.get(i)) && ner.get(i).equals("O")){
//						System.out.println("added---->" + tmp[0].toLowerCase());
						moduleEntityList.add(trigramWORDList.get(i).toLowerCase());
						int offset=i;
						used[offset]=true;
						used[offset+1]=true;
						used[offset+2]=true;
					}
				}
			}
			
			//Bigram filter
			List<String> bigramWORDList = getNgrams(2);
			List<String> bigramPOSList = getNgramsPosTags(2);
			
			//define rules
			//need to get more sophisticated
			ruleset.add("J N");
			ruleset.add("N N");
			for(int i=0; i<bigramPOSList.size();i++){
				if(used[i]){
					continue;
				}
				if(ruleset.contains(getFirstChar(bigramPOSList.get(i)))){
					String[] wordsSplits = bigramWORDList.get(i).split(" ");
					boolean isStopword = false;
					for(String s : wordsSplits){
						if(Stopwords.isStopwordModule(s)){
//							System.out.println("DEBUG: " + bigramWORDList.get(i)+ ":"+ s);
							isStopword = true;
							break;
						} 
					}
					if(!isStopword && !Stopwords.containsNumber(bigramWORDList.get(i)) && ner.get(i).equals("O")){
						moduleEntityList.add(bigramWORDList.get(i).toLowerCase());
						//bigram
						int offset=i;
						used[offset]=true;
						used[offset+1]=true;
					}
				}
			}
			
			ruleset.add("N");
			List<String> unigramWORDList = getNgrams(1);
			List<String> unigramPOSList = getNgramsPosTags(1);
			//unigram
			for(int i=0;i < used.length;i++){
				if(used[i])
					continue;
				String uniwordPOS = getFirstChar(unigramPOSList.get(i));
				String uniword = unigramWORDList.get(i);
				//Stopwords.isValidWord(uniword.toLowerCase()) &&
				if( ner.get(i).equals("O") && !Stopwords.containsNumber(uniword.toLowerCase()) && ruleset.contains(uniwordPOS) && !Stopwords.isStopwordModule(uniword.toLowerCase()) &&  !Stopwords.isMeaninglessUnigram(uniword.toLowerCase())){
						moduleEntityList.add(uniword.toLowerCase());
				}
			} 
			
			return moduleEntityList;
			
			
		}
		
		private String getFirstChar(String s) {
			String[] tmp = s.split("\\s+");
			StringBuilder sb = new StringBuilder();
			for(String k : tmp){
				sb.append(k.charAt(0));
				sb.append(" ");
			}
			return sb.toString().trim();
		}
	}