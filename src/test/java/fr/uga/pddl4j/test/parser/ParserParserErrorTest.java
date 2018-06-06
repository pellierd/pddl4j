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
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.Test;

/**
 * Implements the <tt>ParserParserErrorTest</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * This class will test the parser on parser issues in domain and problem files.
 * </p>
 *
 * @author E Hermellin
 * @version 0.1 - 20.03.2017
 */
public class ParserParserErrorTest {

    /**
     * The path of the benchmarks files.
     */
    private Message.Type errorType = Message.Type.PARSER_ERROR;

    /**
     * Method that tests undefined object type in domain file.
     */
    @Test
    public void testUndefinedTypeDomainFile() {
        final String pathFileTest = "src/test/resources/parser/domain_parser_error_0.pddl";
        final String errorToTest = "Undefined object type";
        Tools.FileType fileType = Tools.FileType.DOMAIN_FILE;

        System.out.println("ParserParserErrorTest: Test " + errorToTest + " in domain file.");

        final ErrorManager errManager = Tools.generateErrorMessages(pathFileTest, errorToTest, fileType);
        errManager.printAll();
        if (!errManager.getMessages().isEmpty()) {
            for (Message message : errManager.getMessages()) {
                Assert.assertTrue(message.getType().equals(errorType));
            }
        }

        Assert.assertTrue(errManager.getMessages().size() == 1);
    }

    /**
     * Method that tests undefined predicate in domain file.
     */
    @Test
    public void testUndefinedPredicateErrorDomainFile() {
        final String pathFileTest = "src/test/resources/parser/domain_parser_error_1.pddl";
        final String errorToTest = "Undefined predicate";
        Tools.FileType fileType = Tools.FileType.DOMAIN_FILE;

        System.out.println("ParserParserErrorTest: Test " + errorToTest + " in domain file.");

        final ErrorManager errManager = Tools.generateErrorMessages(pathFileTest, errorToTest, fileType);
        errManager.printAll();
        if (!errManager.getMessages().isEmpty()) {
            for (Message message : errManager.getMessages()) {
                Assert.assertTrue(message.getType().equals(errorType));
            }
        }

        Assert.assertTrue(errManager.getMessages().size() == 1);
    }

    /**
     * Method that tests undefined object in problem file.
     */
    @Test
    public void testUndefinedObjectErrorProblemFile() {
        final String pathFileTest = "src/test/resources/parser/problem_parser_error_0.pddl";
        final String errorToTest = "Undefined object";
        Tools.FileType fileType = Tools.FileType.PROBLEM_FILE;

        System.out.println("ParserParserErrorTest: Test " + errorToTest + " in problem file.");

        final ErrorManager errManager = Tools.generateErrorMessages(pathFileTest, errorToTest, fileType);
        errManager.printAll();
        if (!errManager.getMessages().isEmpty()) {
            for (Message message : errManager.getMessages()) {
                Assert.assertTrue(message.getType().equals(errorType));
            }
        }

        Assert.assertTrue(errManager.getMessages().size() == 4);
    }

    /**
     * Method that tests undefined object in problem file.
     */
    @Test
    public void testUndefinedPredicateErrorProblemFile() {
        final String pathFileTest = "src/test/resources/parser/problem_parser_error_1.pddl";
        final String errorToTest = "Undefined object";
        Tools.FileType fileType = Tools.FileType.PROBLEM_FILE;

        System.out.println("ParserParserErrorTest: Test " + errorToTest + " in problem file.");

        final ErrorManager errManager = Tools.generateErrorMessages(pathFileTest, errorToTest, fileType);
        errManager.printAll();
        if (!errManager.getMessages().isEmpty()) {
            for (Message message : errManager.getMessages()) {
                Assert.assertTrue(message.getType().equals(errorType));
            }
        }

        Assert.assertTrue(errManager.getMessages().size() == 1);
    }
}
