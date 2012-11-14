package modules.NLPParsing;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import modules.NLPParsing.mer.IterativeMER;
import modules.NLPParsing.mer.ModuleEntityRecognizer;

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
		
		public List<String> getNER(){
			return ner;
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
			
			ModuleEntityRecognizer mer = new IterativeMER();
			return mer.inferModuleFromSentence(this);
			
			
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