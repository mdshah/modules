package modules.NLPParsing;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
public class StanfordNLPTester {
	public static void main(String[] args)
	{
		Properties props = new Properties(); 
		props.put("annotators", "tokenize, ssplit, pos, lemma"); 
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props, false);
		String text ="i like cats and dogs! you liked them? yes?! wow cool"; 
		Annotation document = pipeline.process(text);  
		for(CoreMap sentence: document.get(SentencesAnnotation.class)) {    
			for(CoreLabel token: sentence.get(TokensAnnotation.class)) {       
				String word = token.get(TextAnnotation.class);      
				String lemma = token.get(LemmaAnnotation.class); 
				String POS = token.get(PartOfSpeechAnnotation.class);
				System.out.println("lemmatized version :" + lemma + ":" + POS);
			} 
		}
	}
}
