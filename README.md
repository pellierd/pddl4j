##PDDL4J library (version 2.0)##
Date: 09/02/2011

###1. Contact###

- Damien Pellier (damien.pellier@imag.fr)
- http://lig-membres.imag.fr/pellier/

###2. Description### 

PDDL4J is an open source library under LGPL license.
 
The purpose of PDDL4J is to facilitate the development of JAVA tools for 
Automated Planning based on PDDL language (Planning Domain Description 
Language). Automated planning and scheduling, in the relevant literature often 
denoted as simply planning, is a branch of artificial intelligence that concerns
 the realization of strategies or action sequences, typically for execution by 
intelligent agents, autonomous robots and unmanned vehicles. 

PDDL was originally developed by Drew McDermott and the 1998 planning competition
committee. It was inspired by the need to encourage the empirical comparison of 
planning systems and the exchange of planning benchmarks within the community. 
Its development improved the communication of research results and triggered an
 explosion in performance, expressivity and robustness of planning systems.

PDDL has become a de facto standard language for describing planning domains, 
not only for the competition but more widely, as it offers an opportunity to 
carry out empirical evaluation of planning systems on a growing collection of 
generally adopted standard benchmark domains. The emergence of a language 
standard will have an impact on the entire field, influencing what is seen as 
central and what peripheral in the development of planning systems. 

The library contains:
  * a PDDL 3.1 parser and all the classes need to manipulate its 
concepts. The parser can be configured to accept only specified requirements of
PDDL language. 
  * a set of useful pre-processing mechanisms in order to instantiate and 
simply operators into ground actions based on inertia properties.  
  * a set of already implemented classical heuristics, e.g., h_ff, h_max, etc.
  * several examples of planners using PDDL4J. 

###3. How to use the PDDL4J library ?###

The pddl4j library is package with "ant". If ant is not installed on your computer,
go to http://ant.apache.org/ and install it.

####3.1 How to build PDDL4J ?####

Type at the root of the PDDL4J distribution: 
> ant rebuild 

To build the jar type:
> ant jar

The jar "pddl4j.jar" is available in the lib directory. 

####3.3 How to use binary distribution ?####

The pddl4j library can be used as a jar file called "pddl4j.jar" in the "lib" 
directory of the release. Therefore, include the jar in our classpath and enjoy
it.

####3.4 How to use the doc ?####

First, generate the documentation
> ant doc


All the documentation are contained in the doc directory.

####3.5 How to run examples ?####

Examples are available in the "examples" directory of the distribution. For 
instance, this archive contains a simple planner based on A* search strategy 
called AHSP. To launch the example use the following command line:

> java -javaagent:lib/pddl4j.jar -server -Xms2048m -Xmx2048m -classpath lib/pddl4j.jar 
>	pddl4j.examples.ahsp.AHSP -o pddl/blocksworld/domain.pddl
>	-f pddl/blocksworld/p15.pddl

Note: A set of planning problems is available in the web site of the international 
planning competition: http://ipc.icaps-conference.org.

