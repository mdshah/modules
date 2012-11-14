package modules.testData;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import modules.NLPParsing.PrereqParser;
import modules.NLPParsing.Sentence;
import modules.entities.Course;
import opennlp.tools.util.InvalidFormatException;

/**
 * ToyData that has all the information cleanly. This class will be used in NLP as if we have perfectly structured data
 * @author Albert
 *
 */
public class ToyData_math {
	List<Course> courseList;

	public ToyData_math() throws InvalidFormatException, IOException {
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
		Course c0 =  new Course.Builder("minesota").courseNum("MATH 1001").name("Excursions in Mathematics").desc("@ 3.0. cr; Prereq-3 yrs high school math or placement exam or grade of at least C- in GC 0731; fall, spring, every year. Breadth of mathematics, its nature/applications. Power of abstract reasoning.").build();
		courseList.add(c0);
		Course c1 =  new Course.Builder("minesota").courseNum("MATH 1008").name("Trigonometry").desc("@ 2.67. cr; Prereq-Plane geometry, two yrs high school algebra [or C or better in GC 0731]; A-F or Aud, fall, spring, summer, every year. Analytic trigonometry, identities, equations, properties of trigometric functions, right/oblique triangles.").build();
		courseList.add(c1);
		Course c2 =  new Course.Builder("minesota").courseNum("MATH 1031").name("College Algebra and Probability").desc("@ 3.0. cr; Prereq-3 yrs high school math or grade of at least C- in GC 0731; Credit will not be granted if credit has been received for: 1051, 1151, 1155; fall, spring, every year. Algebra, analytic geometry explored in greater depth than is usually done in three years of high school mathematics. Additional topics from combinations, permutations, probability.").build();
		courseList.add(c2);
		Course c3 =  new Course.Builder("minesota").courseNum("MATH 1038").name("College Algebra and Probability Submodule").desc("@ 1.0. cr; ;;;Prereq-1051 or 1151 or 1155; A-F or Aud, fall, spring, summer, every year. For students who need probability/permutations/combinations portion of 1031. Meets with 1031, has same grade/work requirements.").build();
		courseList.add(c3);
		Course c4 =  new Course.Builder("minesota").courseNum("MATH 1051").name("Precalculus I").desc("@ 3.0. cr; Prereq-3 yrs high school math or placement exam or grade of at least C- in GC 0731; Credit will not be granted if credit has been received for: 1031, 1151; fall, spring, every year. Algebra, analytic geometry, exponentials, logarithms, beyond usual coverage found in three-year high school mathematics program.").build();
		courseList.add(c4);
		Course c5 =  new Course.Builder("minesota").courseNum("MATH 1131").name("Finite Mathematics").desc("@ 3.0. cr; Prereq-3 1/2 yrs high school math or grade of at least C- in [1031 or 1051]; fall, spring, every year. Financial mathematics, probability, linear algebra, linear programming, Markov chains, some elementary computer programming.").build();
		courseList.add(c5);
		Course c6 =  new Course.Builder("minesota").courseNum("MATH 1142").name("Short Calculus").desc("@ 4.0. cr; =[MATH 1271, MATH 1281, MATH 1371, MATH 1571H]; Prereq-3 1/2 yrs high school math or grade of at least C- in [1031 or 1051]; fall, spring, summer, every year. Derivatives, integrals, differential equations, partial derivatives, maxima/minima of functions of several variables covered with less depth than full calculus. No trigonometry included.").build();
		courseList.add(c6);
		Course c7 =  new Course.Builder("minesota").courseNum("MATH 1143").name("Introduction to Advanced Mathematics").desc("@ 4.0. cr; Prereq-1142 or 1272 or 1372 or #; recommended especially for students in [social/biological sciences, business]; A-F or Aud, fall. Topics that are covered in more depth in 2243 and 2263, plus probability theory. Matrices, eigenvectors, conditional probability, independence, distributions, basic statistical tools, linear regression. Linear differential equations and systems of differential equations. Multivariable differentiability and linearization.").build();
		courseList.add(c7);
		Course c8 =  new Course.Builder("minesota").courseNum("MATH 1151").name("Precalculus II").desc("@ 3.0. cr; Prereq-3 1/2 yrs high school math or placement exam or grade of at least C- in [1031 or 1051]; Credit will not be granted if credit has been received for: 1155; fall, spring, every year. Algebra, analytic geometry, trigonometry, complex numbers, beyond usual coverage found in three-year high school mathematics program.").build();
		courseList.add(c8);
		Course c9 =  new Course.Builder("minesota").courseNum("MATH 1155").name("Intensive Precalculus").desc("@ 5.0. cr; Prereq-3 yrs high school math or placement exam or grade of at least C- in GC 0731; Credit will not be granted if credit has been received for: 1031, 1051, 1151; fall, spring, summer, every year. Algebra, analytic geometry, exponentials, logarithms, trigonometry, complex numbers, beyond usual coverage found in three-year high school mathematics program. One semester version of 1051-1151.").build();
		courseList.add(c9);
		Course c10 =  new Course.Builder("minesota").courseNum("MATH 1271").name("Calculus I").desc("@ 4.0. cr; =[MATH 1142, MATH 1281, MATH 1371, MATH 1571H]; Prereq-4 yrs high school math including trig or placement test or grade of at least C- in 1151 or 1155; fall, spring, every year. Differential calculus of functions of a single variable. Introduction to integral calculus of a single variable, separable differential equations. Applications: max-min, related rates, area, volume, arc-length.").build();
		courseList.add(c10);
		Course c11 =  new Course.Builder("minesota").courseNum("MATH 1272").name("Calculus II").desc("@ 4.0. cr; =[MATH 1252, MATH 1282, MATH 1372, MATH 1572H]; Prereq-[1271 or equiv] with grade of at least C-; fall, spring, summer, every year. Techniques of integration. Calculus involving transcendental functions, polar coordinates. Taylor polynomials, vectors/curves in space, cylindrical/spherical coordinates.").build();
		courseList.add(c11);
		Course c12 =  new Course.Builder("minesota").courseNum("MATH 1281").name("Calculus with Biological Emphasis I").desc("@ 4.0. cr; =[MATH 1142, MATH 1271, MATH 1371, MATH 1571H]; Prereq-[[four yrs high school math including trigonometry] or [grade of at least C- in [1151 or 1155]] or placement exam], [instr or @]; fall, every year. Differential calculus of single-variable functions, basics of integral calculus. Applications emphasizing biological sciences.").build();
		courseList.add(c12);
		Course c13 =  new Course.Builder("minesota").courseNum("MATH 1282").name("Calculus With Biological Emphasis II").desc("@ 4.0. cr; =[MATH 1252, MATH 1272, MATH 1372, MATH 1572H]; Prereq-[1271 or 1281 or 1371] with grade of at least C-; spring, every year. Techniques/applications of integration, differential equations/systems, matrix algebra, basics of multivariable calculus. Applications emphasizing biology.").build();
		courseList.add(c13);
		Course c14 =  new Course.Builder("minesota").courseNum("MATH 1371").name("CSE Calculus I").desc("@ 4.0. cr; =[MATH 1142, MATH 1271, MATH 1281, MATH 1571H]; Prereq-CSE, background in [precalculus, geometry, visualization of functions/graphs], #; familiarity with graphing calculators recommended; fall, every year. Differentiation of single-variable functions, basics of integration of single-variable functions. Applications: max-min, related rates, area, curve-sketching. Emphasizes use of calculator, cooperative learning.").build();
		courseList.add(c14);
		Course c15 =  new Course.Builder("minesota").courseNum("MATH 1372").name("CSE Calculus II").desc("@ 4.0. cr; =[MATH 1252, MATH 1272, MATH 1282, MATH 1572H]; Prereq-CSE, grade of at least C- in 1371; spring, every year. Techniques of integration. Calculus involving transcendental functions, polar coordinates, Taylor polynomials, vectors/curves in space, cylindrical/spherical coordinates. Emphasizes use of calculators, cooperative learning.").build();
		courseList.add(c15);
		Course c16 =  new Course.Builder("minesota").courseNum("MATH 1461H").name("Honors Calculus IA for Secondary students").desc("@ 2.0. cr; Prereq-High school student, #; fall, every year. Accelerated sequence. Functions, parametric equations and polar coordinates, and vectors are presented using a geometric approach. Limits/continuity, derivates.").build();
		courseList.add(c16);
		Course c17 =  new Course.Builder("minesota").courseNum("MATH 1462H").name("Honors Calculus IB for Secondary Students").desc("@ 3.0. cr; Prereq-High school student, #; spring, every year. Accelerated sequence. Differentiation, foundations of integration. Proofs, formal reasoning.").build();
		courseList.add(c17);
		Course c18 =  new Course.Builder("minesota").courseNum("MATH 1471H").name("Honors Calculus I for Secondary Students").desc("@ 5.0. cr; Prereq-High school student, #; fall, every year. Differentiation/integration of single-variable functions. Emphasizes concepts/explorations.").build();
		courseList.add(c18);
		Course c19 =  new Course.Builder("minesota").courseNum("MATH 1472H").name("Honors Calculus II for Secondary Students").desc("@ 5.0. cr; Prereq-1471H; fall, every year. Sequences/series, vector functions, differentiation in multivariable calculus. Introduction to first-order systems of differential equations. Emphasizes concepts/explorations.").build();
		courseList.add(c19);
		Course c20 =  new Course.Builder("minesota").courseNum("MATH 1473H").name("Honors Calculus IIA for Secondary Students").desc("@ 2.0. cr; Prereq-honors; fall, every year. Accelerated honors sequence for selected mathematically talented high school students. Introduction to linear methods and first order differential equations.").build();
		courseList.add(c20);
		Course c21 =  new Course.Builder("minesota").courseNum("MATH 1474H").name("Honors Calculus IIB for Secondary Students").desc("@ 3.0. cr; Prereq-honors; spring, every year. Accelerated honors sequence for selected mathematically talented high school stduents. Multivariable calculus through differentiation. Focuses on proofs and formal reasoning.").build();
		courseList.add(c21);
		Course c22 =  new Course.Builder("minesota").courseNum("MATH 1571H").name("Honors Calculus I").desc("@ 4.0. cr [max. 5.0. cr]; =[MATH 1142, MATH 1271, MATH 1281, MATH 1371]; Prereq-CSE Honors office approval; fall, every year. Differential/integral calculus of functions of a single variable. Emphasizes hard problem-solving rather than theory.").build();
		courseList.add(c22);
		Course c23 =  new Course.Builder("minesota").courseNum("MATH 1572H").name("Honors Calculus II").desc("@ 4.0. cr [max. 5.0. cr]; =[MATH 1252, MATH 1272, MATH 1282, MATH 1372]; Prereq-Grade of at least C- in 1571, CSE Honors Office approval; parts of this sequence may be taken for cr by students who have taken non-honors calc classes; fall, spring, every year. Continuation of 1571. Infinite series, differential calculus of several variables, introduction to linear algebra.").build();
		courseList.add(c23);
		Course c24 =  new Course.Builder("minesota").courseNum("MATH 2001").name("Actuarial Science Seminar").desc("@ 1.0. cr; Prereq-1272 or equiv; S-N or Aud, spring, every year. Actuarial science as a subject and career. Guest lectures by actuaries. Resume preparation and interviewing skills. Review and practice for actuarial exams.").build();
		courseList.add(c24);
		Course c25 =  new Course.Builder("minesota").courseNum("MATH 2066").name("Elementary Differential Equations").desc("@ 1.0. -. 4.0. cr [max. 4.0. cr]. Not taught: merely provides credit for transfer students who have taken a sophomore-level differential equations class that does not contain enough linear algebra to qualify for credit for 2243.").build();
		courseList.add(c25);
		Course c26 =  new Course.Builder("minesota").courseNum("MATH 2142").name("Elementary Linear Algebra").desc("@ 1.0. -. 4.0. cr [max. 1.0. cr]; A-F or Aud. Not taught: merely provides credit for transfer students who have taken a sophomore-level linear algebra course that does not contain enough differential equations to qualify for credit for 2243.").build();
		courseList.add(c26);
		Course c27 =  new Course.Builder("minesota").courseNum("MATH 2243").name("Linear Algebra and Differential Equations").desc("@ 4.0. cr; =[MATH 2373]; Prereq-1272 or 1282 or 1372 or 1572; fall, spring, summer, every year. Linear algebra: basis, dimension, matrices, eigenvalues/eigenvectors. Differential equations: first-order linear, separable; second-order linear with constant coefficients; linear systems with constant coefficients.").build();
		courseList.add(c27);
		Course c28 =  new Course.Builder("minesota").courseNum("MATH 2263").name("Multivariable Calculus").desc("@ 4.0. cr; =[MATH 2374, MATH 2573H, MATH 3251]; Prereq-1272 or 1372 or 1572; fall, spring, summer, every year. Derivative as a linear map. Differential/integral calculus of functions of several variables, including change of coordinates using Jacobians. Line/surface integrals. Gauss, Green, Stokes Theorems.").build();
		courseList.add(c28);
		Course c29 =  new Course.Builder("minesota").courseNum("MATH 2283").name("Sequences, Series, and Foundations").desc("@ 3.0. cr; =[MATH 3283W]; Prereq-&amp; [2243 or 2263 or 2373 or 2374]; fall, spring, every year. Introduction to mathematical reasoning used in advanced mathematics. Elements of logic. Mathematical induction. Real number system. General, monotone, recursively defined sequences. Convergence of infinite series/sequences. Taylor's series. Power series with applications to differential equations. Newton's method.").build();
		courseList.add(c29);
		Course c30 =  new Course.Builder("minesota").courseNum("MATH 2373").name("CSE Linear Algebra and Differential Equations").desc("@ 4.0. cr; =[MATH 2243]; Prereq-[1272 or 1282 or 1372 or 1572], CSE; fall, spring, every year. Linear algebra: basis, dimension, eigenvalues/eigenvectors. Differential Equations: linear equations/systems, phase space, forcing/resonance, qualitative/numerical analysis of nonlinear systems, Laplace transforms.  Emphasizes use of computer technology.").build();
		courseList.add(c30);
		Course c31 =  new Course.Builder("minesota").courseNum("MATH 2374").name("CSE Multivariable Calculus and Vector Analysis").desc("@ 4.0. cr; =[MATH 2263, MATH 2573H, MATH 3251]; Prereq-[1272 or 1282 or 1372 or 1572], CSE; fall, spring, every year. Derivative as a linear map. Differential/integral calculus of functions of several variables, including change of coordinates using Jacobians. Line/surface integrals. Gauss, Green, Stokes theorems. Emphasizes use of computer technology.").build();
		courseList.add(c31);
		Course c32 =  new Course.Builder("minesota").courseNum("MATH 2473H").name("Honors Calculus III for Secondary Students").desc("@ 3.0. cr [max. 5.0. cr]; Prereq-1472H; fall, every year. Multivariable integration, vector analysis, nonhomogeneous linear equations, nonlinear systems of equations. Emphasizes concepts/explorations.").build();
		courseList.add(c32);
		Course c33 =  new Course.Builder("minesota").courseNum("MATH 2474H").name("Advanced Topics for Secondary Students").desc("@ 3.0. cr; Prereq-2473H; spring, every year. Topics may include linear algebra, combinatorics, advanced differential equations, probability/statistics, numerical analysis, dynamical systems, topology/geometry. Emphasizes concepts/explorations.").build();
		courseList.add(c33);
		Course c34 =  new Course.Builder("minesota").courseNum("MATH 2573H").name("Honors Calculus III").desc("@ 4.0. cr [max. 5.0. cr]; =[MATH 2263, MATH 2374, MATH 3251]; Prereq-1572 or CSE Honors office approval; fall, spring, every year. Integral calculus of several variables. Vector analysis, including theorems of Gauss, Green, Stokes.").build();
		courseList.add(c34);
		Course c35 =  new Course.Builder("minesota").courseNum("MATH 2574H").name("Honors Calculus IV").desc("@ 4.0. cr; Prereq-[2573 or equiv], CSE Honors office approval; fall, spring, every year. Advanced linear algebra, differential equations. Additional topics as time permits.").build();
		courseList.add(c35);
		Course c36 =  new Course.Builder("minesota").courseNum("MATH 2582H").name("Honors Calculus II: Advanced Placement").desc("@ 5.0. cr; Prereq-?; A-F or Aud, fall, every year. First semester of integrated three semester sequence covering infinite series, multivariable calculus (including vector analysis with Gauss, Green and Stokes theorems, linear algebra (with vector spaces), ODE, and introduction to complex analysis. Material is covered at a faster pace and at a somewhat deeper level than the regular honors sequence.").build();
		courseList.add(c36);
		Course c37 =  new Course.Builder("minesota").courseNum("MATH 2583H").name("Honors Calc 3 - Adv Placement").desc("@ 5.0. cr; Prereq-2582H or #; A-F or Aud. Second semester of three-semester sequence. Infinite series. Multivariable calculus including vector analysis with Gauss, Green, and Stokes theorems. Linear algebra (with vector spaces), ODE, and introduction to complex analysis. Material is covered at faster pace and deeper level than in regular honors sequence.").build();
		courseList.add(c37);
		Course c38 =  new Course.Builder("minesota").courseNum("MATH 2999").name("Special Exam").desc("@ 1.0. cr; summer. Special exam.").build();
		courseList.add(c38);
		Course c39 =  new Course.Builder("minesota").courseNum("MATH 3113").name("Topics in Elementary Mathematics I").desc("@ 4.0. cr; Prereq-[Grade of at least C- in 1031] or placement exam; fall, spring, summer, every year. Arithmetic/geometric sequences. Counting, building on techniques from college algebra. Graph theory. Integers, rational numbers; emphasizes aspects related to prime factorization. Modular arithmetic with applications.").build();
		courseList.add(c39);
		Course c40 =  new Course.Builder("minesota").courseNum("MATH 3116").name("Topics in Elementary Math II: Short Course").desc("@ 2.0. cr; Prereq-Grade of at least C- in 3113; A-F or Aud, fall, spring, summer, every year. Probability/Statistics, vector geometry, real/complex numbers. Meets during first half of semester only.").build();
		courseList.add(c40);
		Course c41 =  new Course.Builder("minesota").courseNum("MATH 3118").name("Topics in Elementary Mathematics II").desc("@ 4.0. cr; Prereq-Grade of at least C- in 3113; fall, spring, every year. Probability/statistics, vector geometry, real/complex numbers, finite fields building on previously learned modular arithmetic, trees.").build();
		courseList.add(c41);
		Course c42 =  new Course.Builder("minesota").courseNum("MATH 3283W").name("Sequences, Series, and Foundations: Writing Intensive (WI)").desc("@ 4.0. cr; =[MATH 2283]; Prereq-&amp; [2243 or 2263 or 2373 or 2374]; fall, spring, every year. Introduction to reasoning used in advanced mathematics courses. Logic, mathematical induction, real number system, general/monotone/recursively defined sequences, convergence of infinite series/sequences, Taylor's series, power series with applications to differential equations, Newton's method. Writing-intensive component.").build();
		courseList.add(c42);
		Course c43 =  new Course.Builder("minesota").courseNum("MATH 3584H").name("Honors Calculus IV: Advanced Placement").desc("@ 5.0. cr; Prereq-[2583 or equiv], CSE Honors office approval. Advanced linear algebra, differential equations. Introduction to complex analysis.").build();
		courseList.add(c43);
		Course c44 =  new Course.Builder("minesota").courseNum("MATH 3592H").name("Honors Mathematics I").desc("@ 5.0. cr; Prereq-?; for students with mathematical talent; A-F or Aud, fall, every year. First semester of three-semester sequence. Focuses on multivariable calculus at deeper level than regular calculus offerings. Rigorous introduction to sequences/series. Theoretical treatment of multivariable calculus. Strong introduction to linear algebra.").build();
		courseList.add(c44);
		Course c45 =  new Course.Builder("minesota").courseNum("MATH 3593H").name("Honors Mathematics II").desc("@ 5.0. cr; Prereq-3592H or #; A-F or Aud, spring, every year. Second semester of three-semester sequence. Focuses on multivariable calculus at deeper level than regular calculus offerings. Rigorous introduction to sequences/series. Theoretical treatment of multivariable calculus. Strong introduction to linear algebra.").build();
		courseList.add(c45);
		Course c46 =  new Course.Builder("minesota").courseNum("MATH 4005").name("Calculus Refresher").desc("@ 4.0. cr; Prereq-?; A-F or Aud. Review of first-year calculus. Functions of one variable. Limits. Differentiation/integration of functions of one variable. Some applications, including max-min, related rates. Volume and surface area of solids of revolution. Vectors/curves in the plane and in space.").build();
		courseList.add(c46);
		Course c47 =  new Course.Builder("minesota").courseNum("MATH 4065").name("Theory of Interest").desc("@ 3.0. cr; Prereq-1272 or 1372 or 1572; primarily for [mathematics, business] majors interested in actuarial science; fall, spring, every year. Time value of money. Annuities, sinking funds, bonds, similar items.").build();
		courseList.add(c47);
		Course c48 =  new Course.Builder("minesota").courseNum("MATH 4113").name("Topics in Elementary Mathematics I").desc("@ 4.0. cr; Prereq-[Grade of at least C- in 1031] or placement exam; fall, spring, summer. Arithmetic/geometric sequences. Counting, building on techniques from college algebra. Graph Theory. Integers, rational numbers; emphasizes aspects related to prime factorization. Modular arithmetic with applications. Grading standard one-third higher than 3113.").build();
		courseList.add(c48);
		Course c49 =  new Course.Builder("minesota").courseNum("MATH 4116").name("Topics in Elementary Math II: Short Course").desc("@ 2.0. cr; Prereq-Grade of at least C- in 4113; A-F or Aud. Probability/Statistics, vector geometry, real/complex numbers. Meets during first half of semester only. Grading standard one-third higher than 3116.").build();
		courseList.add(c49);
		Course c50 =  new Course.Builder("minesota").courseNum("MATH 4118").name("Topics in Elementary Mathematics II").desc("@ 4.0. cr; Prereq-Grade of at least C- in 4113; spring, every year. Probability/statistics, vector geometry, real/complex numbers, finitefields building on previously learned modular arithmetic, trees. Grading standard one-third higher than 3118.").build();
		courseList.add(c50);
		Course c51 =  new Course.Builder("minesota").courseNum("MATH 4151").name("Elementary Set Theory").desc("@ 3.0. cr; Prereq-One soph math course or #; fall, every year. Basic properties of operations on sets, cardinal numbers, simply and well-ordered sets, ordinal numbers, axiom of choice, axiomatics.").build();
		courseList.add(c51);
		Course c52 =  new Course.Builder("minesota").courseNum("MATH 4152").name("Elementary Mathematical Logic").desc("@ 3.0. cr; =[MATH 5165]; Prereq-one soph math course or #; spring, every year. Propositional logic. Predicate logic: notion of a first order language, a deductive system for first order logic, first order structures, Godel's completeness theorem, axiom systems, models of formal theories.").build();
		courseList.add(c52);
		Course c53 =  new Course.Builder("minesota").courseNum("MATH 4242").name("Applied Linear Algebra").desc("@ 4.0. cr; =[MATH 4457]; Prereq-2243 or 2373 or 2573; fall, spring, summer, every year. Systems of linear equations, vector spaces, subspaces, bases, linear transformations, matrices, determinants, eigenvalues, canonical forms, quadratic forms, applications.").build();
		courseList.add(c53);
		Course c54 =  new Course.Builder("minesota").courseNum("MATH 4281").name("Introduction to Modern Algebra").desc("@ 4.0. cr; Prereq-2283 or 3283 or #. Equivalence relations, greatest common divisor, prime decomposition,modular arithmetic, groups, rings, fields, Chinese remainder theorem,matrices over commutative rings, polynomials over fields.").build();
		courseList.add(c54);
		Course c55 =  new Course.Builder("minesota").courseNum("MATH 4428").name("Mathematical Modeling").desc("@ 4.0. cr; Prereq-2243 or 2373 or 2573; spring, every year. Modeling techniques for analysis/decision-making in industry. Optimization (sensitivity analysis, Lagrange multipliers, linear programming). Dynamical modeling (steady-states, stability analysis, eigenvalue methods, phase portraits, simulation). Probabilistic methods (probability/statistical models, Markov chains, linear regression, simulation).").build();
		courseList.add(c55);
		Course c56 =  new Course.Builder("minesota").courseNum("MATH 4457").name("Methods of Applied Mathematics I").desc("@ 4.0. cr; =[MATH 4242]; Prereq-[2243 or 2373 or 2573], [2263 or 2374 or 2574]; fall, every year. Vector spaces, minimization principles, least squares approximation, orthogonal bases, linear functions, linear systems of ordinary differential equations. Applications include statics/dynamics of electrical circuits, mechanical structures. Stability/resonance, approximation/interpolation of data. Numerical methods and geometry.").build();
		courseList.add(c56);
		Course c57 =  new Course.Builder("minesota").courseNum("MATH 4458").name("Methods of Applied Mathematics II").desc("@ 4.0. cr; Prereq-4457; spring. Boundary value problems, partial differential equations, complex variables, dynamical systems, calculus of variations, numerical methods. Green's functions, delta functions, Fourier series/integrals, wavelets, conformal mapping, finite elements/differences. Applications: fluid/continuum mechanics, heat flow, signal processing, quantum mechanics.").build();
		courseList.add(c57);
		Course c58 =  new Course.Builder("minesota").courseNum("MATH 4512").name("Differential Equations with Applications").desc("@ 3.0. cr; Prereq-2243 or 2373 or 2573; fall, spring, every year. Laplace transforms, series solutions, systems, numerical methods, plane autonomous systems, stability.").build();
		courseList.add(c58);
		Course c59 =  new Course.Builder("minesota").courseNum("MATH 4567").name("Applied Fourier Analysis").desc("@ 4.0. cr; Prereq-2243 or 2373 or 2573; fall, spring, every year. Fourier series, integral/transform. Convergence. Fourier series, transform in complex form. Solution of wave, heat, Laplace equations by separation of variables. Sturm-Liouville systems, finite Fourier, fast Fourier transform. Applications. Other topics as time permits.").build();
		courseList.add(c59);
		Course c60 =  new Course.Builder("minesota").courseNum("MATH 4603").name("Advanced Calculus I").desc("@ 4.0. cr; Prereq-[2243 or 2373], [2263 or 2374] or 2574 or # ; fall, spring, summer every year. Axioms for the real numbers. Techniques of proof for limits, continuity, uniform convergence. Rigorous treatment of differential/integral calculus for single-variable functions.").build();
		courseList.add(c60);
		Course c61 =  new Course.Builder("minesota").courseNum("MATH 4604").name("Advanced Calculus II").desc("@ 4.0. cr; Prereq-4603 or 5615 or # ; spring, every year. Sequel to MATH 4603. Topology of n-dimensional Euclidian space. Rigorous treatment of multivariable differentiation and integration, including chain rule, Taylor's Theorem, implicit function theorem, Fubini's Theorem, change of variables, Stokes' Theorem. Effective: Spring 2011.").build();
		courseList.add(c61);
		Course c62 =  new Course.Builder("minesota").courseNum("MATH 4606").name("Advanced Calculus").desc("@ 4.0. cr; Prereq-[2263 or 2374 or 2573], [2283 or 2574 or 3283 or #]; Credit will not be granted if credit has been received for:5615; fall, spring, summer, every year. Axioms for the real numbers. Techniques of proof for limit theorems, continuity, uniform convergence. Rigorous treatment of differential/integral calculus for single-/multi-variable functions.").build();
		courseList.add(c62);
		Course c63 =  new Course.Builder("minesota").courseNum("MATH 4653").name("Elementary Probability").desc("@ 4.0. cr; Prereq-[2263 or 2374 or 2573]; [2283 or 2574 or 3283] recommended; fall, spring, every year. Probability spaces, distributions of discrete/continuous random variables, conditioning. Basic theorems, calculational methodology. Examples of random sequences. Emphasizes problem-solving.").build();
		courseList.add(c63);
		Course c64 =  new Course.Builder("minesota").courseNum("MATH 4707").name("Introduction to Combinatorics and Graph Theory").desc("@ 4.0. cr; Prereq-2243, [2283 or 3283]; Credit will not be granted if credit has been received for: 5705, 5707; fall, spring, every year. Existence, enumeration, construction, algorithms, optimization. Pigeonhole principle, bijective combinatorics, inclusion-exclusion, recursions, graph modeling, isomorphism. Degree sequences and edge counting. Connectivity, Eulerian graphs, trees, Euler.s formula, network flows, matching theory. Emphasizes mathematical induction as proof technique.").build();
		courseList.add(c64);
		Course c65 =  new Course.Builder("minesota").courseNum("MATH 4990").name("Topics in Mathematics").desc("@ 1.0. -. 4.0. cr [max. 12.0. cr]; fall, spring, summer, every year.").build();
		courseList.add(c65);
		Course c66 =  new Course.Builder("minesota").courseNum("MATH 4991").name("Independent Study").desc("@ 1.0. -. 4.0. cr [max. 12.0. cr]; fall, spring, summer, every year.").build();
		courseList.add(c66);
		Course c67 =  new Course.Builder("minesota").courseNum("MATH 4992").name("Directed Reading").desc("@ 1.0. -. 4.0. cr [max. 12.0. cr]; fall, spring, summer, every year.").build();
		courseList.add(c67);
		Course c68 =  new Course.Builder("minesota").courseNum("MATH 4993").name("Directed Study").desc("@ 1.0. -. 4.0. cr [max. 12.0. cr]; fall, spring, summer, every year.").build();
		courseList.add(c68);
		Course c69 =  new Course.Builder("minesota").courseNum("MATH 4995").name("Senior Project for CLA").desc("@ 1.0. cr; Prereq-2 sem of upper div math, ?; A-F or Aud, fall, spring, summer, every year. Directed study. May consist of paper on specialized area of math or original computer program or other approved project. Covers some math that is new to student. Scope/topic vary with instructor.").build();
		courseList.add(c69);
		Course c70 =  new Course.Builder("minesota").courseNum("MATH 4997W").name("Senior Project - Writing Intensive (WI)").desc("@ 1.0. cr [max. 2.0. cr]; Prereq-2 sem upper div math, ?; A-F or Aud, fall, spring, summer, every year. Directed study. A 10-15 page paper on a specialized area, including some math that is new to student. At least two drafts of paper given to instructor for feedback before final version. Student keeps journal of preliminary work on project. Scope/topic vary with instructor.").build();
		courseList.add(c70);
		Course c71 =  new Course.Builder("minesota").courseNum("MATH 5067").name("Actuarial Mathematics I").desc("@ 4.0. cr; Prereq-4065, [one sem [4xxx or 5xxx] [probability or statistics] course]; fall, every year. Future lifetime random variable, survival function. Insurance, life annuity, future loss random variables. Net single premium, actuarial present value, net premium, net reserves.").build();
		courseList.add(c71);
		Course c72 =  new Course.Builder("minesota").courseNum("MATH 5068").name("Actuarial Mathematics II").desc("@ 4.0. cr; Prereq-5067; spring, every year. Multiple decrement insurance, pension valuation. Expense analysis, gross premium, reserves. Problem of withdrawals. Regulatory reserving systems. Minimum cash values. Additional topics at instructor's discretion.").build();
		courseList.add(c72);
		Course c73 =  new Course.Builder("minesota").courseNum("MATH 5075").name("Mathematics of Options, Futures, and Derivative Securities I").desc("@ 4.0. cr; Prereq-Two yrs calculus, basic computer skills; fall, every year. Mathematical background (e.g., partial differential equations, Fourier series, computational methods, Black-Scholes theory, numerical methods--including Monte Carlo simulation). Interest-rate derivative securities, exotic options, risk theory. First course of two-course sequence.").build();
		courseList.add(c73);
		Course c74 =  new Course.Builder("minesota").courseNum("MATH 5076").name("Mathematics of Options, Futures, and Derivative Securities II").desc("@ 4.0. cr; Prereq-5075; A-F or Aud, spring, every year. Mathematical background such as partial differential equations, Fourier series, computational methods, Black-Scholes theory, numerical methods (including Monte Carlo simulation), interest-rate derivative securities, exotic options, risk theory.").build();
		courseList.add(c74);
		Course c75 =  new Course.Builder("minesota").courseNum("MATH 5165").name("Mathematical Logic I").desc("@ 4.0. cr; =[MATH 4152]; Prereq-2283 or 3283 or Phil 5201 or CSci course in theory of algorithms or #; fall, every year. Theory of computability: notion of algorithm, Turing machines, primitive recursive functions, recursive functions, Kleene normal form, recursion theorem. Propositional logic.").build();
		courseList.add(c75);
		Course c76 =  new Course.Builder("minesota").courseNum("MATH 5166").name("Mathematical Logic II").desc("@ 4.0. cr; Prereq-5165; spring, every year. First-order logic: provability/truth in formal systems, models of axiom systems, Godel's completeness theorem. Godel's incompleteness theorem: decidable theories, representability of recursive functions in formal theories, undecidable theories, models of arithmetic.").build();
		courseList.add(c76);
		Course c77 =  new Course.Builder("minesota").courseNum("MATH 5248").name("Cryptology and Number Theory").desc("@ 4.0. cr; Prereq-2 sems soph math; fall, every year. Classical cryptosystems. One-time pads, perfect secrecy. Public key ciphers: RSA, discrete log. Euclidean algorithm, finite fields, quadratic reciprocity. Message digest, hash functions. Protocols: key exchange, secret sharing, zero-knowledge proofs. Probablistic algorithms: pseudoprimes, prime factorization. Pseudo-random numbers. Elliptic curves.").build();
		courseList.add(c77);
		Course c78 =  new Course.Builder("minesota").courseNum("MATH 5251").name("Error-Correcting Codes, Finite Fields, Algebraic Curves").desc("@ 4.0. cr; Prereq-2 sems soph math; spring, every year. Information theory: channel models, transmission errors. Hamming weight/distance. Linear codes/fields, check bits. Error processing: linear codes, Hamming codes, binary Golay codes. Euclidean algorithm. Finite fields, Bose-Chaudhuri-Hocquenghem codes, polynomial codes, Goppa codes, codes from algebraic curves.").build();
		courseList.add(c78);
		Course c79 =  new Course.Builder("minesota").courseNum("MATH 5285H").name("Honors: Fundamental Structures of Algebra I").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [2283 or 2574 or 3283]; fall, every year. Review of matrix theory, linear algebra. Vector spaces, linear transformations over abstract fields. Group theory, includingnormal subgroups, quotient groups, homomorphisms, class equation, Sylow's theorems. Specific examples: permutation groups, symmetry groups of geometric figures, matrix groups.").build();
		courseList.add(c79);
		Course c80 =  new Course.Builder("minesota").courseNum("MATH 5286H").name("Honors: Fundamental Structures of Algebra II").desc("@ 4.0. cr; Prereq-5285; fall, spring, every year. Ring/module theory, including ideals, quotients, homomorphisms,domains (unique factorization, euclidean, principal ideal), fundamental theorem for finitely generated modules over euclidean domains, Jordan canonical form. Introduction to field theory, including finite fields,algebraic/transcendental extensions, Galois theory.").build();
		courseList.add(c80);
		Course c81 =  new Course.Builder("minesota").courseNum("MATH 5335").name("Geometry I").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [&amp; 2263 or &amp; 2374 or &amp; 2574]; fall, every year. Advanced two-dimensional Euclidean geometry from a vector viewpoint. Theorems/problems about triangles/circles, isometries, connections with Euclid's axioms. Hyperbolic geometry, how it compares with Euclidean geometry.").build();
		courseList.add(c81);
		Course c82 =  new Course.Builder("minesota").courseNum("MATH 5336").name("Geometry II").desc("@ 4.0. cr; Prereq-5335; spring, every year. Projective geometry, including: relation to Euclidean geometry, finitegeometries, fundamental theorem of projective geometry. N-dimensionalEuclidean geometry from a vector viewpoint. Emphasizes N=3, including: polyhedra, spheres, isometries.").build();
		courseList.add(c82);
		Course c83 =  new Course.Builder("minesota").courseNum("MATH 5345").name("Introduction to Topology").desc("@ 4.0. cr; Prereq-[2263 or 2374 or 2573], [&amp; 2283 or &amp; 2574 or &amp; 3283]; fall, every year. Set theory. Euclidean/metric spaces. Basics of general topology, including compactness/connectedness.").build();
		courseList.add(c83);
		Course c84 =  new Course.Builder("minesota").courseNum("MATH 5378").name("Differential Geometry").desc("@ 4.0. cr; Prereq-[2263 or 2374 or 2573], [2243 or 2373 or 2574]; [2283 or 3283] recommended]; spring, every year. Basic geometry of curves in plane and in space, including Frenet formula, theory of surfaces, differential forms, Riemannian geometry.").build();
		courseList.add(c84);
		Course c85 =  new Course.Builder("minesota").courseNum("MATH 5385").name("Introduction to Computational Algebraic Geometry").desc("@ 4.0. cr; Prereq-[2263 or 2374 or 2573], [2243 or 2373 or 2574]; fall, every year. Geometry of curves/surfaces defined by polynomial equations. Emphasizes concrete computations with polynomials using computer packages, interplay between algebra and geometry. Abstract algebra presented as needed.").build();
		courseList.add(c85);
		Course c86 =  new Course.Builder("minesota").courseNum("MATH 5445").name("Mathematical Analysis of Biological Networks").desc("@ 4.0. cr; Prereq-Linear algebra, differential equations; spring, every year. Development/analysis of models for complex biological networks. Examples taken from signal transduction networks, metabolic networks, gene control networks, and ecological networks.").build();
		courseList.add(c86);
		Course c87 =  new Course.Builder("minesota").courseNum("MATH 5467").name("Introduction to the Mathematics of Image and Data Analysis").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [2283 or 2574 or 3283 or #]; [[2263 or 2374], 4567] recommended; spring, every year. Background theory/experience in wavelets. Inner product spaces, operator theory, Fourier transforms applied to Gabor transforms, multi-scale analysis, discrete wavelets, self-similarity. Computing techniques.").build();
		courseList.add(c87);
		Course c88 =  new Course.Builder("minesota").courseNum("MATH 5481").name("Mathematics of Industrial Problems I").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [2263 or 2374 or 2574], familiarity with some programming language; fall, every year. Topics in industrial math, including crystal precipitation, air quality modeling, electron beam lithography. Problems treated both theoretically and numerically.").build();
		courseList.add(c88);
		Course c89 =  new Course.Builder("minesota").courseNum("MATH 5482").name("Mathematics of Industrial Problems II").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [2263 or 2374 or 2574], familiarity with some programming language; spring. Topics in industrial math, including color photography, catalytic converters, photocopying.").build();
		courseList.add(c89);
		Course c90 =  new Course.Builder("minesota").courseNum("MATH 5485").name("Introduction to Numerical Methods I").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], familiarity with some programming language; fall, every year. Solution of nonlinear equations in one variable. Interpolation, polynomial approximation, numerical integration/differentiation, numerical solution of initial-value problems.").build();
		courseList.add(c90);
		Course c91 =  new Course.Builder("minesota").courseNum("MATH 5486").name("Introduction To Numerical Methods II").desc("@ 4.0. cr; Prereq-5485; spring, every year. Direct/iterative methods for solving linear systems, approximation theory, methods for eigenvalue problems, methods for systems of nonlinear equations, numerical solution of boundary value problems for ordinary differential equations.").build();
		courseList.add(c91);
		Course c92 =  new Course.Builder("minesota").courseNum("MATH 5487").name("Computational Methods for Differential and Integral Equations in Engineering and Science I").desc("@ 4.0. cr; Prereq-4242. Numerical methods for elliptic partial differential equations, integral equations of engineering and science. Methods include finite element, finite difference, spectral, boundary integral.").build();
		courseList.add(c92);
		Course c93 =  new Course.Builder("minesota").courseNum("MATH 5488").name("Computational Methods for Differential and Integral Equations in Engineering and Science II").desc("@ 4.0. cr; Prereq-5487. Numerical methods for time-dependent partial differential equations of engineering/science. Methods include finite element, finite difference, spectral, boundary integral. Applications to fluid flow, elasticity, electromagnetism.").build();
		courseList.add(c93);
		Course c94 =  new Course.Builder("minesota").courseNum("MATH 5525").name("Introduction to Ordinary Differential Equations").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [2283 or 2574 or 3283]; fall, spring. Ordinary differential equations, solution of linear systems, qualitative/numerical methods for nonlinear systems. Linear algebra background, fundamental matrix solutions, variation of parameters, existence/uniqueness theorems, phase space. Rest points, their stability. Periodic orbits, Poincare-Bendixson theory, strange attractors.").build();
		courseList.add(c94);
		Course c95 =  new Course.Builder("minesota").courseNum("MATH 5535").name("Dynamical Systems and Chaos").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [2263 or 2374 or 2574]; fall, spring, every year. Dynamical systems theory. Emphasizes iteration of one-dimensional mappings. Fixed points, periodic points, stability, bifurcations, symbolic dynamics, chaos, fractals, Julia/Mandelbrot sets.").build();
		courseList.add(c95);
		Course c96 =  new Course.Builder("minesota").courseNum("MATH 5583").name("Complex Analysis").desc("@ 4.0. cr; =[00070]; Prereq-2 sems soph math [including [2263 or 2374 or 2573], [2283 or 3283]] recommended; fall, spring, summer, every year. Algebra, geometry of complex numbers. Linear fractional transformations. Conformal mappings. Holomorphic functions. Theorems of Abel/Cauchy, power series. Schwarz' lemma. Complex exponential, trig functions. Entire functions, theorems of Liouville/Morera. Reflection principle. Singularities, Laurent series. Residues.").build();
		courseList.add(c96);
		Course c97 =  new Course.Builder("minesota").courseNum("MATH 5587").name("Elementary Partial Differential Equations I").desc("@ 4.0. cr; Prereq-[2243 or 2373 or 2573], [2263 or 2374 or 2574]; fall, every year. Emphasizes partial differential equations w/physical applications, including heat, wave, Laplace's equations. Interpretations of boundary conditions. Characteristics, Fourier series, transforms, Green's functions, images, computational methods. Applications include wave propagation, diffusions, electrostatics, shocks.").build();
		courseList.add(c97);
		Course c98 =  new Course.Builder("minesota").courseNum("MATH 5588").name("Elementary Partial Differential Equations II").desc("@ 4.0. cr [max. 400.0. cr]; Prereq-[[2243 or 2373 or 2573], [2263 or 2374 or 2574], 5587] or #; A-F or Aud, spring, every year. Heat, wave, Laplace's equations in higher dimensions. Green's functions, Fourier series, transforms. Asymptotic methods, boundary layer theory, bifurcation theory for linear/nonlinear PDEs. Variational methods. Free boundary problems. Additional topics as time permits.").build();
		courseList.add(c98);
		Course c99 =  new Course.Builder("minesota").courseNum("MATH 5594H").name("Honors Mathematics - Topics").desc("@ 4.0. cr [max. 12.0. cr]; Prereq-[3593H with grade of at least B, experience in writing proofs] or ?; intended for mathematically-talented students with proven achievement in theoretical mathematics courses; A-F or Aud. Topics vary depending on interests of instructor. Theoretical treatment of chosen topic.").build();
		courseList.add(c99);
		Course c100 =  new Course.Builder("minesota").courseNum("MATH 5615H").name("Honors: Introduction to Analysis I").desc("@ 4.0. cr; Prereq-[[2243 or 2373], [2263 or 2374], [2283 or 3283]] or 2574; fall, every year. Axiomatic treatment of real/complex number systems. Introduction to metric spaces: convergence, connectedness, compactness. Convergence of sequences/series of real/complex numbers, Cauchy criterion, root/ratio tests. Continuity in metric spaces. Rigorous treatment of differentiation of single-variable functions, Taylor's Theorem.").build();
		courseList.add(c100);
		Course c101 =  new Course.Builder("minesota").courseNum("MATH 5616H").name("Honors: Introduction to Analysis II").desc("@ 4.0. cr; Prereq-5615; spring, every year. Rigorous treatment of Riemann-Stieltjes integration. Sequences/series of functions, uniform convergence, equicontinuous families, Stone-Weierstrass Theorem, power series. Rigorous treatment of differentiation/integration of multivariable functions, Implicit Function Theorem, Stokes' Theorem.  Additional topics as time permits.").build();


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
		List<Course> fromThisList = getCourseList();
		List<Course> sample = new LinkedList<>();
		Collections.shuffle(fromThisList);
		for(int i=0; i < size; i++)
			sample.add(fromThisList.get(i));

		return sample;

	}
	public static void main(String[] args) throws Exception {

		ToyData_math td = new ToyData_math();

		List<Course> sample = td.sample(99);
		for(Course c : sample){
//			System.out.println(c.getDesc());
			System.out.println(c.getModuleEntity());
//			System.out.println("---------------");
		}


	}


}
