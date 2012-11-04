package modules.NLPParsing;
import java.util.*;
import java.io.*;


import opennlp.tools.sentdetect.*;
import opennlp.tools.tokenize.*;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.postag.*;
import opennlp.tools.chunker.*;
import opennlp.tools.parser.*;
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
		List<Sentence> sentenceList = new LinkedList<Sentence>();
		String[] sentences = sentenceDetector.sentDetect(desc);		
		for(String s : sentences) {
			String[] tokens = tokenizer.tokenize(s);
			String[] posTags = tagger.tag(tokens);
			String[] chunks = chunker.chunk(tokens, posTags);
			List<String> lemma = new ArrayList<String>();
			for(String str : tokens) {
				lemma.add(str.toLowerCase());
			}
			
			Sentence sentence = new Sentence (Arrays.asList(tokens), lemma, Arrays.asList(posTags), Arrays.asList(chunks));
			sentenceList.add(sentence);
		}
		
		return sentenceList;
	}
}
