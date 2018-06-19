/*
 * Copyright (c) 2016 by Cedric Gerard <cedric.gerard@yeastlab.fr>.
 *
 * This file is part of PDDL4J library tests.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.test.parser;

import static fr.uga.pddl4j.parser.Message.Type.LEXICAL_ERROR;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.test.Tools;
import org.junit.Assert;
import org.junit.Test;

/**
 * Implements the <tt>ParserLexicalErrorTest</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * This class will test the parser on lexical issues in domain and problem files.
 * </p>
 *
 * @author E Hermellin
 * @version 0.1 - 18.12.2017
 */
public class ParserLexicalErrorTest {

    /**
     * The path of the benchmarks files.
     */
    private Message.Type errorType = LEXICAL_ERROR;

    /**
     * Method that tests brackets parsing error in domain file.
     */
    @Test
    public void testBracketsErrorDomainFile() {
        final String pathFileTest = "src/test/resources/parser/domain_lexical_error_0.pddl";
        final String errorToTest = "Bracket issue";
        Tools.FileType fileType = Tools.FileType.DOMAIN_FILE;

        System.out.println("ParserLexicalErrorTest: Test " + errorToTest + " in domain file.");

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
     * Method that tests keyword parsing error in domain file.
     */
    @Test
    public void testKeywordErrorDomainFile() {
        final String pathFileTest = "src/test/resources/parser/domain_lexical_error_1.pddl";
        final String errorToTest = "Keyword lexical issue";
        Tools.FileType fileType = Tools.FileType.DOMAIN_FILE;

        System.out.println("ParserLexicalErrorTest: Test " + errorToTest + " in domain file.");

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
     * Method that tests brackets parsing error in problem file.
     */
    @Test
    public void testBracketsErrorProblemFile() {
        final String pathFileTest = "src/test/resources/parser/problem_lexical_error_0.pddl";
        final String errorToTest = "Bracket issue";
        Tools.FileType fileType = Tools.FileType.PROBLEM_FILE;

        System.out.println("ParserLexicalErrorTest: Test " + errorToTest + " in problem file.");

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
     * Method that tests keyword parsing error in problem file.
     */
    @Test
    public void testKeywordErrorProblemFile() {
        final String pathFileTest = "src/test/resources/parser/problem_lexical_error_1.pddl";
        final String errorToTest = "Keyword lexical issue";
        Tools.FileType fileType = Tools.FileType.PROBLEM_FILE;

        System.out.println("ParserLexicalErrorTest: Test " + errorToTest + " in problem file.");

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
