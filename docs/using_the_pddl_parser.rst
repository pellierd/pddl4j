.. _using_the_pddl_parser_chapter:

Using the PDDL Parser
=====================

The library has a parser of the PDDL language. The language respects the 3.1 standard. To get the exact BNF (Backus–Naur
form) of the PDDL language implemented in the library you can type the command:

.. code-block:: bash

  ./gradlew jjdoc

To access to the documentation generated open the file ``./build/docs/PDDL4J_BNF/lexer.html`` or simply by clicking on
this `link <http://pddl4j.imag.fr/repository/pddl4j/PDDL4J_BNF/lexer.html>`_

Pre-requisite Installations
---------------------------

For this tutorial you need:
  *  `Java JDK <https://adoptopenjdk.net/>`_ version 8 or higher is installed.
  * A text editor such as `Sublime <https://www.sublimetext.com>`_ or `Atom <https://atom.io>`_ or IDE such as `Eclipse <https://www.eclipse.org>`_ `NetBean <https://netbeans.org>`_ or `IntelliJ <https://www.jetbrains.com/idea/>`_.

In the following, we will give the commands line so that the tutorial can be done independently of any IDE.

Step 1. Create a simple Java project with PDDL4J
------------------------------------------------

First, open a terminal and create your development directory

.. code-block:: bash

    mkdir PDDLParserExample

Then, create the sub-directories of your project

.. code-block:: bash

    cd PDDLParserExample
    mkdir -p src/fr/uga/pddl4j/examples
    mkdir classes
    mkdir lib


Finally, get the last binary of PDDL4J and save it in the ``lib`` directory

.. code-block:: bash

    wget http://pddl4j.imag.fr/repository/pddl4j/binaries/pddl4j-4.0.0.jar
    mv pddl4j-4.0.0.jar lib/pddl4j-4.0.0.jar

Step 2. Create the main class of our example
--------------------------------------------

Create and edit a file called ``PDDLParserExample.java`` in the directory ``src/fr/uga/pddl4j/examples/``. The skeleton
of this class is given bellow:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/PDDLParserExample.java
    :language: java
    :lines: 16-
    :linenos:

Step 3. Compile and Run the example
-----------------------------------

To test the above code use the following command line to compile the example:

.. code-block:: bash

    javac -d classes -cp classes:lib/pddl4j-4.0.0.jar src/fr/uga/pddl4j/examples/PDDLParserExample.java

and then the following command line to run the example:

.. code-block:: bash

    java -cp classes:lib/pddl4j-4.0.0.jar fr.uga.pddl4j.examples.PDDLParserExample \\
        src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl \\
        src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/p01.pddl


