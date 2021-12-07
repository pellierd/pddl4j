# PDDL4J library

## 1. Contact

- Damien Pellier (damien.pellier@imag.fr)
- https://lig-membres.imag.fr/pellier/

## 2. Description

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
  * A PDDL 3.1 parser and HDDL 1.0 parser and all the classes need to manipulate its
concepts. The parser can be configured to accept only specified requirements of
PDDL od HDDL language.
  * A set of useful pre-processing mechanisms in order to instantiate and
simply actions into ground actions based on inertia properties.
  * A set of already implemented classical heuristics.
  * Several examples of planners using PDDL4J such as FastForward.

## 3. Dependencies

  * [Java JDK](https://adoptopenjdk.net/>) version 8 or higher.
  * [Gradle](https://gradle.org/>) to build the library.

## 4. How to use the PDDL4J library?

A complete documentation of the library is [available online](http://pddl4j.imag.fr/). For those in a hurry to get
PDDL4J and start running a planner start reading the [Getting Started section](http://pddl4j.imag.fr/getting_started.html).
Note that [PDDL4J API documentation](http://pddl4j.imag.fr/api_documentation.html) is also available online.

## 5. How to cite

The library is open source. If you use it, please cite us:

> D. Pellier & H. Fiorino (2017) PDDL4J: a planning domain description library for java, Journal of Experimental & Theoretical Artificial Intelligence, 30:1, 143-176
https://doi.org/10.1080/0952813X.2017.1409278
