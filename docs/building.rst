********************
Building the library
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
-------------------------

To create a jar of the PDDL4J library *without dependency libraries* just use the command line:

.. code-block:: bash

  ./gradlew jar

The jar generated is located in the directory ``build/libs/pddl4j-X.X.jar`` where X.X is the version of PDDL4J. If the
library is not build, the library is built before.

To create a jar of the PDDL4J library *with the dependency libraries* just use the command line:

.. code-block:: bash

  ./gradlew shadowJar

The jar generated is located in the directory ``build/libs/pddl4j-X.X-all.jar`` where X.X is the version of PDDL4J. The
libraries include in the jar are :
  - `LOG4J <https://logging.apache.org/log4j/>`_ used for logging;
  - `JUnit <https://junit.org/junit5/>`_ used for unit tests.

.. note :: Both jar are executable. The main class run by default is ``PlannerConfiguration``.

Generating the Java documentation
---------------------------------

To generate the java documentation of the library use the following command line:

.. code-block:: bash

  ./gradlew javadoc

To access to the documentation generated open the file ``build/docs/javadoc/index-all.html``.

Generating the BNF of the parser
--------------------------------

To generate the BNF (Backus–Naur form) of the PDDL language accepted by the parser use the following command line:

.. code-block:: bash

  ./gradlew jjdoc

To access to the documentation generated open the file ``build/docs/PDDL4J_BNF/lexer.html``.




