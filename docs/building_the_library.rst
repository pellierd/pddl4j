********************
Building the Library
********************


Building from source code
-------------------------

The general command line to build PDDL4J from source code is as follow:

.. code-block:: bash

  ./gradlew build [options]

Options are:
  - ``-PnoCheckStyle`` to skip checkstyle verification
  - ``-PnoTest`` to tests

.. note::
  To speed up the compilation of PDDL4, we recommend not running tests and style checks.

The command line to build PDDL4J without test and checkstyle verification is:

  .. code-block:: bash

    ./gradlew build -PnoCheckStyle -PnoTest

The different build stages are the following:
  #. Compile Javacc (used to generate the parser)
  #. Compile Java
  #. Generate jar file
  #. Checkstyle Main (automate the process of checking Java main code), report in ``build/reports/checkstyle/main.xml``
  #. Checkstyle Test (automate the process of checking Java test code), report in  ``build/reports/checkstyle/test.xml``
  #. Test (use JUnit testing framework to test PDDL4J functions), report in ``build/test-results/test``


Creating a jar of the library
-----------------------------

To create a jar of the PDDL4J library with all dependency libraries just use the command line:

.. code-block:: bash

  ./gradlew jar

The jar generated is located in the directory ``./build/libs/pddl4j-X.X.jar`` where X.X is the version of PDDL4J. If the
library is not build, the library is built before. The libraries include in the jar are :
  - `Log4j <https://logging.apache.org/log4j/>`_ used for logging;
  - `JUnit <https://junit.org/junit5/>`_ used for unit tests;
  - `Picocli <https://picocli.info/>`_ to deal with planners command line.
  - `JOL <https://openjdk.java.net/projects/code-tools/jol/>`_  to analyze object layout schemes in JVMs.

Generating the Java documentation
---------------------------------

To generate the java documentation of the library use the following command line:

.. code-block:: bash

  ./gradlew javadoc

To access to the documentation generated open the file ``./build/docs/javadoc/index-all.html``.

Generating the BNF of the parser
--------------------------------

To generate the BNF (Backus–Naur form) of the PDDL language accepted by the parser use the following command line:

.. code-block:: bash

  ./gradlew jjdoc

To access to the documentation generated open the file ``./build/docs/PDDL4J_BNF/lexer.html``.

Generating the documentation
----------------------------

To generate the documentation just run the command line:

.. code-block:: bash

  ./gradlew site

To access to the documentation generated open the file ``./build/docs/site/index.html``.

.. note::

  The documentation is generated using `Sphinx <https://www.sphinx-doc.org/en/master/index.html>`_ with
  `readthedocs <https://readthedocs.org/>`_ using `reStructuredText <https://docutils.sourceforge.io/rst.html>`_. The
  source code of the documentation is available in ``./docs``.

Running JUnit Tests
-------------------

`JUnit <https://junit.org/junit5/>`_ is a unit testing framework for the Java programming language. JUnit has been
important in the development of test-driven development, and is one of the unit testing frameworks.

As a developer, it is important to include unit tests in your program to ensure that the functions/methods/algorithms
return the expected results. In PDDL4J, unit tests are included to test the parser, the search strategies and planners
with IPC benchmarks. To run all these tests, use the following command:

.. code-block:: bash

  ./gradlew test


The reports containing the results of JUnit tests are available in ``./build/test-results/test/`` folder.

.. note::

  The execution of the tests is very time consuming. All planners are tested in several configurations on all IPC
  benchmarks they can handle. A search time is allocated to each problem of each domain. This time is usually set at
  10 seconds. As soon as the planner fails to solve a problem within the time limit, the test procedure stops and checks
  whether the plans found are valid before finally moving on to the next domain and set of problems. For PDDL problems
  the plan validator used is `VAL <https://github.com/KCL-Planning/VAL>`_. For HDDL problems the plan validator used
  is `Panda <https://github.com/galvusdamor/panda3core>`_. Both plan validator are used in the international planning
  competition.


.. warning::

  The planners JUnit tests will fail on windows os. The plan validators used are only available for linux or mac.


Checking source code convention
-------------------------------

PDDL4J uses `Checkstyle <https://checkstyle.sourceforge.io/>`_ to check code source convention of the project.
Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard. It automates
the process of checking Java code to spare humans of this boring (but important) task. This makes it ideal for projects
that want to enforce a coding standard.

The different programming rules are defined in the ``./checkstyle.xml`` file located in the ``./config/checkstyle/``
folder. A task has also been added in the ``./build.gradle`` configuration file.

Thus, when building PDDL4J, a report containing the various errors will automatically be generated allowing the
developers to correct his/her code before committing it. The generated report is located in
``./build/report/checkstyle/`` folder.

To run only checkstyle on the PDDL4J source code, use the following command line:

.. code-block:: bash

  ./gradlew checkstyleMain

It is also possible to run checkstyle on the source code of the JUnit tests:

.. code-block:: bash

  ./gradlew checkstyleTest


It is possible to disable code analysis with Checkstyle by passing the following parameter to Gradle:

.. code-block:: bash

  ./gradlew build -PnoCheckStyle




