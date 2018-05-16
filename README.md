## PDDL4J library
[![DOI](https://zenodo.org/badge/doi/10.5281/zenodo.45971.svg)](http://dx.doi.org/10.5281/zenodo.45971)
[![Build Status](http://pddl4j.imag.fr/jenkins/job/pddl4j-base/badge/icon)](http://pddl4j.imag.fr/jenkins/job/pddl4j-base)

### 1. Contact

- Damien Pellier (damien.pellier@imag.fr)
- http://lig-membres.imag.fr/pellier/

### 2. Description

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
  * A PDDL 3.1 parser and all the classes need to manipulate its
concepts. The parser can be configured to accept only specified requirements of
PDDL language.
  * A set of useful pre-processing mechanisms in order to instantiate and
simply operators into ground actions based on inertia properties.
  * A set of already implemented classical heuristics, e.g., h_ff, h_max, etc.
  * Several examples of planners using PDDL4J.

### 3. How to use the PDDL4J library?

The pddl4j library is package with "gradle". If ant is not installed on your computer,
go to https://gradle.org/ and install it.

#### 3.1 How to build PDDL4J?

Type at the root of the PDDL4J distribution:
> ./gradlew build

if you want to build the project with findbug:
> ./gradlew build -Pfindbug

The jar "pddl4j-VERSION.jar" is available in the build/libs directory.

#### 3.3 How to use binary distribution?

The pddl4j library can be used as a jar file called "pddl4j-VERSION.jar" in the "libs"
directory of the release. Therefore, include the jar in our classpath and enjoy
it.

#### 3.4 How to access the documentation?

All the documentations are contained in the doc directory.

To generate the javadoc just type:
> ./gradlew javadoc


#### 3.5 How to run existing planner?

Planners are available in the "planners" package of the distribution. For
instance, this archive contains a simple planner based on A* search strategy
called HSP. To launch this planner use the following command line:

> java -javaagent:build/libs/pddl4j-VERSION.jar -server -Xms2048m -Xmx2048m fr.uga.pddl4j.planners.hsp.HSP -o pddl/blocksworld/domain.pddl -f pddl/blocksworld/p15.pddl

Or use the gradle run command:
> gradle run -PArgs=-o,pddl/blocksworld/domain.pddl,-f,pddl/blocksworld/p15.pddl

Note: A set of planning problems is available in the web site of the international
planning competition: http://ipc.icaps-conference.org.

### 4. How to cite

PDDL4J: a planning domain description library for java
https://doi.org/10.1080/0952813X.2017.1409278

> D. Pellier & H. Fiorino (2017) PDDL4J: a planning domain description library for java, Journal of Experimental & Theoretical Artificial Intelligence, 30:1, 143-176, DOI: 10.1080/0952813X.2017.1409278

### 5. Changelog

**PDDL4J v3.6.0**

*Planner*
* Adding Fast Forward planner
* Adding Enforced Hill Climbing planner
* Adding depth attibute in Node class
* Converting cost and heuristic in double
* Fix bugs

*Parser*
* Adding parseFromString method (it's is now possible to parse a string containing a pddl domain and/or problem)
* Refactor Parser class and fix bugs

*JUnit tests*
* Adding tests for all the planners, CodedProblem, Encoder, Parser, Plan, etc.
* Refactor and fix bugs

*Global*
* Change AdaptatorJavaJson to JsonAdapter
* Fix logger and standard outputs
* Throws uncatched exceptions
* Fix bugs
