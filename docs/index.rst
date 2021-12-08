==================================
Welcome to PDDL4J's documentation!
==================================

PDDL4J is a software library under `LGPL license <https://www.gnu.org/licenses/lgpl-3.0.en.html>`_ embedding Artificial
Intelligence algorithms to find solutions for planning problems, that is to say time organized actions to achieve a
goal. Solutions to planning problems are "todo lists" named **plan** representing operational features of actions like
**who, how, where, when and what to do**. The code of the library is available on `GitHub <https://github.com/pellierd/pddl4j>`_.

PDDL4J is a suite of solvers useful for decision problems that can be solved by a sequence of actions (plan). It is
based on a declarative approach: the user **states** a decision problem in PDDL (Planning Domain Description language
and PDDL4J generates possible solutions. **No programming language and/or background** is required. PDDL4J has lot of
application fields like can be use in many industrial fields as smart homes/data/cities, autonomous systems and
robotics, logistics, business processes etc.

.. note::

  If you are not familiar with Automated Planning, start reading the chapter
  :ref:`automated_planning_in_a_nutshell_chapter`.
  If you are not familiar with PDDL, start reading
  :ref:`pddl_tutorial_chapter`.

PDDL was originally developed in 1998. It was inspired by the need to encourage the empirical comparison of planning
systems and the exchange of planning benchmarks within the community. Its development improved the communication of
research results and triggered an explosion in performance, expressivity and robustness of planning systems. PDDL has
become a de facto standard language for describing planning domains, not only for planning competition but more
widely, as it offers an opportunity to carry out empirical evaluation of planning systems on a growing collection of
generally adopted standard benchmark domains. The emergence of a language  standard will have an impact on the entire
field, influencing what is seen as central and what peripheral in the development of planning systems.

The library contains:
  - A PDDL 3.1 parser and all the classes need to manipulate its concepts. The parser can be configured to accept only
    specified requirements of PDDL language.
  - A set of useful pre-processing mechanisms in order to instantiate and simply operators into ground actions.
  - A set of already implemented classical heuristics, e.g., relaxed planning graph, critical path, etc.
  - Several examples of planners using PDDL4J.

.. note::

  To get PDDL4J and start running a planner start reading the chapter :ref:`getting_started_chapter` or exploring
  the PDDL4J API documentation :ref:`api_documentation_chapter`.

.. important::

  The library is open source. If you use it, please cite us:

  D. Pellier & H. Fiorino (2017) PDDL4J: a planning domain description library for java, Journal of Experimental &
  Theoretical Artificial Intelligence, 30:1, 143-176, `DOI: 10.1080/0952813X.2017.1409278 <https://doi.org/10.1080/0952813X.2017.1409278>`_

.. toctree::
   :maxdepth: 2
   :hidden:

   automated_planning_in_a_nutshell
   pddl_tutorial
   getting_started
   building_the_library
   running_planners_from_command_line
   configuring_planners_by_programming
   writing_your_own_planner
   using_the_pddl_parser
   instantiating_planning_problems
   api_documentation
   download
   Issues <https://github.com/pellierd/pddl4j/issues?q=>
   how_to_contribute
