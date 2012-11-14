package modules.NLPParsing;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
/**
 * This class parses the given description of the course
 * @author Albert
 *
 */
public class TextParser {
	public static SentenceDetectorME sentenceDetector;
	public static Tokenizer tokenizer;
	public static POSTaggerME tagger;
	public static ChunkerME chunker;
	
	public static List<Sentence> parseDesc(String desc){	

		// Need to load the actors only once 
		try{
			if(sentenceDetector == null)
				sentenceDetector = new SentenceDetectorME(new SentenceModel(new FileInputStream("en-sent.bin")));
			if(tokenizer == null)
				tokenizer = new TokenizerME(new TokenizerModel(new FileInputStream("en-token.bin")));
			if(tagger == null)
				tagger = new POSTaggerME(new POSModel(new FileInputStream("en-pos-maxent.bin")));
			if(chunker == null)
				chunker = new ChunkerME(new ChunkerModel(new FileInputStream("en-chunker.bin")));
		} catch(InvalidFormatException ex) {
			ex.printStackTrace();
		} catch(FileNotFoundException ex){
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		List<Sentence> sentenceList = new LinkedList();
		String[] sentences = sentenceDetector.sentDetect(desc);		
		for(String s : sentences) {
			String[] tokens = tokenizer.tokenize(s);
			String[] posTags = tagger.tag(tokens);
			String[] chunks = chunker.chunk(tokens, posTags);
			List<String> ner = new LinkedList();
			List<String> lemma = new ArrayList();
			for(String str : tokens) {
				lemma.add(str.toLowerCase());
				ner.add("O"); //assume everything is an object
			}
			
			Sentence sentence = new Sentence (Arrays.asList(tokens), lemma, Arrays.asList(posTags), Arrays.asList(chunks), ner, s);
			sentenceList.add(sentence);
		}
		
		return sentenceList;
	}
}
