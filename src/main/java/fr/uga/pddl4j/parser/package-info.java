/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify * it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License * along with PDDL4J.  If not,
 * see <http://www.gnu.org/licenses/>
 */

/**
 * This package contains the classes of the PDDL parser. The parser accepts PDDL3.0 language and HDDL extension. See
 * <a href="../../../../../PDDL4J_BNF/Lexer.html">BNF Description of PDDL3.0</a> implemented in the
 * library more details. Note this code is automatically generated with javacc 4.0.
 *
 *
 * <p>A simple example of how to use the parser: </p>
 * <pre>
 * public static void main(String[] args) {
 *
 *  if (args.length == 2 &amp;&amp; args[0].equals(&quot;-p&quot;)) {
 *      PDDLParser parser = new PDDLParser();
 *      try {
 *          parser.parse(args[1]);
 *        } catch (FileNotFoundException e) {
 *          System.out.println(e.getMessage());
 *        }
 *      if (!parser.getErrorManager().isEmpty()) {
 *          parser.getErrorManager().printAll();
 *      }
 *  } else if (args.length == 4 &amp;&amp; args[0].equals(&quot;-o&quot;) &amp;&amp; args[2].equals(&quot;-f&quot;)) {
 *    PDDLParser parser = new PDDLParser();
 *    try {
 *          parser.parse(args[1], args[3]);
 *        } catch (FileNotFoundException e) {
 *          System.out.println(e.getMessage());
 *        }
 *      if (!parser.getErrorManager().isEmpty()) {
 *          parser.mgr.printAll();
 *        }
 *    } else {
 *      System.out.println(&quot;\nusage of parser:\n&quot;);
 *      System.out.println(&quot;OPTIONS   DESCRIPTIONS\n&quot;);
 *      System.out.println(&quot;-p &lt;str&gt;    path for operator and fact file&quot;);
 *      System.out.println(&quot;-o &lt;str&gt;    operator file name&quot;);
 *      System.out.println(&quot;-f &lt;str&gt;    fact file name\n&quot;);
 *    }
 * }
 * </pre>
 */
package fr.uga.pddl4j.parser;
