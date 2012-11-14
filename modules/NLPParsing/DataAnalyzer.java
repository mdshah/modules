package modules.NLPParsing;
import java.io.*;
import java.util.*;

import modules.HTMLparsing.WikiWrapper;
import modules.entities.Course;
import modules.entities.Module;
import modules.entities.University;
import modules.graphPruning.PruneGraph;


public class DataAnalyzer {

	private static final double SIM_THRESH = 0.5;
	private List<University> universities; 
	private HashMap<String, Integer> freq_term;
	private HashMap<String, Integer> freq_doc;
	private HashSet<String> stopwords;
	private HashMap<Course, List<Course>> similarCourses;
	private int n; 
	private WikiWrapper wiki;

	public DataAnalyzer(List<University> universities) {
		this.universities = universities;
		this.freq_term = new HashMap<String, Integer>();
		this.freq_doc = new HashMap<String, Integer>();
		this.stopwords = new HashSet<String>();
		this.similarCourses = new HashMap<Course, List<Course>>();
		this.wiki = new WikiWrapper();
		//createStopWordslist();
		//calculateN();
		//computeTF_IDF();
		//computeWeightVectors();
		//computeCosineSimilarity();
		//createDotFile(createModuleStructure());
		//generateMap("modules");
		//	createModules(false);
		createModulesWithoutPrereq();	
	}

