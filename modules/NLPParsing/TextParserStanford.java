package modules.NLPParsing;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.dcoref.CoNLL2011DocumentReader.NamedEntityAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.ChunkAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
public class TextParserStanford {
	
	public static StanfordCoreNLP pipeline;
	/**
	 * This class parses the given description of the course
	 * @author Albert
	 *
	 */
	public static List<Sentence> parseDesc(String desc){
		if(pipeline == null) {
			Properties props = new Properties(); 
			props.put("annotators", "tokenize, ssplit, pos, lemma, ner"); 
			pipeline = new StanfordCoreNLP(props, false);
		}
		String text = desc; 
		Annotation document = pipeline.process(text);  
		
		List<String> tokens = new LinkedList<String>();
		List<String> lemma = new LinkedList<String>();
		List<String> posTags = new LinkedList<String>();
		List<String> chunks = new LinkedList<String>();
		List<String> ner = new LinkedList<String>();
		List<Sentence> sentenceList = new LinkedList();
		for(CoreMap sentence: document.get(SentencesAnnotation.class)) {    
			for(CoreLabel token: sentence.get(TokensAnnotation.class)) {            
				tokens.add(token.get(TextAnnotation.class));
				lemma.add(token.get(LemmaAnnotation.class));
				posTags.add(token.get(PartOfSpeechAnnotation.class));
				chunks.add(token.get(ChunkAnnotation.class));
				ner.add(token.get(NamedEntityTagAnnotation.class));
				
			} 
			Sentence sentenceParsed = new Sentence (tokens, lemma,posTags, chunks, ner);
			sentenceList.add(sentenceParsed);
		}

		return sentenceList;
	}


}
