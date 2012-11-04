package modules.testData;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import modules.NLPParsing.Sentence;
import modules.entities.Course;
import opennlp.tools.util.InvalidFormatException;

/**
 * ToyData that has all the information cleanly. This class will be used in NLP as if we have perfectly structured data
 * @author Albert
 *
 */
public class ToyData {
	List<Course> courseList;
	
	public ToyData() throws InvalidFormatException, IOException {
		courseList = new LinkedList<Course>();
		generateToyCourse();
	}
	/**
	 * UCSD courses list
	 *  it contains ALL coures related to bio in UCSD
	 *  This means, it contains lower division(ones you take in 1st,2nd year), upper division which include courses with following focus:
	 * 	Biochemistry
	 * 	Genetics, Cellular and Developmental Biology of Plants and Animals
	 * 	Ecology, Behavior, and Evolution
	 * 	Molecular Biology, Microbiology
	 * 	Physiology and Neuroscience
	 * 	Special Courses
	 * 	Graduate
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * 
	 */
	public void generateToyCourse() throws InvalidFormatException, IOException{
		//Lower Division

		Course c0 = new Course.Builder("ucsd").courseNum("BILD 1").name("The Cell").desc("An introduction to cellular structure and function, to biological molecules, bioenergetics, to the genetics of both procaryotic and eucaryotic organisms, and to the elements of molecular biology. Three hours of lecture and one hour of recitation. Prerequisites: Chem 6A; Chem 6B may be taken concurrently.").build();
		courseList.add(c0);

		Course c1 = new Course.Builder("ucsd").courseNum("BILD 2").name("Multicellular Life").desc("An introduction to the development and the physiological processes of plants and animals. Included are treatments of reproduction, nutrition, respiration, transport systems, regulation of the internal environment, the nervous system, and behavior. Three hours of lecture and one hour of recitation. Prerequisites: BILD 1.").build();
		courseList.add(c1);

		Course c2 = new Course.Builder("ucsd").courseNum("BILD 3").name("Organismic and Evolutionary Biology").desc("The first principles of evolutionary theory, classification, ecology, and behavior; a phylogenetic synopsis of the major groups of organisms from viruses to primates. Prerequisites: none. (Note: EBE majors should complete this course during their first year at UC San Diego.)").build();
		courseList.add(c2);

		Course c3 = new Course.Builder("ucsd").courseNum("BILD 7").name("The Beginning of Life").desc("An introduction to the basic principles of plant and animal development, emphasizing the similar strategies by which diverse organisms develop. Practical applications of developmental principles as well as ethical considerations arising from these technologies will be discussed. Prerequisites: none.").build();
		courseList.add(c3);

		Course c4 = new Course.Builder("ucsd").courseNum("BILD 10").name("Fundamental Concepts of Modern Biology").desc("An introduction to the biochemistry and genetics of cells and organisms; illustrations are drawn from microbiology and human biology. Three hours of lecture and one hour of discussion. This course is designed for nonbiology students and does not satisfy a lower-division requirement for any biology major. Note: Students may not receive credit for BILD 10 after receiving credit for BILD 1.").build();
		courseList.add(c4);

		Course c5 = new Course.Builder("ucsd").courseNum("BILD 12").name("Neurobiology and Behavior").desc("An introduction to the organization and functions of the nervous system; topics include molecular, cellular, developmental, systems, and behavioral neurobiology. Three hours of lecture and one hour of discussion. This course is designed for nonbiology students and does not satisfy a lower-division requirement for any biology major.").build();
		courseList.add(c5);

		Course c6 = new Course.Builder("ucsd").courseNum("BILD 16").name("History of Life").desc("Life has a very long history on earth and this course will chronicle patterns of biological diversity from its origin over three billion years ago to the present day. Topics covered will include methods for reconstructing the history of life on this planet, the origin and evolution of major groups of plants and animals, dinosaur paleobiology, past environmental changes and their effects on species and communities, and extinctions. We will also explore how insights from the past can be used to understand how present and future environmental changes will impact biological diversity. This course is designed for nonbiology majors.").build();
		courseList.add(c6);

		Course c7 = new Course.Builder("ucsd").courseNum("BILD 18").name("Human Impact on the Environment").desc("Course will focus on issues such as global warming, species extinction, and human impact on the oceans and forests. History and scientific projections will be examined in relation to these events. Possible solutions to these worldwide processes and a critical assessment of their causes and consequences will be covered. Prerequisites: none.").build();
		courseList.add(c7);

		Course c8 = new Course.Builder("ucsd").courseNum("BILD 20").name("Human Genetics in Modern Society").desc("Fundamentals of human genetics and introduction to modern genetic technology such as gene cloning and DNA finger printing. Applications of these techniques, such as forensic genetics, genetic screening, and genetic engineering. Social impacts and ethical implications of these applications. This course is designed for nonbiology students and does not satisfy a lower-division requirement for any biology major. Note: Students may not receive credit for BILD 20 after receiving credit for BICD 100.").build();
		courseList.add(c8);

		Course c9 = new Course.Builder("ucsd").courseNum("BILD 22").name("Human Nutrition").desc("A survey of our understanding of the basic chemistry and biology of human nutrition; discussions of all aspects of food: nutritional value, diet, nutritional diseases, public health, and public policy. This course is designed for nonbiology students and does not satisfy a lower-division requirement for any biology major. Note: Students may not receive credit for BILD 22 after receiving credit for BIBC 120.").build();
		courseList.add(c9);

		Course c10 = new Course.Builder("ucsd").courseNum("BILD 24").name("Biology of Human Reproduction").desc("The topics covered are: sexual development in embryo and fetus, the nature and regulation of changes at puberty, the functioning of the mature sexual system. This course is designed for nonbiology students and does not satisfy a lower-division requirement for any biology major. Note: Students may not receive credit for BILD 24 after receiving credit for BICD 134.").build();
		courseList.add(c10);

		Course c11 = new Course.Builder("ucsd").courseNum("BILD 26").name("Human Physiology").desc("Introduction to the elements of human physiology and the functioning of the various organ systems. The course presents a broad, yet detailed, analysis of human physiology, with particular emphasis towards understanding disease processes. Three hours of lecture and one hour of discussion. This course is designed for nonbiology students and does not satisfy a lower-division requirement for any biology major.").build();
		courseList.add(c11);


		Course c12 = new Course.Builder("ucsd").courseNum("BILD 36").name("AIDS Science and Society").desc("An introduction to all aspects of the AIDS epidemic. Topics include the epidemiology, biology, and clinical aspects of HIV infection; HIV testing; education and approaches to therapy; and the social, political, and legal impacts of AIDS on the individual and society. Students may not receive credit for BILD 36 after receiving credit for BICD 136.").build();
		courseList.add(c12);

		Course c13 = new Course.Builder("ucsd").courseNum("BILD 38").name("Dementia, Science, and Society").desc("Introduction to basic human neuroscience leading to a discussion of brain diseases classified under the rubric Dementia. Topics include basic brain structure and function, diseases of the aging brain and their economic, social, political and ethical impacts on society.").build();
		courseList.add(c13);

		Course c14 = new Course.Builder("ucsd").courseNum("BILD 87").name("Freshman Seminar").desc("The freshman seminar program is designed to provide new students with the opportunity to explore an intellectual topic with a faculty member in a small seminar setting. Freshmen seminars are offered in all campus departments and undergraduate colleges, and topics vary from quarter to quarter. Enrollment is limited to fifteen to twenty students, with preference given to entering freshmen.").build();
		courseList.add(c14);

		Course c15 = new Course.Builder("ucsd").courseNum("BILD 91").name("Biology Freshmen: Strategies for Success").desc("Course is designed to assist new freshmen in making a smooth and informed transition from high school. Lectures focus on study skills, academic planning and using divisional and campus resources to help achieve academic, personal and professional goals. Exercises and practicums will develop the problems solving skills needed to succeed in biology. Attention will be given to research possibilities. Intended for new freshmen.").build();
		courseList.add(c15);

		Course c16 = new Course.Builder("ucsd").courseNum("BILD 92").name("Professional Development Topics in the Biological Sciences  ").desc("Seminars will introduce students to various professional development topics in the biological sciences. Emphasis may include current research in academe and industry, using campus and community resources to help achieve academic, personal and professional goals, and career exploration. Activities may include presentations by faculty, alumni, and practicing professional biologists, as well as panel discussions with professionals from industry.").build();
		courseList.add(c16);

		Course c17 = new Course.Builder("ucsd").courseNum("BILD 94").name("Professional Issues in Bioinformatics").desc("This seminar will introduce undergraduate students, especially freshmen and sophomores, to a variety of issues and topics in the field of bioinformatics.").build();
		courseList.add(c17);

		Course c18 = new Course.Builder("ucsd").courseNum("BILD 95").name("Undergraduate Workshops").desc("The workshops will be restricted to lower-division undergraduates. The course will introduce students to the methods of scientific research and to a variety of research topics in the biological/biomedical sciences. Examples of topics are: Introduction to Scientific Research, AIDS, Medical and Social Aspects, Is the Mind the Same as the Brain, Wildlife Conservation.").build();
		courseList.add(c18);

		Course c19 = new Course.Builder("ucsd").courseNum("BILD 96").name("Biology: Honors Seminar").desc("Weekly seminar providing Biological Sciences Scholars Program students with the opportunity to learn more about research and scholarly activities available to them, and acquaints them with UC San Diego faculty members. The course will promote student��s participation in research and other scholarly activities on campus. Departmental approval only (department will preauthorize students to enroll).").build();
		courseList.add(c19);

		Course c20 = new Course.Builder("ucsd").courseNum("BILD 99").name("Independent Research").desc("Independent research by special arrangement with a faculty member. (P/NP grades only.) Students must have an overall UC San Diego GPA of at least 3.0 and a minimum of thirty units complete. Students must complete a Special Studies form and a Division of Biological Sciences Research Plan. Credit may not be received for a course numbered 99 subsequent to receiving credit for a course numbered 199.").build();
		courseList.add(c20);

		//Upper Division

		//Biochemistry

		Course c21 = new Course.Builder("ucsd").courseNum("BIBC 100").name("Structural Biochemistry").desc("The structure and function of biomolecules. Includes protein conformation, dynamics, and function; enzymatic catalysis, enzyme kinetics, and allosteric regulation; lipids and membranes; sugars and polysaccharides; and nucleic acids. Prerequisites: Chem 140A and Chem 140B. (Note: Students may not receive credit for both BIBC 100 and Chem 114A.)").build();
		courseList.add(c21);

		Course c22 = new Course.Builder("ucsd").courseNum("BIBC 102").name("Metabolic Biochemistry").desc("Energy-producing pathways glycolysis, the TCA cycle, oxidative phosphorylation, photosynthesis, and fatty acid oxidation; and biosynthetic pathways gluconeogenesis, glycogen synthesis, and fatty acid biosynthesis. Nitrogen metabolism, urea cycle, amino acid metabolism, nucleotide metabolism, and metabolism of macromolecules. Prerequisites: Chem 140A and Chem 140B. (Note: Students may not receive credit for both BIBC 102 and Chem 114B.)").build();
		courseList.add(c22);

		Course c23 = new Course.Builder("ucsd").courseNum("BIBC 103").name("Biochemical Techniques").desc("Introductory laboratory course in current principles and techniques applicable to research problems in biochemistry and molecular biology. Techniques include protein and nucleic acid purification; identification methods such as centrifugation, chromatography, and electrophoresis; immunological, spectrophotometric, and enzymatic methods. Prerequisites: BILD 1. Students may not receive credit for BIBC 103 after taking Chem 112A (renumbered to Chem 108). Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c23);

		Course c24 = new Course.Builder("ucsd").courseNum("BIBC 104").name("Biochemistry and Biotechnology of Plants").desc("The biochemical and molecular basis of plant genetic engineering to understand modern approaches to crop improvement. Prerequisites: BILD 1; Chem 140A. BIBC 102 and Chem 140B may be taken concurrently.").build();
		courseList.add(c24);

		Course c25 = new Course.Builder("ucsd").courseNum("BIBC 110").name("Physical Biochemistry").desc("The theory and applications of physical chemistry to biological molecules, process and systems and techniques used in biochemistry and physiology. Topics include reversible and irreversible thermodynamics, bioenergetics, energy coupling and transduction, solutions of macromolecules, sedimention, chromatography, electrophoresis, passive and active membrane transport, spectroscopy, and chemical kinetics. Three hours of lecture and one hour of recitation. Prerequisites: calculus and organic chemistry.").build();
		courseList.add(c25);

		Course c26 = new Course.Builder("ucsd").courseNum("BIBC 120").name("Nutrition").desc("Elaborates the relationship between diet and human metabolism, physiology, health, and disease. Covers the functions of carbohydrates, lipids, proteins, vitamins, and minerals, and discusses dietary influences on cardiovascular disease, diabetes, obesity, and cancer. Prerequisites: BIBC 102.").build();
		courseList.add(c26);

		Course c27 = new Course.Builder("ucsd").courseNum("BIBC 140").name("Introduction to Biofuels").desc("Course will provide an overview of the growing field of biofuels by introducing the basics of renewable biofuel production, including the chemistry of biofuels, the biology of important feedstocks, and the biochemical advances for the next generation of biofuels. Prerequisites: BILD 1.").build();
		courseList.add(c27);

		//Genetics, Cellular and Developmental Biology of Plants and Animals

		Course c28 = new Course.Builder("ucsd").courseNum("BICD 100").name("Genetics").desc("An introduction to the principles of heredity emphasizing diploid organisms. Topics include Mendelian inheritance and deviations from classical Mendelian ratios, pedigree analysis, gene interactions, gene mutation, linkage and gene mapping, reverse genetics, population genetics, and quantitative genetics. Prerequisites: BILD 1.").build();
		courseList.add(c28);

		Course c29 = new Course.Builder("ucsd").courseNum("BICD 101").name("Eucaryotic Genetics Laboratory").desc("Students will implement forward and reverse genetic methodologies widely used in contemporary biological research, focusing primarily on model organisms. Lab work is complemented by computer work that includes utilization of genome sequence databases and basic bioinformatics. Prerequisites: BIMM 100. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c29);

		Course c30 = new Course.Builder("ucsd").courseNum("BICD 110").name("Cell Biology").desc("The structure and function of cells and cell organelles, cell growth and division, motility, cell differentiation and specialization. Prerequisites: BIBC 100 or BIBC 102.").build();
		courseList.add(c30);

		Course c31 = new Course.Builder("ucsd").courseNum("BICD 111").name("Cell Biology Laboratory").desc("A laboratory course in the application of cellular techniques to biological problems. The establishment, growth, transformation, immortalization, and senescence of mammalian cells will be studied at the molecular and the cellular level. Ten hours of laboratory. In addition to the formal lab hours listed above, there will be an average of two hours in which students will be required to work in the class laboratory to complete experiments and prepare for presentations. Prerequisites: BICD 110 (may be taken concurrently); BIBC 103 is strongly recommended. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c31);

		Course c32 = new Course.Builder("ucsd").courseNum("BICD 118").name("Pathways of Intracellular Protein Trafficking and Compartmentation").desc("This course will focus on various subcellular organelles, their function, protein traffic, disulfide bond formation, protein folding, assembly of macromolecular complexes, protein quality control, and cellular responses to misfolded proteins. The emphasis will be on experimental approaches and model systems for the analyses of these problems and on the connection of these topics to human disease. Three hours of lecture and one hour of mandatory discussion of primary publications per week. Open to upper-division students only. Prerequisites: BICD 110 and BIMM 100.").build();
		courseList.add(c32);

		Course c33 = new Course.Builder("ucsd").courseNum("BICD 120").name("Fundamentals of Plant Biology").desc("Introduction to the biology of plants. Basic principles of plant anatomy, physiology, development, and diversity will be covered as well as specialized topics, including plant genetic engineering, plant disease and stress, plants and the environment, and sustainable agriculture. Prerequisites: BILD 1 and BILD 2 or BILD 3.").build();
		courseList.add(c33);

		Course c34 = new Course.Builder("ucsd").courseNum("BICD 123").name("Plant Molecular Genetics and Biotechnology Laboratory").desc("Techniques in plant cell and tissue culture, plant transformation, genetic selection and screening of mutants, host pathogen interactions, gene regulation, organelle isolation, membrane transport. Two hours of lecture and eight hours of laboratory each week. Prerequisites: upper-division standing; BICD 120 strongly recommended. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c34);

		Course c35 = new Course.Builder("ucsd").courseNum("BICD 130").name("Embryos, Genes, and Development").desc("Developmental biology of animals at the tissue, cellular, and molecular levels. Basic processes of embryogenesis in a variety of invertebrate and vertebrate organisms. Cellular and molecular mechanisms that underlie cell fate determination and cell differentiation. More advanced topics such as pattern formation and sex determination are discussed. Open to upper-division students only. Three hours of lecture and one hour of recitation. Prerequisites: upper-division standing; BICD 100; BIBC 100 or BIBC 102; BICD 110 strongly recommended, BIMM 100 strongly recommended.").build();
		courseList.add(c35);

		Course c36 = new Course.Builder("ucsd").courseNum("BICD 131").name("Embryology Laboratory").desc("Descriptive and experimental embryology of various animal species. One and one-half hours of lecture and ten hours of laboratory each week Prerequisites: BILD 1; BILD 2. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c36);

		Course c37 = new Course.Builder("ucsd").courseNum("BICD 134").name("Human Reproduction and Development").desc("This course is addressed to the development of the human sexual system, including gametogenesis, fertilization, and embryo implantation. Emphasis is placed on the physiology of reproductive functions. Three hours of lecture and one hour of discussion. Prerequisites: BIBC 102 and BICD 100.").build();
		courseList.add(c37);

		Course c38 = new Course.Builder("ucsd").courseNum("BICD 136").name("AIDS Science and Society").desc("An introduction to all aspects of the AIDS epidemic. Topics will include the epidemiology, biology, and clinical aspects of HIV infection, HIV testing, education and approaches to therapy, and the social, political, and legal impacts of AIDS on the individual and society. In order to count for their major, biology majors must take the upper-division course, BICD 136. Prerequisites: BILD 1, BILD 2 recommended.").build();
		courseList.add(c38);

		Course c39 = new Course.Builder("ucsd").courseNum("BICD 140").name("Immunology").desc("Formation and function of the mammalian immune system, molecular and cellular basis of the immune response, infectious diseases and autoimmunity. Prerequisites: BICD 100, BIMM 100. BIBC 100 recommended.").build();
		courseList.add(c39);

		Course c40 = new Course.Builder("ucsd").courseNum("BICD 145").name("Laboratory in Molecular Medicine").desc("This course focuses upon a molecular and immunological approach to study problems in modern medical research. The emphasis will be on novel approaches in medicine, including lymphocyte biology, cancer biology, and gene transfer. Prerequisites: BIBC 103, BIMM 100. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c40);

		Course c41 = new Course.Builder("ucsd").courseNum("BICD 150").name("Endocrinology").desc("Normal function and diseases of the major hormone systems of the body including the hypothalamus/pituitary axis, the thyroid gland, reproduction and sexual development, metabolism and the pancreas, bone and calcium metabolism, and the adrenal glands. Prerequisites: BIPN 100 (may be taken concurrently).").build();
		courseList.add(c41);

		//Ecology, Behavior, and Evolution

		Course c42 = new Course.Builder("ucsd").courseNum("BIEB 100").name("Biostatistics").desc("An interactive introduction to statistical inference and hypothesis testing. Emphasis on the conceptual and logical basis of statistical methods. Topics include describing data, generating hypotheses, sampling, significance, and randomization. The computer language R will be used. Mandatory weekly section. Prerequisites: BILD 3 and Math 10A or 20A and Math 10B or 20B. Students may not receive credit for both BIEB 100 and SIO 187.").build();
		courseList.add(c42);

		Course c43 = new Course.Builder("ucsd").courseNum("BIEB 102").name("Introductory Ecology-Organisms and Habitat").desc("This course emphasizes principles shaping organisms, habitats, and ecosystems. Topics covered include population regulation, physiological ecology, competition, predation, and human exploitation. This will be an empirical look at general principles in ecology and conservation with emphasis on the unique organisms and habitats of California. Prerequisites: BILD 3 or equivalent.").build();
		courseList.add(c43);

		Course c44 = new Course.Builder("ucsd").courseNum("BIEB 121").name("Ecology Laboratory").desc("A laboratory course to familiarize students with ecological problem solving and methods. Students will perform outdoor fieldwork and use the Macintosh computer for data exploration and analysis. Two hours of lecture and eight hours of laboratory each week. Prerequisites: BIEB 100. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c44);

		Course c45 = new Course.Builder("ucsd").courseNum("BIEB 123").name("Molecular Methods in Ecology and Evolution Lab").desc("Theory and practice of molecular biology techniques used in ecological and evolutionary research. Includes isolation of DNA and RNA, PCR and its applications, DNA sequencing, gene expression analysis, bioinformatics, and ecological and evolutionary analysis of molecular data. Students may not enroll in or receive credit for both BIMM 101 and BIEB 123. Prerequisites: BILD 3. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c45);

		Course c46 = new Course.Builder("ucsd").courseNum("BIEB 126").name("Plant Ecology").desc("This course begins with an introduction to plant population biology including whole-plant growth and physiology. We then focus on three classes of ecological interactions: plant-plant competition, plant-herbivore coevolution, and plant reproductive ecology including animal pollination and seed dispersal. Prerequisites: BILD 3.").build();
		courseList.add(c46);

		Course c47 = new Course.Builder("ucsd").courseNum("BIEB 128").name("Insect Ecology").desc("This course begins with a survey of insect diversity and phylogenetic relationships. We then address ecological issues including thermal ecology, population dynamics (including outbreaks), movement and migration, competition, predation, herbivory, parasitism, insect defense, mimicry complexes, and sociality. Prerequisites: BILD 3 or equivalent.").build();
		courseList.add(c47);

		Course c48 = new Course.Builder("ucsd").courseNum("BIEB 131").name("Marine Invertebrate Ecology Laboratory").desc("A laboratory course introducing students to coastal marine ecology. Students will participate in outdoor fieldwork and work in the laboratory gathering and analyzing ecological data. We will focus on ecological communities from a variety of coastal habitats and use them to learn about basic ecological processes as well as issues related to sustainability and conservation of biodiversity. Fieldwork is expected in this course. Associated travel in the San Diego area is required and students are responsible for their own transportation. Material lab fee may apply. Prerequisites: BILD 3 and BIEB 100.").build();
		courseList.add(c48);

		Course c49 = new Course.Builder("ucsd").courseNum("BIEB 136").name("Ichthyology").desc("Course will study aspects of the biology of fishes from all over the world, from the crushing pressure of the deep sea to the chilling temperatures of Antarctic waters. Students will learn about form/function that allow fishes to thrive in diverse marine environments. Students will conduct an independent field project. Field trips may be required. Prerequisites: BILD 3 recommended.").build();
		courseList.add(c49);

		Course c50 = new Course.Builder("ucsd").courseNum("BIEB 140").name("Biodiversity").desc("An introduction to the patterns of geographic distribution and natural history of plants and animals living in terrestrial and marine ecosystems. We will explore: ecological and evolutionary processes responsible for generating and maintaining biological diversity; and the nature of extinction both in past and present ecosystem. Prerequisites: BILD 3.").build();
		courseList.add(c50);

		Course c51 = new Course.Builder("ucsd").courseNum("BIEB 143").name("Computer Modeling in Evolution and Ecology").desc("An introduction to computer modeling in evolution and ecology. Students will use the computer language Python to write code to analyze ecological and evolutionary processes. Topics include natural selection, genetic drift, community ecology, game theory, and chaos. Students will use their own laptop computers. Prerequisites: BIEB 100 or BIEB 150.").build();
		courseList.add(c51);

		Course c52 = new Course.Builder("ucsd").courseNum("BIEB 145").name("Spatial Analyses in Ecology and Conservation").desc("Course familiarizes students with the concept and application of geographic analyses in biology and, specifically, the use of GIS as analytical tool. Example studies will be performed that range from global ecology to conservation in San Diego County. Prerequisites: BILD 3, BIEB 100, BIEB 102. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c52);

		Course c53 = new Course.Builder("ucsd").courseNum("BIEB 150").name("Evolution").desc("Evolutionary processes are discussed in their genetic, historical, and ecological contexts. Population genetics, agents of evolution, microevolution, speciation, macroevolution. Prerequisites: BILD 1 and BILD 3.").build();
		courseList.add(c53);

		Course c54 = new Course.Builder("ucsd").courseNum("BIEB 156").name("Population Genetics").desc("Course on empirical and theoretical population genetics. The goal is to review basic models of population genetics, empirical tests of these models and gain intuitions about the population-level processes underlying genome evolution, phenotypic change and the origin of new species. A working knowledge of basic molecular genetics, algebra, and statistics is assumed. Prerequisites: BICD 100.").build();
		courseList.add(c54);

		Course c55 = new Course.Builder("ucsd").courseNum("BIEB 159").name("Advanced Field Ecology Lab").desc("Course will familiarize students with the design, performance, analysis, and presentation of ecological experiments. Students will perform two field studies; one with terrestrial insects, the other with plant biodiversity. Field work in Mexico required during ��spring break�� for spring course and week prior to fall quarter for fall course. Students will continue on campus with lectures and laboratory sessions. Prerequisites: BIEB 100; departmental approval only (department will preauthorize student to enroll); restricted to students participating in NSF/REU program.").build();
		courseList.add(c55);

		Course c56 = new Course.Builder("ucsd").courseNum("BIEB 164").name("Behavioral Ecology").desc("A survey of the patterns of social behavior in animals and a discussion of the ecological principles underlying the evolution of animal societies. Three hours of lecture and one hour of discussion. Prerequisites: BILD 3 recommended.").build();
		courseList.add(c56);

		Course c57 = new Course.Builder("ucsd").courseNum("BIEB 165").name("Behavioral Ecology Laboratory").desc("This course deals with quantitative methods for the study of animal social behaviors. Topics include spatial patterns, mating systems, and cooperation. The course includes both lab exercises and field trips. Two hours of lecture and eight hours of laboratory each week Prerequisites: BIEB 100 and BIEB 164. (BIEB 164 may be taken concurrently.) Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c57);

		Course c58 = new Course.Builder("ucsd").courseNum("BIEB 166").name("Animal Behavior and Communication").desc("An integrated approach to animal behavior focusing on mechanisms of acoustic, visual, and olfactory communication. Course covers ethology and the genetics and neurobiology of behavior; orientation and navigation; and signal origins, properties, design, and evolution. Prerequisites: BILD 3 and Physics 1A or 2A.").build();
		courseList.add(c58);

		Course c59 = new Course.Builder("ucsd").courseNum("BIEB 167").name("Animal Communication Laboratory").desc("Laboratory exercises will introduce students to quantitative methods of visual, auditory, and olfactory signal analysis and to lab and field studies of animal signaling. Two hours of lecture and eight hours of laboratory each week. In addition to the formal lab hours, there will be at least nine hours in which students will be required to work in the class laboratory to complete experiments and prepare for presentations. Prerequisites: BIEB 100 and BIEB 166. (BIEB 166 may be taken concurrently.) Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c59);

		Course c60 = new Course.Builder("ucsd").courseNum("BIEB 174").name("Ecosystems and Global Change").desc("Course will teach the principles of terrestrial ecosystem ecology, and will use examples from recent research to help students understand how global environmental changes are altering processes from leaf-level ecophysiology to global cycling of carbon, water, and nutrients. Fieldwork may be required. Prerequisites: BILD 3.").build();
		courseList.add(c60);

		Course c61 = new Course.Builder("ucsd").courseNum("BIEB 176").name("Conservation and the Human Predicament").desc("(Cross-listed with ANTH/BIO 132; however, biology majors must take the course as Biology 176.) An interdisciplinary discussion of the human predicament, the biodiversity crisis, and the importance of biological and environmental conservation. Examines issues from biological, cultural, historical, economic, social, political, and ethical perspectives emphasizing new approaches and new techniques for safeguarding the future of humans and other biosphere inhabitants. Prerequisites: upper-division standing and BILD 3 or consent of instructor.").build();
		courseList.add(c61);

		//Molecular Biology, Microbiology

		Course c62 = new Course.Builder("ucsd").courseNum("BIMM 100").name("Molecular Biology").desc("Molecular basis of biological processes, emphasizing gene action in context of entire genome. Chromosomes and DNA metabolism: chromatin, DNA replication, repair, mutation, recombination, transposition. Transcription, protein synthesis, regulation of gene activity. Procaryotes and eucaryotes Prerequisites: BIBC 100 or BIBC 102, BICD 100. (Note: Students may not receive credit for both BIMM 100 and Chem 114C.)").build();
		courseList.add(c62);

		Course c63 = new Course.Builder("ucsd").courseNum("BIMM 101").name("Recombinant DNA Techniques").desc("Theory and practice of recombinant DNA and molecular biology techniques. Includes construction and screening of DNA libraries, DNA sequencing, PCR and its applications, bioinformatics, and RNA analysis. Prerequisites: BILD 1. Students may not enroll in or receive credit for both BIMM 101 and BIEB 123, or BIMM 101 and Chem 109 (formerly Chem 112B). BIMM 100 recommended.").build();
		courseList.add(c63);

		Course c64 = new Course.Builder("ucsd").courseNum("BIMM 108").name("Adventures in Chromatin Structure and Gene Expression").desc("Chromatin, the natural state of DNA in eukaryotes, has recently emerged as a critical component of many important biological processes. Topics include histone modifications, chromatin dynamics, transcription factors, enhancers, CpG methylation, heterochromatin, epigenetics, and the role of chromatin in human biology. Prerequisites: BIMM 100.").build();
		courseList.add(c64);

		Course c65 = new Course.Builder("ucsd").courseNum("BIMM 110").name("Molecular Basis of Human Disease").desc("An examination of the molecular basis of human diseases. Course emphasizes inherited human disorders, and some important diseases caused by viruses. Focus on the application of genetic, biochemical, and molecular biological principles to an understanding of the diseases. Three hours of lecture. Course restricted to upper-division biology majors. Prerequisites: BICD 100; BIBC 102; BIMM 100.").build();
		courseList.add(c65);

		Course c66 = new Course.Builder("ucsd").courseNum("BIMM 112").name("Regulation of Gene Activity in Eucaryotic Cells").desc("This course explores problems in the regulation of gene activity in eucaryotic cells approached at the molecular level. The course includes the organization, structure, transcription, and regulation of eucaryotic genes; mechanism of hormonal regulation in controlling gene activity; induction of gene expression in eucaryotic cells; role of signal transduction in controlling gene expression; and regulation of gene activity during differentiation in developing systems. Examples are taken from eucaryotic microorganisms, invertebrates, as well as mammalian and other vertebrate systems. Three hours of lecture and one hour of discussion. Prerequisites: BIMM 100.").build();
		courseList.add(c66);

		Course c67 = new Course.Builder("ucsd").courseNum("BIMM 114").name("Virology").desc("An introduction to eucaryotic virology, with emphasis on animal virus systems. Topics discussed include the molecular structure of viruses; the multiplication strategies of the major virus families; and viral latency, persistence, and oncology. Three hours of lecture and one hour of discussion. Prerequisites: BIMM 100.").build();
		courseList.add(c67);

		Course c68 = new Course.Builder("ucsd").courseNum("BIMM 116").name("Circadian Rhythms-Biological Clocks").desc("(Cross-listed with Psych 133; however, biology majors must take the course as BIMM 116.) Examples and fundamental properties of the daily biological clock in humans, animals, and microbes. Experimental approaches employed to understand how organisms keep time and how this applies to human health. Prerequisites: BILD 1 or Psych 106 or consent of instructor.").build();
		courseList.add(c68);

		Course c69 = new Course.Builder("ucsd").courseNum("BIMM 118").name("Pharmacology").desc("Basics of pharmacology such as drug absorption, distribution, metabolism, and elimination. Concepts in toxicology and pharmacognosy are used to survey the major drug categories. Prerequisites: BIBC 100 or BIBC 102; BIPN 100.").build();
		courseList.add(c69);

		Course c70 = new Course.Builder("ucsd").courseNum("BIMM 120").name("Bacteriology").desc("A discussion of the structure, growth, molecular genetics, and physiology of procaryotic microorganisms, with emphasis on the diverse activities of bacteria and on the interaction of various bacterial species with their environment. Three hours of lecture and one hour recitation. Prerequisites: Chem 140A; Chem 140B; BIBC 100 or BIBC 102 (may be taken concurrently).").build();
		courseList.add(c70);

		Course c71 = new Course.Builder("ucsd").courseNum("BIMM 121").name("Laboratory in Microbiology").desc("Course emphasizes fundamental principles of microbiology, including comparative bacterial morphology and physiology, pure culture techniques, and bacterial growth. Additional studies include bacteriophage interactions, antibiotics, the use of bio-assays, natural microbial communities through metagenomics and enrichment, and bacteria in biotechnology. Prerequisites: BIBC 102 or BIMM 120 strongly recommended; upper-division standing.").build();
		courseList.add(c71);

		Course c72 = new Course.Builder("ucsd").courseNum("BIMM 122").name("Microbial Genetics").desc("Course will consider the organization and function of prokaryotic genomes including content, DNA supercoiling, histone-like proteins, chromosomal dynamics (short-term and long-term), extrachromosomal elements, bacterial sex, transduction, transformation, mobile elements (transposon), epigenetic change, adaptive and directed mutation, transcription and its regulation, sensory transduction, bacterial differentiation, symbiosis, and pathogenesis. Prerequisites: BICD 100.").build();
		courseList.add(c72);

		Course c73 = new Course.Builder("ucsd").courseNum("BIMM 124").name("Medical Microbiology").desc("Encompasses the increasingly important areas of viral, bacterial, and parasitic diseases and understanding the complex interaction between humans and infectious agents. Covers human-pathogen interactions, mechanisms and molecular principles of infectious diseases, immune responses, countermeasures by pathogens and hosts, epidemiology, and cutting-edge approaches to therapy. Prerequisites: BIBC 100 or BIBC 102 recommended; upper-division standing.").build();
		courseList.add(c73);

		Course c74 = new Course.Builder("ucsd").courseNum("BIMM 130").name("Microbial Physiology").desc("Prokaryotic cell biology will be discussed primarily from physiological and biochemical standpoints with a focus on conceptual understanding, integration, and mechanism. Topics will vary from year to year but will include the following themes: bioenergetics, cell polarity, cell adhesion, the molecular basis of morphogenesis and differentiation, prokaryotic motility and behavior, rotary and linear molecular machines, bacterial organelles, pheromones and messengers, circadian rhythms, biological warfare, and bioremediation. Prerequisites: BIBC 100 or BIBC 102.").build();
		courseList.add(c74);

		Course c75 = new Course.Builder("ucsd").courseNum("BIMM 132").name("Molecular Biology of Human Retroviruses").desc("Replication cycle and gene regulation of HIV. Molecular approaches to therapy and vaccines. Three hours of lecture. Prerequisites: BIMM 100.").build();
		courseList.add(c75);

		Course c76 = new Course.Builder("ucsd").courseNum("BIMM 134").name("Biology of Cancer").desc("This course covers basic processes of transformation and tumor formation in a two-part format. The first section is focused on molecular and cellular mechanisms of carcinogenesis. The second section discusses tumor pathology and metastasis. Open to upper-division students only. Prerequisites: BICD 110 and BIMM 100.").build();
		courseList.add(c76);

		Course c77 = new Course.Builder("ucsd").courseNum("BIMM 162").name("3D Electron Microscopy of Macromolecules").desc("Biological macromolecules and supramolecular complexes, organelles, and small cells are being examined in three-dimensions by modern electron cryomicroscopy and image reconstruction techniques. The basic principles of transmission electron microscopy and 3D image reconstruction are discussed. Prerequisites: Chem 114A or BIBC 100 or BIBC 110 and Physics 1C or 2C or 2D; upper-division standing.").build();
		courseList.add(c77);

		Course c78 = new Course.Builder("ucsd").courseNum("BIMM 164").name("Structural Biology of Viruses").desc("An introduction to virus structures, how they are determined, and how they facilitate the various stages of the viral life cycle from host recognition and entry to replication, assembly, release, and transmission to uninfected host cells. Prerequisites: BIBC 100 or Chem 114A; upper-division standing.").build();
		courseList.add(c78);

		Course c79 = new Course.Builder("ucsd").courseNum("BIMM 166").name("Environmental and Molecular Toxicology").desc("(Cross-listed with Chem 166; conjoined with BGGN 256, BIOM 266, and Chem 266.) This course will investigate approaches to study the impact of environmental toxicants on human health. Other modern approaches that are being implemented to detect and remediate environmental toxicants will also be examined. Graduate students will be required to complete an additional paper and/or exam beyond that expected of undergraduate students. Prerequisites: upper-division standing for BIMM 166 and Chem 166; graduate standing for BGGN 256, BIOM 266, and Chem 266.").build();
		courseList.add(c79);

		Course c80 = new Course.Builder("ucsd").courseNum("BIMM 171").name("Genomics Research Initiative").desc("This class will examine the theoretical and practical basis of modern genomics research. Students will learn the theoretical basis of genomics and tools used for the sequencing and annotation of genomic DNA, and computational and molecular methods for the study of evolution. Prerequisites: departmental approval required (department will preauthorize students to enroll). Restricted to students participating in the National Genomics Research Initiative Program.").build();
		courseList.add(c80);

		Course c81 = new Course.Builder("ucsd").courseNum("BIMM 171A").name("Genomics Research Initiative Laboratory I").desc("Students will isolate bacterial viruses or other organisms from the environment and characterize them by methods including electron microscopy and nucleic acid analysis. The genomic DNA will be purified, and sent for sequencing. Prerequisites: departmental approval required. Restricted to students participating in the National Genomics Research Initiative Program.").build();
		courseList.add(c81);

		Course c82 = new Course.Builder("ucsd").courseNum("BIMM 171B").name("Genomics Research Initiative Laboratory II").desc("Students will characterize the genomic sequence of the organisms isolated in BIMM 171A and use molecular and computational tools to resolve ambiguities and close gaps. They will then annotate the DNA sequence to identify protein and RNA coding regions. Prerequisites: BIMM 171 and BIMM 171A.").build();
		courseList.add(c82);

		Course c83 = new Course.Builder("ucsd").courseNum("BIMM 171C").name("Genomics Research Initiative Laboratory III").desc("Computational methods will be used to characterize the annotated genome sequence produced in BIMM 171A-B to study the evolution of genes and their products. Various mechanisms shaping genome evolution will be discussed and the genome evaluated for evidence of these processes. Prerequisites: BIMM 171, BIMM 171A, and BIMM 171B.").build();
		courseList.add(c83);

		Course c84 = new Course.Builder("ucsd").courseNum("BIMM 173").name("Undergraduate Research Explorations in Genomics").desc("Analyzing Drosophila dot chromosome sequences and making comparisons among species to discern patterns of genome organization related to control of gene expression. Computer analysis of finished sequence data, annotation of genes, assessment of repeats, exploration of evolutionary questions. Prerequisites: BIMM 100, upper-division standing, department authorization.").build();
		courseList.add(c84);

		Course c85 = new Course.Builder("ucsd").courseNum("BIMM 181").name("Molecular Sequence Analysis").desc("This course covers the analysis of nucleic acid and protein sequences, with an emphasis on the application of algorithms to biological problems. Topics include sequence alignments, database searching, comparative genomics, and phylogenetic and clustering analyses. Pairwise alignment, multiple alignment, DNA sequencing, scoring functions, fast database search, comparative genomics, clustering, phylogenetic trees, gene finding/DNA statistics. This course open to bioinformatics majors only. Prerequisites: CSE 100 or Math 176, CSE 101 or Math 188, BIMM 100 or Chem 114C.").build();
		courseList.add(c85);

		Course c86 = new Course.Builder("ucsd").courseNum("BIMM 182").name("Biological Databases").desc("This course provides an introduction to the features of biological data, how that data are organized efficiently in databases, and how existing data resources can be utilized to solve a variety of biological problems. Object-oriented databases, data modeling and description, survey of current biological database with respect to above, implementation of database focused on a biological topic. This course open to bioinformatics majors only. Prerequisites: CSE 100 or Math 176.").build();
		courseList.add(c86);

		Course c87 = new Course.Builder("ucsd").courseNum("BIMM 184").name("Computational Molecular Biology").desc("This advanced course covers the application of machine learning and modeling techniques to biological systems. Topics include gene structure, recognition of DNA and protein sequence patterns, classification, and protein structure prediction. Pattern discovery, hidden Markov models/support vector machines/neural network/profiles, protein structure prediction, functional characterization of proteins, functional genomics/proteomics, metabolic pathways/gene networks.	 Prerequisites: BIMM 181 or BENG 181 or CSE 181, BIMM 182 or BENG 182 or CSE 182 or Chem 182.").build();
		courseList.add(c87);

		Course c88 = new Course.Builder("ucsd").courseNum("BIMM 185").name("Bioinformatics Laboratory (4)").desc("This course emphasizes the hands-on application of bioinformatics methods to biological problems. Students will gain experience in the application of existing software, as well as in combining approaches to answer specific biological questions. Sequence alignment, fast database search, profiles and motifs, comparative genomics, gene finding, phylogenetic trees, protein structure, functional characterization of proteins, expression anaylysis, computational proteomics. This course open to bioinformatics majors only. Prerequisites: two courses out of BIMM 181 or BENG 181 or CSE 181, BIMM 182 or BENG 182 or CSE 182, BENG 183, BIMM 184 or BENG 184 or CSE 184. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c88);

		//Physiology and Neuroscience

		Course c89 = new Course.Builder("ucsd").courseNum("BIPN 100").name("Mammalian Physiology I").desc("This course introduces the concepts of physiological regulation, controlled and integrated by the nervous and endocrine systems. It then examines the muscular, cardiovascular, and renal systems in detail and considers their control through the interaction of nervous activity and hormones. Three hours of lecture and one hour of discussion. Prerequisites: BILD 1; BILD 2.").build();
		courseList.add(c89);

		Course c90 = new Course.Builder("ucsd").courseNum("BIPN 102").name("Mammalian Physiology II").desc("This course completes a survey of organ systems begun in BIPN 100 by considering the respiratory and gastrointestinal systems. Consideration is given to interactions of these systems in weight and temperature regulation, exercise physiology, stress, and pregnancy and reproduction. Three hours of lecture and one hour of section per week. Prerequisites: BIPN 100; BIBC 102 may be taken concurrently.").build();
		courseList.add(c90);

		Course c91 = new Course.Builder("ucsd").courseNum("BIPN 105").name("Animal Physiology Lab").desc("Experiments are performed on membrane physiology; nerve muscle function; cardiovascular physiology; respiratory, gastrointestinal and renal physiology. Subjects include experimental animals and humans. Prerequisites: BIPN 100 (may be taken concurrently). Three hours of lecture and ten hours of laboratory each week. In addition to the formal lab hours, there will be at least eight hours in which students will be required to work in the class laboratory to complete experiments and prepare for presentations. Attendance at the first lecture/lab is required. Nonattendance will result in the student��s being dropped from the course roster.").build();
		courseList.add(c91);

		Course c92 = new Course.Builder("ucsd").courseNum("BIPN 106").name("Comparative Physiology").desc("This course examines the physiological adaptation of animals, invertebrates and vertebrates, to their particular environmental and behavioral niches. Structural, functional, and molecular adaptations of the basic organ systems are discussed. Prerequisites: BILD 2, Chem 6A-B-C. BILD 3 is recommended.").build();
		courseList.add(c92);

		Course c93 = new Course.Builder("ucsd").courseNum("BIPN 108").name("Physiology of Exercise").desc("Course addresses the human body��s response to exercise, addressing energy metabolism and the effects of both acute and chronic exercise on function in several important organ systems. Designing training regimes and the role of exercise in health will be considered. Prerequisites: BIPN 100 required; BIPN 102 and BIBC 102 recommended.").build();
		courseList.add(c93);

		Course c94 = new Course.Builder("ucsd").courseNum("BIPN 110").name("Organ Systems and Disease").desc("Course will offer in-depth instruction to human anatomy and diseases from the conceptual framework of organ systems. Central nervous system, cardiovascular system, and gastrointestinal system will be discussed in terms of normal anatomy, pathology, and relevant scientific frontiers. Prerequisites: BIPN 100.").build();
		courseList.add(c94);

		Course c95 = new Course.Builder("ucsd").courseNum("BIPN 140").name("Cellular Neurobiology").desc("This course covers the biophysics of the resting and active membranes of nerve cells. It also covers the mechanisms of sensory transduction and neuromodulation, as well as the molecular basis of nerve cell function. Prerequisites: BILD 1, 2; BIBC 100 or 102 recommended.").build();
		courseList.add(c95);

		Course c96 = new Course.Builder("ucsd").courseNum("BIPN 142").name("Systems Neurobiology").desc("This course covers integrated networks of nerve cells, including simple circuits like those involved in spinal reflexes. We will study how information and motor output is integrated and processed in the brain. We will also discuss higher-level neural processing. Prerequisites: BILD 1, 2, and BIBC 100 or 102.").build();
		courseList.add(c96);

		Course c97 = new Course.Builder("ucsd").courseNum("BIPN 144").name("Developmental Neurobiology").desc("Molecular basis of neuronal cell fate determination, axon pathfinding, synaptogenesis experience-based refinement of connections, and learning in the brain will be examined. Prerequisites: upper-division standing.").build();
		courseList.add(c97);

		Course c98 = new Course.Builder("ucsd").courseNum("BIPN 145").name("Neurobiology Laboratory").desc("Basic principles of nerve and muscle physiology will be taught through weekly exercises and individual projects. One hour of lecture and nine hours of laboratory each week. Prerequisites: BIPN 140. Attendance at the first lecture/lab is required. Nonattendance will result in the student being dropped from the course roster.").build();
		courseList.add(c98);

		Course c99 = new Course.Builder("ucsd").courseNum("BIPN 146").name("Computational Neurobiology").desc("An exploration of computational brain models, including biophysical models of single neurons, small neural circuits, and larger scale network models. Prerequisites: BILD 12 or BIPN 140 or Psych 106 or Cog Sci 107 recommended.").build();
		courseList.add(c99);

		Course c100 = new Course.Builder("ucsd").courseNum("BIPN 148").name("Cellular Basis of Learning and Memory").desc("Cellular and molecular mechanisms that underlie learning and memory. Synapse formation and synaptic plasticity, neurotransmitter systems and their receptors, mechanisms of synaptic modification, and effect of experience on neuronal connectivity, and gene expression. Prerequisites: BILD 1; BILD 2; BIBC 100 or BIBC 102 (may be taken concurrently).").build();
		courseList.add(c100);

		Course c101 = new Course.Builder("ucsd").courseNum("BIPN 150").name("Diseases of the Nervous System").desc("Course will be taught from a research perspective, highlighting the biological pathways impacted by different neurological diseases. Each disease covered will be used to illustrate a key molecular/cellular pathway involved in proper neurological function. Prerequisites: BIBC 102 and BICD 100.").build();
		courseList.add(c101);

		//Special Courses

		Course c102 = new Course.Builder("ucsd").courseNum("BISP 190").name("Advanced Biology Seminars for Seniors").desc("Experts in diverse areas of biology from major universities in the U.S. and abroad will describe current research activities being conducted in their laboratories. Relevant readings will be assigned. P/NP grades only. Prerequisites: seniors only; concurrent enrollment in BISP 199 or consent of instructor.").build();
		courseList.add(c102);

		Course c103 = new Course.Builder("ucsd").courseNum("BISP 191").name("Biology Transfers: Strategies for Success").desc("Course is designed to assist new transfers in making a smooth and informed transition from community college. Lectures focus on study skills, academic planning and using divisional and campus resources to help achieve academic, personal and professional goals. Exercises and practicums will develop the problem solving skills needed to succeed in biology. Attention will be given to research possibilities. Intended for new transfers. Prerequisites: upper-division standing.").build();
		courseList.add(c103);

		Course c104 = new Course.Builder("ucsd").courseNum("BISP 192").name("Senior Seminar in Biology").desc("The Senior Seminar Program is designed to allow senior undergraduates to meet with faculty members in a small group setting to explore an intellectual topic in biology (at the upper-division level). Topics will vary from quarter to quarter. Senior Seminars may be taken for credit up to four times, with a change in topic and permission of the department. Enrollment is limited to twenty students, with preference given to seniors. Prerequisites: upper-division standing; department stamp and/or consent of instructor.").build();
		courseList.add(c104);

		Course c105 = new Course.Builder("ucsd").courseNum("BISP 194").name("Advanced Topics in Modern Biology").desc("Course will vary in title and content. When offered, the current description and title are found in the Schedule of Classes and the Biological Sciences website. Can be taken a total of four times as topics vary. Students may not receive credit for the same topic. Prerequisites: BIBC 102; BICD 100; upper-division standing.").build();
		courseList.add(c105);

		Course c106 = new Course.Builder("ucsd").courseNum("BISP 195").name("Introduction to Teaching in Biology").desc("Introduction to the teaching of the basic course in biology. A student under the direction of the instructor of the course is assigned one class section and will meet one time per week with the section. A student is required to attend the course lecture, lead a discussion section, and meet with the instructor of the course at least one time per week. Limited to upper-division students who have a B average or higher. Three hours�� lecture. (P/NP grades only.) Prerequisites: consent of instructor and approval of department chair. (Note: applications for a BISP 195 are to be submitted to the Division of Biological Sciences by the end of the sixth week of the quarter preceding the quarter in which the BISP 195 will be completed.) This course may be counted as one of the upper-division electives for a biology major.").build();
		courseList.add(c106);

		Course c107 = new Course.Builder("ucsd").courseNum("BISP 196").name("Honors Thesis in Biological Science").desc("Course for student participants in the senior honors thesis research program. Students complete individual research on a problem by special arrangement with, and under the direction of, a faculty member. Projects are expected to involve primary, experimental/analytical approaches that augment training in basic biology and that echo the curricular focus of the Division of Biological Sciences. Prerequisites: students must have senior standing; 3.7 overall and major GPA or above. Research must be approved by honors thesis faculty adviser. Enrollment in this course is for those students participating in the Honors Program in Biological Sciences and is via departmental approval only.").build();
		courseList.add(c107);

		Course c108 = new Course.Builder("ucsd").courseNum("BISP 197").name("Biology Internship Program").desc("Under the joint supervision of a biology faculty adviser and a selected industry mentor, the student will conduct independent research on a problem in an industrial biotech laboratory. The student will gain insight into industry research and practical biotech experience. Prerequisites: BIBC 103 or BIMM 101, BIBC 102, BICD 100, BIMM 100, overall GPA 3.0, and consent of the biology faculty coordinator.").build();
		courseList.add(c108);

		Course c109 = new Course.Builder("ucsd").courseNum("BISP 199").name("Individual Research for Undergraduates").desc("Individual research on a problem by special arrangement with, and under the direction of, a faculty member. Projects are expected to involve primary, experimental/analytical approaches that augment training in basic biology and that echo the curricular focus of the Division of Biological Sciences. (P/NP grades only.) Prerequisites: students must have an overall UC San Diego GPA of at least 3.0, a minimum of ninety units complete, and approval by division chair. Students must complete a Special Studies form and a Division of Biological Sciences ��Research Plan.�� (Note: applications for a BISP 199 must be submitted to the Division of Biological Sciences. See biology web page for deadlines.) May be taken for credit five times.").build();
		courseList.add(c109);

		//Graduate

		Course c110 = new Course.Builder("ucsd").courseNum("BGGN 200").name("Graduate School Fundamentals: Introduction to Graduate Studies in the Division of).name(Biological Sciences").desc("Course will cover fundamental issues in academia, including campus resources, research design, ethical issues in research, scientific publishing and review, grant preparation, etc. Required of all first year PhD students in the Division of Biological Sciences. Prerequisites: graduate (PhD) standing only; for students in the following major code BI77, or consent of instructor. (S/U grades only.) (F)").build();
		courseList.add(c110);

		Course c111 = new Course.Builder("ucsd").courseNum("BGGN 201").name("Methods in Computational Neuroscience").desc("Introduction to the computational methods most frequently used in neuroscience research. Aimed at first year graduate students in neuroscience and related disciplines. Minimal quantitative background will be assumed. Topics include Poisson processes, Markov Chains, auto- and cross-correlation analysis, Fourier/Spectral analysis, principal components/linear algebra, signal detection theory, information theory, Bayes Theorem, hypothesis testing. Nongraduate students may enroll with consent of instructor.").build();
		courseList.add(c111);

		Course c112 = new Course.Builder("ucsd").courseNum("BGGN 204").name("Topics in Community and Population Ecology").desc("This course teaches a different topic each quarter on the theoretical or conceptual side of community and population ecology. Students will read materials in depth, attend weekly discussions, and explore theories and models with statistical, analytical, and algorithmic tools of the trade. Prerequisites: graduate standing or consent of instructor. (S/U grades only.) (Quarter offered varies and course is not offered every year.)").build();
		courseList.add(c112);

		Course c113 = new Course.Builder("ucsd").courseNum("BGGN 205").name("Communicating Science to the Public").desc("Learn effective ways of communicating science to nonscientists. Develop an understanding of how people��s views of science and background knowledge can influence their learning, and develop methods to tailor communication for different audiences. (Quarter offered varies, and course is not offered every year.)").build();
		courseList.add(c113);

		Course c114 = new Course.Builder("ucsd").courseNum("BGGN 206").name("Topics in Biophysics and Physical Biochemistry").desc("Selection of topics of current interest. Examples: primary processes of photosynthesis; membrane biophysics; applications of physical methods to problems in biology and chemistry, e.g., magnetic resonance, X-ray diffraction, fluctuation spectroscopy, optical techniques (fluorescence, optical rotary dispersion, circular dichroism). Topics may vary from year to year. Prerequisites: consent of instructor. (S/U grades permitted.) This course is cross-listed with Physics 206 and Chemistry 206. (Quarter offered varies, and course is not offered every year.)").build();
		courseList.add(c114);

		Course c115 = new Course.Builder("ucsd").courseNum("BGGN 208").name("Biological Sciences Graduate Boot Camp").desc("Intensive lecture-, seminar-, and laboratory-based course for incoming first year students in the biological sciences PhD program. Topics covered: evolution and quantitative biology, including biostatistics, image analysis, bioinformatics, genomics, evolution, analysis of DNA proteins. During the first two weeks in September, students commit to ten to fifteen hours per day. Prerequisites: graduate (PhD) standing only; for students in the following major code BI77. (S/U grades only.) (F)").build();
		courseList.add(c115);

		Course c116 = new Course.Builder("ucsd").courseNum("BGGN 210").name("Neurobiology Boot Camp").desc("For incoming doctoral students in Neurobiology, Computational Neurobiology, and Neurosciences. During first two weeks in September, students commit to ten to fifteen hours per day in lectures and laboratories in electrophysiology, cellular anatomy, molecular biology, optical imaging, and computational neurobiology. Students also attend weekly seminars during fall quarter. Prerequisites: graduate standing; major codes BI77, BI79, NE75. (F)").build();
		courseList.add(c116);

		Course c117 = new Course.Builder("ucsd").courseNum("BGGN 211").name("Recent Advances and Experimental Approaches in Modern Biology").desc("Introduces students to advanced concepts of modern biology (e.g. molecular and cell biology, biochemistry, genomics, and epigenomics, etc.). Current experimental approaches (including high-throughput sequencing, microarray technology, RNAi, proteomic technologies, ChIP-seq) are discussed using primary research papers. The course provides training in critical analysis of scientific papers, data interpretation, scientific writing, and experimental design. Prerequisites: for MS students only in the following major code BI77 (letter grades only).").build();
		courseList.add(c117);

		Course c118 = new Course.Builder("ucsd").courseNum("BGGN 212").name("Special Topics in Microbiology").desc("Recent developments in prokaryotic and eukaryotic microbial research. Topics vary from year to year but may include the following subjects: the molecular basis of (a) sex determination, expression, and interconversion; (b) differentiation, morphogenesis, and programmed death; (c) transcriptional and metabolic regulation; and (d) chemical macromolecular and energy-mediated reception, transmission, and response processes. The main thesis of the course is that examples of complex regulatory phenomena in higher organisms can be found in single celled organisms. This course is open to enrollment by undergraduates. Prerequisites: BIBC 102 and BICD 100. (S/U grades permitted.) (Quarter offered varies, and course is not offered every year.)").build();
		courseList.add(c118);

		Course c119 = new Course.Builder("ucsd").courseNum("BGGN 216").name("Graduate Biostatistics").desc("Fundamentals behind and practical application of biostatistics, including central tendency and variability, hypothesis testing, inferential techniques (parametric and nonparametric), correlation and regression. Practice examples taken from the laboratory bench and primary literature. Training in the use of biostatistical software. Prerequisites: graduate standing or consent of instructor. (W)").build();
		courseList.add(c119);

		Course c120 = new Course.Builder("ucsd").courseNum("BGGN 217").name("Intervention in Human Disease States").desc("Students will learn how to distinguish between fact and fiction in treatment efficacy for serious human disease states in humans. The focus will be on evidence from research papers on various treatments. For CMG training program students. Prerequisites: graduate (PhD) standing only; for students in the following major code BI77; or consent of instructor. (Quarter offered varies.)").build();
		courseList.add(c120);

		Course c121 = new Course.Builder("ucsd").courseNum("BGGN 218").name("Post-Genomics Biology").desc("This course will focus on large-scale analysis of post-genomics biological systems. Students will be introduced to methods for analyzing changes in gene expression, identifying protein-protein interactions, screening for pathway inhibitors, characterizing multiprotein complexes, and probing protein localization and function.").build();
		courseList.add(c121);

		Course c122 = new Course.Builder("ucsd").courseNum("BGGN 220").name("Graduate Molecular Biology").desc("Provides a broad, advanced-level coverage of modern molecular biology for first-year graduate students. Topics include prokaryotic and eukaryotic gene structure and regulation, chromatin structure, DNA replication, translation, mechanisms of transcription, and an introduction to viruses. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) (F)").build();
		courseList.add(c122);

		Course c123 = new Course.Builder("ucsd").courseNum("BGGN 221").name("Graduate Protein Biochemistry").desc("Topics include general aspects of protein structure and biochemical approaches to the isolation and study of proteins. This course also covers the relationship between the structure and function of selected proteins. Detailed discussion of modern biophysical methods to study protein-protein interactions will be included. BGGN 220 is a corequisite. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) Corequisite: BGGN 220. (F)").build();
		courseList.add(c123);

		Course c124 = new Course.Builder("ucsd").courseNum("BGGN 222").name("Graduate Cell Biology").desc("A coverage of modern cell biology for first year graduate students. There is an up-to-date discussion of topics such as: structure and function of membranes; ion pumps, ion channels, transmembrane signaling; receptor mediated endocytosis; protein targeting; the role of RER and Golgi apparatus; the biosynthesis of intracellular organelles in animal and plant cells; the cytoskeleton, motility, molecular motors, cell-cell interactions, mitosis; and the control of cell division. Also included are extensive coverage of cell signaling mechanisms and discussions on molecular approaches to cell biology. Prerequisites: BGGN 220 and 221. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) (W)").build();
		courseList.add(c124);

		Course c125 = new Course.Builder("ucsd").courseNum("BGGN 223").name("Graduate Genetics").desc("Provides a broad and extensive advanced-level coverage of molecular and formal aspects of genetics for first-year graduate students. Topics covered include: bacterial genetics, recombination in prokaryotes and eukaryotes, mammalian somatic-cell genetics, developmental genetics, sex determination, dosage compensation, and immunogenetics. Extensive coverage of the use of model systems like Drosophila and C. elegans is included. General and specific aspects of cellular signaling mechanisms will be covered. Prerequisites: BGGN 220, 221 and 222. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) (S)").build();
		courseList.add(c125);

		Course c126 = new Course.Builder("ucsd").courseNum("BGGN 224").name("Graduate Neurobiology").desc("Course covers modern molecular, cellular, developmental, and physiological aspects of neurobiology. Extensive discussion of original research articles will be included. Prerequisites: BGGN 220 and 221. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) (F)").build();
		courseList.add(c126);

		Course c127 = new Course.Builder("ucsd").courseNum("BGGN 225").name("Graduate Immunology").desc("The course is devoted to immunology and is organized as a combined lecture-tutorial course stressing classical as well as current literature. Each week will compose an independent section. Topics will include cellular interactions involved in the immune response and the molecular biology unique to lymphoid factor and receptors. Prerequisites: BGGN 220 and 221. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) (S)").build();
		courseList.add(c127);

		Course c128 = new Course.Builder("ucsd").courseNum("BGGN 226").name("Graduate Animal Virology").desc("This course consists of a review of fundamental concepts together with an in-depth analysis of the structure, genetics, multiplication and oncogenicity of animal viruses. Particular emphasis will be given to the DNA and RNA tumor viruses. The format of this section includes lectures and discussion of selected papers. Prerequisites: BGGN 220 and 221. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) (W)").build();
		courseList.add(c128);

		Course c129 = new Course.Builder("ucsd").courseNum("BGGN 227").name("Graduate Topics in Plant Biology").desc("This course covers advanced topics in plant biology in the areas of molecular genetic developmental, and physiological biology. We will discuss plant-microbe interactions, transposable elements, protein trafficking, ion transport, and organ development. The format of this section includes lectures and discussion of selected papers. Prerequisites: BGGN 220, 221, and 222. OPEN ONLY TO STUDENTS ENROLLED IN A GRADUATE DEGREE PROGRAM. (Letter grades only.) (W)").build();
		courseList.add(c129);

		Course c130 = new Course.Builder("ucsd").courseNum("BGGN 228").name("Graduate Developmental Biology").desc("This course covers graduate level lectures on developmental biology, emphasizing the use of genetically tractable model systems. Discussion of recent research articles is an integral aspect of this course. Students are introduced to classical experiments and given detailed coverage of recent fundamental findings in developmental biology. Prerequisites: BGGN 220 and 221. (Letter grades only.) (S)").build();
		courseList.add(c130);

		Course c131 = new Course.Builder("ucsd").courseNum("BGGN 229").name("Graduate Oncogenes").desc("This course provides detailed coverage of the cellular and molecular basis of cellular transformation and oncogenesis. There will be extensive discussion on the role of oncogenes and their cellular counterparts. The course also provides in-depth analysis of intracellular signal transduction mechanisms. Prerequisites: BGGN 220, 221, and 222. (Letter grades only.) (S)").build();
		courseList.add(c131);

		Course c132 = new Course.Builder("ucsd").courseNum("BGGN 230").name("Graduate Signal Transduction").desc("The course will introduce students to a variety of signal transduction pathways and their function in the regulation of cellular processes. Special emphasis will be given to signaling cascades regulating immunological responses and alterations of signaling pathways during oncogenesis. (W)").build();
		courseList.add(c132);

		Course c133 = new Course.Builder("ucsd").courseNum("BGGN 231").name("Current Concepts in Stem Cell Biology").desc("Research papers from all aspects of stem cell biology will be read, presented, and discussed. Papers will range from landmark to current studies, spanning many developmental organisms and cell types. Students will present one paper, provide relevant background, and lead discussions. Prerequisites: graduate standing or consent of instructor. (F)").build();
		courseList.add(c133);

		Course c134 = new Course.Builder("ucsd").courseNum("BGGN 233").name("Cellular Immunology").desc("This course covers the molecular and cellular events in the humoral and cellular response to antigen, transplantation biology, the structure and function of the major histocompatibility gene complex, the T-cell receptor, lymphokines, and the induction of immunological tolerance. It serves as the second course in a two-part sequence. May be taken by undergraduates who have taken Part 1 (BICD 140) and by graduate students (S/U grades only.) (Quarter offered varies and course is not offered every year.)").build();
		courseList.add(c134);

		Course c135 = new Course.Builder("ucsd").courseNum("BGGN 234").name("Practical Histopathology and Mouse Models of Human Disease").desc("This course is designed to train those who need to analyze mouse models of human disease that are an essential part of their research. Sessions will include hematology, chemistry, histology, and immunohistochemistry methods used in the phenotyping assays. (Quarter offered varies and course is not offered every year.) (Cross-listed with PATH 234, MED 234, BIOM 238.) Prerequisites: Standard undergraduate biology courses.").build();
		courseList.add(c135);

		Course c136 = new Course.Builder("ucsd").courseNum("BGGN 235").name("Biology and Biochemistry of Cancer Cells").desc("This course covers recent advances in cell biology, biochemistry, immunology, and virology as they relate to cancer cells and their interaction with the host. Cancer research specialists from outside will be brought in to discuss the most recent evidence and interpretations in key areas of cancer research. This course meets two hours per week for lecture and discussion. It will be at an advanced graduate level but open to a limited number of seniors (with permission of instructor) on a P/NP basis. (S/U grades only.) (Quarter offered varies, and course is not offered every year.)").build();
		courseList.add(c136);

		Course c137 = new Course.Builder("ucsd").courseNum("BGGN 238A").name("Integrative Microbiology I").desc("To introduce students with structural and functional properties of microorganisms and with the role of microbes in the world. Course will emphasize the integrative aspects of microbiology. First course in series. Prerequisites: graduate standing.").build();
		courseList.add(c137);

		Course c138 = new Course.Builder("ucsd").courseNum("BGGN 238B").name("Integrative Microbiology II").desc("To introduce students with structural and functional properties of microorganisms and with the role of microbes in the world. Course will emphasize the integrative aspects of microbiology. Second course in series. Prerequisites: graduate standing.").build();
		courseList.add(c138);

		Course c139 = new Course.Builder("ucsd").courseNum("BGGN 240").name("Cellular Neurobiology").desc("Students read classic and modern papers that form the basis of the undergraduate lectures (BIPN 240), which they are encouraged to attend. These papers are presented by the students at weekly discussion sessions. Prerequisites: consent of instructor. (S/U grades only.) (F)").build();
		courseList.add(c139);

		Course c140 = new Course.Builder("ucsd").courseNum("BGGN 242").name("Graduate Cancer Biology").desc("Research-oriented approach to oncology topics and problems with an emphasis on interactions between tumor and the immune system. Prerequisites: graduate standing.").build();
		courseList.add(c140);

		Course c141 = new Course.Builder("ucsd").courseNum("BGGN 243").name("Systems Neurophysiology").desc("Ways in which neurons are assembled into circuits to achieve perception and patterned movement. Prerequisites: graduate standing or consent of instructor. (S/U grades only.)").build();
		courseList.add(c141);

		Course c142 = new Course.Builder("ucsd").courseNum("BGGN 245").name("Advanced Topics in Cancer Research and Therapy").desc("Lectures on basic and advanced concepts in cancer biology, will include defining outstanding contemporary questions and cutting-edge basic and translational research. Will rely on participants reading assigned literature prior to lectures. For PhD or MS students. Course will be held at the Salk Institute. (S/U grades only).").build();
		courseList.add(c142);

		Course c143 = new Course.Builder("ucsd").courseNum("BGGN 246A").name("Computational Neurobiology").desc("Students read classic and modern papers that form the basis of the undergraduate lectures (BIPN 146), which they are encouraged to attend. Students present these papers at weekly discussion sessions. The focus of 246A is cellular neuronal properties. Prerequisites: graduate standing or consent of instructor. (S/U grades only.)").build();
		courseList.add(c143);

		Course c144 = new Course.Builder("ucsd").courseNum("BGGN 248").name("Molecular Mechanisms of Neural Development").desc("This course will cover the cellular and molecular basis of neural development. Focus is on primary research papers and topics include neural induction and neurogenesis, cell patterning, neuronal and glial differentiation, neuronal migration, axon pathfinding, synapogenesis, neuronal cell death, regeneration, activity-dependent events, topographic maps, invertebrate and vertebrate model systems. Prerequisites: graduate standing or consent of instructor.").build();
		courseList.add(c144);

		Course c145 = new Course.Builder("ucsd").courseNum("BGGN 249B-C").name("Basic Neuroscience").desc("These courses are designed for graduate students in the neurosciences and other departments that are part of the interdisciplinary program (i.e., Biology, Cog Sci). These courses have been designed to cover as much basic neuroscience as possible in three quarters of study. They will combine two three-hour meetings each week with a 1.5-hour lecture and a 1.5-hour discussion of papers. These are required courses for all first-year neurosciences graduate students. Prerequisites: graduate standing or consent of instructor. (F,W,S)").build();
		courseList.add(c145);

		Course c146 = new Course.Builder("ucsd").courseNum("BGGN 260").name("Neurodynamics").desc("Introduction to the nonlinear dynamics of neurons and simple neural systems through nonlinear dynamics, bifurcation theory, and chaotic motions. The dynamics of single cells is considered at different levels of abstraction, e.g., biophysical and ��reduced�� models for analysis of regularly spiking and bursting cells, their dynamical properties, and their representation in phase space. Laboratory exercises will accompany the lectures. Prerequisites: graduate standing or consent of instructor.").build();
		courseList.add(c146);

		Course c147 = new Course.Builder("ucsd").courseNum("BGGN 262").name("3D Electron Microscopy Macromolecules").desc("Biological macromolecules and supramolecular complexes as well as organelles, and small cells are being examined in three dimensions by modern electron cryomicroscopy and image reconstruction techniques. The basic principles of transmission electron microscopy and 3D image reconstruction are discussed. Chem 265/BGGN 262 students will be required to complete an additional oral presentation or paper or exam beyond that expected of students in Chem 165/BIMM 162. (May not be offered every year.)   ").build();
		courseList.add(c147);

		Course c148 = new Course.Builder("ucsd").courseNum("BGGN 266").name("Advanced Laboratory in Biophysical Techniques").desc("Experiments that emphasize biophysical principles through hands-on experience, with an emphasis on the blending of physical measurements with a clearly identified biological problem. Exercises include the use of optical tweezers to measure viscous forces at the level of cellular organelles, the characterization of sensorimotor control in the fly during visually guided flight, and the use of microscopic imaging techniques to characterize cell motility and organelle transport. Includes instruction in LabView. Students are encouraged to attend the Phys 173 undergraduate lectures. Prerequisites: graduate standing or consent of instructor. Phys 120A, BILD 1, and Chem 6CL for undergraduates.").build();
		courseList.add(c148);

		Course c149 = new Course.Builder("ucsd").courseNum("BGGN 269").name("Mathematics for Neurobiologists").desc("An intensive course to introduce the mathematical concepts and techniques used in modern neurobiology. Intended for beginning graduate students in the neurosciences, but is also available to advanced undergraduates, with the consent of the instructor. Prerequisites: graduate standing or consent of instructor.").build();
		courseList.add(c149);

		Course c150 = new Course.Builder("ucsd").courseNum("BGGN 271").name("Advanced Experimental Methods in Biology").desc("Advanced laboratory and/or field experience in contemporary biological methodology. Open only to students enrolled in the integrated Bachelor��s/Master��s Degree Program. Prerequisites: consent of instructor and approval of division chair. (Graduate students: letter grades only.) (F,W,S)").build();
		courseList.add(c150);

		Course c151 = new Course.Builder("ucsd").courseNum("BGGN 290").name("Advances in Cellular and Molecular Mechanisms").desc("standing only; for students in the following major code BI77, or consent of instructor. (S/U grades only.)").build();
		courseList.add(c151);

		Course c152 = new Course.Builder("ucsd").courseNum("BGGN 292").name("Professional Pathways in Biological Sciences").desc("Students meet experienced science professionals from a wide variety of backgrounds, including academia, science industry, and allied roles. Through discussions with these professionals, students will refine and improve their professional skills, including communication and presentation expertise, and develop a personal career action plan. Prerequisites: graduate (PhD) standing only; for students in the following major code BI77; or consent of instructor. (S/U grades only.)").build();
		courseList.add(c152);

		Course c153 = new Course.Builder("ucsd").courseNum("BGGN 297").name("Research Conference").desc("Group and individual discussion of research activities and of current literature. Prerequisites: graduate standing. (S/U grades only.) (F,W,S)").build();
		courseList.add(c153);

		Course c154 = new Course.Builder("ucsd").courseNum("BGGN 298").name("Laboratory Projects in Biology").desc("An introduction to contemporary laboratory techniques and research interests through independent, original projects under the direction of individual faculty members. Prerequisites: consent of instructor. (Letter grades only) (F,W,S)").build();
		courseList.add(c154);

		Course c155 = new Course.Builder("ucsd").courseNum("BGGN 299").name("Thesis Research in Biology").desc("(F,W,S)").build();
		courseList.add(c155);

		Course c156 = new Course.Builder("ucsd").courseNum("BGGN 500").name("Apprentice Teaching").desc("This course involves participation in upper-division undergraduate teaching at the level of assuming responsibility for recitation sections or laboratories under the supervision of the responsible faculty member. Some experience in lecturing to upper-division classes will occasionally be provided. (S/U grades only.) (F,W,S)").build();
		courseList.add(c156);

		Course c157 = new Course.Builder("ucsd").courseNum("BGJC 201").name("Journal Club in Cell Biology").desc("Weekly presentations and discussions pertaining to research results reported in recently published literature. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c157);

		Course c158 = new Course.Builder("ucsd").courseNum("BGJC 203").name("Journal Club in HIV Molecular Biology").desc("Weekly presentations and discussions pertaining to research results reported in recently published literature. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c158);

		Course c159 = new Course.Builder("ucsd").courseNum("BGJC 204").name("Journal Club in Molecular and Cellular Immunology").desc("Weekly presentations and discussions pertaining to research results reported in recently published literature. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c159);

		Course c160 = new Course.Builder("ucsd").courseNum("BGJC 208").name("Journal Club in Plant Molecular Biology").desc("Weekly presentations and discussions pertaining to research results reported in recently published literature. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c160);

		Course c161 = new Course.Builder("ucsd").courseNum("BGJC 213").name("Journal Club in Computational Neurobiology").desc("Weekly presentations and discussions pertaining to research results reported in recently published literature. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c161);

		Course c162 = new Course.Builder("ucsd").courseNum("BGRD 203").name("Research Discussion in Development of Dictyostelium").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c162);

		Course c163 = new Course.Builder("ucsd").courseNum("BGRD 204").name("Molecular Biology of the Cell").desc("Research reports and discussions based on recent experimental results in cell biology, oncogenesis, genetics, molecular biology and development. Students are expected to present and discuss their own new data and the recent data of others. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c163);

		Course c164 = new Course.Builder("ucsd").courseNum("BGRD 205").name("Research Discussion in Plant Membrane Biology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c164);

		Course c165 = new Course.Builder("ucsd").courseNum("BGRD 206").name("Research Discussion in Metals in Biology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c165);

		Course c166 = new Course.Builder("ucsd").courseNum("BGRD 207").name("Research Discussion in Neuronal Pattern Generation").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c166);

		Course c167 = new Course.Builder("ucsd").courseNum("BGRD 210").name("Research Discussion in Virology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c167);

		Course c168 = new Course.Builder("ucsd").courseNum("BGRD 211").name("Research Discussion in Developmental Cellular Neurobiology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c168);

		Course c169 = new Course.Builder("ucsd").courseNum("BGRD 212").name("Research Discussion in Behavior and Development of Simple Nervous Systems").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c169);

		Course c170 = new Course.Builder("ucsd").courseNum("BGRD 213").name("Research Discussion in Golgi Structure and Function").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c170);

		Course c171 = new Course.Builder("ucsd").courseNum("BGRD 214").name("Research Discussion in Development and Function of the Immune System").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c171);

		Course c172 = new Course.Builder("ucsd").courseNum("BGRD 215").name("Research Discussion in Lymphocyte Biology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c172);

		Course c173 = new Course.Builder("ucsd").courseNum("BGRD 216").name("Research Discussion in Molecular and Cell Biology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c173);

		Course c174 = new Course.Builder("ucsd").courseNum("BGRD 218").name("Research Discussion in Plant Molecular Genetics").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c174);

		Course c175 = new Course.Builder("ucsd").courseNum("BGRD 219").name("Research Discussion in Molecular Biophysics").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c175);

		Course c176 = new Course.Builder("ucsd").courseNum("BGRD 220").name("Research Discussion in Advanced Evolutionary Biology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c176);

		Course c177 = new Course.Builder("ucsd").courseNum("BGRD 221").name("Research Discussion in Behavioral Ecology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c177);

		Course c178 = new Course.Builder("ucsd").courseNum("BGRD 222").name("Research Discussion in Evolutionary Molecular Ecology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c178);

		Course c179 = new Course.Builder("ucsd").courseNum("BGRD 223").name("Research Discussion in Ecology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c179);

		Course c180 = new Course.Builder("ucsd").courseNum("BGRD 224").name("Research Discussion in Plant Population Biology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c180);

		Course c181 = new Course.Builder("ucsd").courseNum("BGRD 225").name("Research Discussion in Genetic Variation").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c181);

		Course c182 = new Course.Builder("ucsd").courseNum("BGRD 226").name("Research Discussion in Conservation Genetics").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c182);

		Course c183 = new Course.Builder("ucsd").courseNum("BGRD 227").name("Research Discussion in Intracellular Signaling").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c183);

		Course c184 = new Course.Builder("ucsd").courseNum("BGRD 228").name("Research Discussion in Drosophila Developmental Biology").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c184);

		Course c185 = new Course.Builder("ucsd").courseNum("BGRD 230").name("Research Discussion in Cell Signaling Pathways").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c185);

		Course c186 = new Course.Builder("ucsd").courseNum("BGRD 231").name("Research Discussion in Nuclear Transport and Function").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c186);

		Course c187 = new Course.Builder("ucsd").courseNum("BGRD 232").name("Research Discussion in Chromatin and Transcription Regulation").desc("Presentations of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c187);

		Course c188 = new Course.Builder("ucsd").courseNum("BGRD 234").name("Research Discussion in Cell Signaling in Drosophila").desc("Presentation of new research results and discussions of closely related published reports. All students are expected to report on their own research findings each quarter. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c188);

		Course c189 = new Course.Builder("ucsd").courseNum("BGSE 200").name("Seminar in Biology").desc("Invited speakers from the U.S. and abroad, who are leaders in various aspects of biological research, describe their current research. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c189);

		Course c190 = new Course.Builder("ucsd").courseNum("BGSE 201").name("Seminar in Molecular Biology").desc("Invited speakers from the U.S. and abroad, who are leaders in various aspects of biological research, describe their current research. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c190);

		Course c191 = new Course.Builder("ucsd").courseNum("BGSE 202").name("Seminar in Immunology").desc("Invited speakers from the U.S. and abroad, who are leaders in various aspects of biological research, describe their current research. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c191);

		Course c192 = new Course.Builder("ucsd").courseNum("BGSE 203").name("Seminar in Population Biology").desc("Invited speakers from the U.S. and abroad, who are leaders in various aspects of biological research, describe their current research. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.)").build();
		courseList.add(c192);

		Course c193 = new Course.Builder("ucsd").courseNum("BGSE 204").name("Seminar in Developmental Genetics").desc("Invited speakers from the U.S. and abroad, who are leaders in various aspects of biological research, describe their current research. Prerequisites: none for graduate students. Undergraduates must be seniors or enrolled in BISP 199. (S/U grades only.) (F,W,S)").build();
		courseList.add(c193);

		Course c194 = new Course.Builder("ucsd").courseNum("BGSE 205").name("Graduate Research Seminar").desc("Discussions of recent research in various aspects of biological research conducted by third- and fourth-year doctoral students in the Division of Biological Sciences. (S/U grades only.) (F,W,S)").build();
		courseList.add(c194);

	}
	
	/**
	 * get the list of courses
	 * @return
	 */
	public List<Course> getCourseList(){
		return courseList;
	}
	
	/**
	 * print out courses
	 */
	public void print(){
		for(Course c : courseList)
			System.out.println(c);
	}
	/**
	 * Count the the total number of courses
	 * @return
	 */
	public int count(){
		int count=0;
		for(int i=0; i < courseList.size();i++)
			count++;
		return count;
	}
	
	/**
	 * returns the random sample of N courses from the courseList
	 * @param size
	 * @return
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	public List<Course> sample(int size) throws InvalidFormatException, IOException{
		List<Course> fromThisList = new ToyData().getCourseList();
		List<Course> sample = new LinkedList<>();
		Collections.shuffle(fromThisList);
		for(int i=0; i < size; i++)
			sample.add(fromThisList.get(i));
	
		return sample;
		
	}
	public static void main(String[] args) throws IOException {

		ToyData td = new ToyData();
		
		//you can see all the courses
//		td.print();
		
		//Take random sample of 5 courses
		List<Course> sample = td.sample(5);
		for(Course c : sample){
			System.out.println(c);
			for(Sentence s : c.getDescParsed()){
				System.out.println("Bi-grams " + s.getNgrams(2));
				System.out.println("Nouns: " + s.getNouns());
			}
		}
		
	}
}
