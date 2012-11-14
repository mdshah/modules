package modules.NLPParsing.mer;

import java.util.LinkedList;
import java.util.List;

import modules.NLPParsing.Sentence;
import edu.stanford.nlp.util.CoreMap;

public class SimpleMER implements ModuleEntityRecognizer {
	
	/**
	 * detects nn and nn
	 * detects nn,nn,nn,nn
	 */
	@Override
	public List<String> inferModuleFromSentence(Sentence s) {
		List<String> moduleEntityList = new LinkedList();
		CoreMap sentence = new CoreMap
				s.getRaw();
		moduleEntityList.addAll(s.getChunks());
		List<String> PosTags = s.getPosTags();
		//need to detec
		
		return moduleEntityList;
	}
}
