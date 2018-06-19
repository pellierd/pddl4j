/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.test.parser;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Implements the <tt>ParserTest</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * This class will test all the methods from Parser class.
 * </p>
 *
 * @author E Hermellin
 * @version 0.1 - 10.04.2017
 */
public class ParserTest {

    /**
     * Method that tests parsing from files.
     */
    @Test
    public void parseFromFileTest() {
        try {
            System.out.println("Parser: Test parsing from files.");
            final File domain = new File("src/test/resources/encoding/domain.pddl");
            final File problem = new File("src/test/resources/encoding/p01.pddl");

            final Parser parser = new Parser();
            parser.parse(domain, problem);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method that tests parsing from path files.
     */
    @Test
    public void parseFromStringFileTest() {
        try {
            System.out.println("Parser: Test parsing from path files.");
            final String domain = "src/test/resources/encoding/domain.pddl";
            final String problem = "src/test/resources/encoding/p01.pddl";

            final Parser parser = new Parser();
            parser.parse(domain, problem);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method that tests parsing from string.
     */
    @Test
    public void parseFromStringTest() {
        try {
            System.out.println("Parser: Test parsing from string.");
            final String domain = Tools.readFile("src/test/resources/encoding/domain.pddl",
                StandardCharsets.UTF_8);
            final String problem = Tools.readFile("src/test/resources/encoding/p01.pddl",
                StandardCharsets.UTF_8);

            final Parser parser = new Parser();
            parser.parseFromString(domain, problem);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method that tests parsing from one file.
     */
    @Test
    public void parseFromSingleFileTest() {
        try {
            System.out.println("Parser: Test parsing from one file.");
            final File domainAndProblem = new File("src/test/resources/encoding/domainAndProblem.pddl");

            final Parser parser = new Parser();
            parser.parse(domainAndProblem);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method that tests parsing from one path file.
     */
    @Test
    public void parseFromStringSingleFileTest() {
        try {
            System.out.println("Parser: Test parsing from one path file.");
            final String domainAndProblem = "src/test/resources/encoding/domainAndProblem.pddl";

            final Parser parser = new Parser();
            parser.parse(domainAndProblem);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method that tests parsing from one string.
     */
    @Test
    public void parseFromStringSingleTest() {
        try {
            System.out.println("Parser: Test parsing from one string.");
            final String domainAndProblem = "src/test/resources/encoding/domainAndProblem.pddl";
            final String domainAndProblemString = Tools.readFile(domainAndProblem,
                StandardCharsets.UTF_8);

            final Parser parser = new Parser();
            parser.parseFromString(domainAndProblemString);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method that tests parsing from a stream.
     */
    @Test
    public void parseFromStreamSingleTest() {
        try {
            System.out.println("Parser: Test parsing from one stream.");
            final String domainAndProblem = "src/test/resources/encoding/domainAndProblem.pddl";
            final String domainAndProblemString = Tools.readFile(domainAndProblem,
                StandardCharsets.UTF_8);

            InputStream is = new ByteArrayInputStream(domainAndProblemString.getBytes("UTF-8"));

            final Parser parser = new Parser();
            parser.parseFromStream(is);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method that tests parsing from two streams.
     */
    @Test
    public void parseFromStreamTest() {
        try {
            System.out.println("Parser: Test parsing from two streams.");
            final String domain = Tools.readFile("src/test/resources/encoding/domain.pddl",
                StandardCharsets.UTF_8);
            final String problem = Tools.readFile("src/test/resources/encoding/p01.pddl",
                StandardCharsets.UTF_8);

            InputStream isDomain = new ByteArrayInputStream(domain.getBytes("UTF-8"));
            InputStream isProblem = new ByteArrayInputStream(problem.getBytes("UTF-8"));

            final Parser parser = new Parser();
            parser.parseFromStream(isDomain,isProblem);
            final ErrorManager errManager = parser.getErrorManager();

            Assert.assertTrue(errManager.isEmpty());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