	/**
	 * Read all stopwords from stopwords.txt file and add to the set stopwords. 
	 */
	private void createStopWordslist() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("stopwords.txt"));
			stopwords.add(reader.readLine());
			String line;
			while((line = reader.readLine()) != null)
				stopwords.add(line);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void calculateN() { 
		for(University u : universities) 
			n += u.getCourses().size();
	}

	public void computeTF_IDF() {
		try {
			for(University univ : universities) {
				for(Course c : univ.getCourses()) { 
					HashSet<String> terms = new HashSet<String>();
					HashMap<String, Integer> termFreq = new HashMap<String, Integer>();

					//term frequency
					//for(String s : c.getDesc().split(" ")) {
					//s = s.toLowerCase().trim().replaceAll("[^\\p{L}\\p{N}]", "");
					for(Sentence sent : c.getDescParsed()) {
						for(String entity : sent.getModuleEntity()) {
							if(!entity.equals("") && !stopwords.contains(entity)) {

								if(entity.split(" ").length > 1) { 
									//globally across all courses
									Integer count = freq_term.get(entity);
									if (count == null) freq_term.put(entity, 1);				
									else freq_term.put(entity, count + 1);

									//locally for the course
									Integer count2 = termFreq.get(entity);
									if (count2 == null) termFreq.put(entity, 1);				
									else termFreq.put(entity, count2 + 1);
								}

							}
							if(entity.split(" ").length > 1)
								terms.add(entity);

						}
					}

					//document frequency
					for(String s : terms) {
						Integer count = freq_doc.get(s);
						if (count == null) freq_doc.put(s, 1);				
						else freq_doc.put(s, count + 1);
					}					

					c.setTermFreqs(termFreq);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("");
	}

	public void computeWeightVectors() {
		for(University univ : universities)
			for(Course c : univ.getCourses()) { 
				HashMap<String, Double> weightVector = new HashMap<String, Double>();
				for(String s : c.getTermFreqs().keySet()) {
					weightVector.put(s, c.getTermFreqs().get(s) * Math.log10(n / freq_doc.get(s)));
				}
				c.setWeightVector(weightVector);
			}
	}

	public void computeCosineSimilarity() {
		University pivot = universities.get(0);
		for(Course orig : pivot.getCourses()) {
			List<Course> simCourses = new ArrayList<Course>();
			for(University univ : universities) 
				for(Course test : univ.getCourses()) {
					double sim = 0.0;
					for(String s : orig.getWeightVector().keySet()) {
						Double weight = test.getWeightVector().get(s);
						if (weight != null) sim += orig.getWeightVector().get(s) * weight;
					}
					sim = sim / (orig.getL2Norm() * test.getL2Norm());

					if(sim > SIM_THRESH) {
						System.out.println(orig.getDesc() + " : " + test.getDesc());
						System.out.println(" ");
						simCourses.add(test);
					}
				}
			similarCourses.put(orig, simCourses);
		}
		System.out.print("");
	}

	public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				return (m2.getValue()).compareTo(m1.getValue());
			}
		});

		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	//with prereq course 
	public void createModules(boolean allPairs) {
		HashMap<String, Course> allCourses = new HashMap<String, Course>();
		HashMap<String, Module> allModules = new HashMap<String, Module>();
		//HashSet<Module> allParentModules = new HashSet<Module>();
		try {
			for(University univ : universities) {
				for(Course c : univ.getCourses()) { 
					//if(count > 1) continue;
					allCourses.put(c.getCourseNum(), c);
					List<String> modules = c.getModuleEntity();
					List<String> invalidModules = new ArrayList<String>();

					modules = pruneModuleList(modules);

					//handle prereqs part 
					if(c.getPrereq().size() > 0 && modules.size() > 0) {
						for(String prereq : c.getPrereq()) {
							Course preq = allCourses.get(prereq);
							if(null != preq && !prereq.equals(c.getCourseNum())) {
								List<String> prereqMod = pruneModuleList(preq.getModuleEntity());
								//List<String> prereqMod = preq.getModuleEntity();	
								if(allPairs) {
									for (String parent : prereqMod) {									
										Module p = (allModules.get(parent) != null) ? allModules.get(parent) : new Module(parent);

										for(String child : modules) {
											if(prereqMod.contains(child) || invalidModules.contains(child)) {
												invalidModules.add(child);
												continue;
											}
											Module ch = (allModules.get(child) != null) ? allModules.get(child) : new Module(child);
											p.addChildren(ch);
											allModules.put(child, ch);
										}
										allModules.put(parent, p);
									}
								}
								else {  //connect the last module from prereq to the first module from this course 
									String parent = prereqMod.get(prereqMod.size() - 1);
									String child = modules.get(0);
									int i = 0; 

									for(String ch : modules) {
										if(prereqMod.contains(ch) || invalidModules.contains(ch)) {
											invalidModules.add(ch);
										}
									}

									while((null != child) && (prereqMod.contains(child) || invalidModules.contains(child))) {
										i++;
										if(i < modules.size() - 1)
											child = modules.get(i);
										else break;

									}

									Module p = (allModules.get(parent) != null) ? allModules.get(parent) : new Module(parent);
									if(null != child) {
										Module ch = (allModules.get(child) != null) ? allModules.get(child) : new Module(child);
										p.addChildren(ch);
										allModules.put(child, ch);
									}
									allModules.put(parent, p);
								}
							}
						}
					}
					for(int i = 0; i < modules.size(); i++) {
						String parent = modules.get(i);
						Module p = (allModules.get(parent) != null) ? allModules.get(parent) : new Module(parent);

						String child = null;
						if(i != (modules.size() - 1)) {
							child = modules.get(i+1);
						}

						int j = i; 

						while((null != child) && (invalidModules.contains(child) || child.equals(parent))) {							
							i++;
							if(i < (modules.size() - 1))
								child = modules.get(i);
							else break;	
						}

						i = j;
						if(null != child) {	
							Module ch = (allModules.get(child) != null) ? allModules.get(child) : new Module(child);
							p.addChildren(ch);
							allModules.put(child, ch);
						}

						allModules.put(parent, p);
					}
				}
			}

			createDotFile(allModules.values());	

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<String> pruneModuleList(List<String> modules) {
		List<String> prunedList = new ArrayList<String>();
		for(String s : modules) {
			s = s.replace("-", " ");
			String[] orWords = s.split("/");
			if(orWords.length > 1) {
				for(String orW : orWords)
					if(wiki.hasWikiPage(orW)) {
						orW = wiki.returnTitlePage(orW);
						prunedList.add(orW);
						System.out.print(orW + ", ");
					}
			}
			else if(wiki.hasWikiPage(s)) {
				s = wiki.returnTitlePage(s);
				prunedList.add(s);
				System.out.print(s + ", ");
			}
		}

		System.out.println();
		return prunedList;	
	}

	public void createModulesWithoutPrereq() {
		try {
			HashSet<String> allModules = new HashSet<String>();
			for(University univ : universities) {
				for(Course c : univ.getCourses()) { 
					List<String> modules = c.getModuleEntity();
					modules = pruneModuleList(modules);
					allModules.addAll(modules);
				}
			}

			BufferedWriter out = new BufferedWriter(new FileWriter("modules.txt", false));
			out.write("digraph {" + "\n");			

			HashSet<String> modules = new HashSet<String>();
			HashSet<String> allFormatedList = new HashSet<String>();

			for(String title : allModules) {
				ArrayList<String> allCandidates = new ArrayList<String>();
				modules.add(modifyString(title));
				for(String b : allModules) {
					if(b != null) allCandidates.add(b);
				}

				if(title != null && allCandidates.size() > 0) {
					HashMap<String, Integer> counts = wiki.containWordsGivenPage(allCandidates, title.trim()); 
					if(counts != null)
						for(String b : counts.keySet()) {
							if(!title.equals(b) && counts.get(b) > 0 && !modifyString(title).equals("")  &&  !modifyString(b).equals("")) {
								out.write(modifyString(title) + " -> " + modifyString(b) + "\n");
								allFormatedList.add(modifyString(title) + " -> " + modifyString(b));
							}
							modules.add(modifyString(b));
						}
				}
			}

			PruneGraph pg = new PruneGraph("modules.txt", modules, allFormatedList);
			out.write("}");
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Module> createModuleStructure() {
		List<Module> list = new ArrayList<Module>();

		Map<String, Integer> wordFreq = sortByValue(freq_term);
		int count = 0; 
		//consider top 30 frequent terms
		for(String s : wordFreq.keySet()) {
			if(count > 30) continue;
			Module m = new Module(s);
			list.add(m);
			count++;
		}

		//add children to each module based on preReqs
		return list;
	}

	public double jaccardianSim(Course A, Course B) {
		double result = 0.0;

		HashSet<String> intersection = new HashSet<String>();
		HashSet<String> union = new HashSet<String>();

		try {
			for(String a : A.getModuleEntity()) {
				union.add(a);
				for(String b : B.getModuleEntity()) {
					if(a.equals(b)) intersection.add(a);
					union.add(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		result = 1.0 * intersection.size() / union.size();
		return result; 
	}

	private String modifyString(String s) {
		String mod = "";
		if(s != null) {
			String[] array = s.split(" ");
			if(null != array) {
				for(int i = 0; i < array.length; i++){
					mod += array[i].replaceAll("[^\\p{L}]", "_");
					if(i != (array.length - 1)) mod += "_";
				}
			}
		}
		return mod;
	}

	public void createDotFile(Collection<Module> modules) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("modules.dot", false));
			out.write("digraph {" + "\n");
			for(Module module : modules) {
				String p = modifyString(module.getName());
				if(module.getChildren().size() > 0)
					for(Module child : module.getChildren()) {
						String c = modifyString(child.getName());
						if(!p.equals(c))
							out.write(p + " -> " + c + "\n");
					}
				else out.write(p + "\n");
			}
			out.write("}");
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void generateMap(String fileName) {		
		try {      	
			String cmdline[] = {"/usr/bin/dot", "-Tpdf", fileName + ".dot", ">", fileName + ".pdf"};
			Process p = Runtime.getRuntime().exec(cmdline);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}