package modules.NLPParsing.mer;

import java.util.LinkedList;
import java.util.List;

import modules.NLPParsing.Sentence;

public class SimpleMER implements ModuleEntityRecognizer {
	
	
	@Override
	public List<String> inferModuleFromSentence(Sentence s) {
		List<String> moduleEntityList = new LinkedList();
		moduleEntityList.addAll(s.getChunks());
		return moduleEntityList;
	}
}
