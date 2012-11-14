package modules.NLPParsing.mer;

import java.util.List;

import modules.NLPParsing.Sentence;

public interface ModuleEntityRecognizer {
	
	/**
	 * finds a modules from a sentence
	 * 
	 * @param s
	 * @return
	 */
	public List<String> inferModuleFromSentence(Sentence s);
}
