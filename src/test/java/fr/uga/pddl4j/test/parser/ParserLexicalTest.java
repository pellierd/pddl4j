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

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.Parser;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static fr.uga.pddl4j.parser.Message.Type.LEXICAL_ERROR;
import static org.junit.Assert.assertTrue;

/**
 * Implements the <tt>ParserLexicalTest</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * This class will test the parser on lexical issues in domain and problem files.
 * </p>
 *
 * @author E Hermellin
 * @version 0.1 - 18.12.2017
 */
public class ParserLexicalTest {

    /**
     * This enumeration defines the type of file: Domain or Problem.
     */
    public enum FileType {
        /**
         * The DOMAIN file.
         */
        DOMAIN_FILE,
        /**
         * The PROBLEM file.
         */
        PROBLEM_FILE,
    }

    /**
     * The path of the benchmarks files.
     */
    private Message.Type errorType = LEXICAL_ERROR;

    /**
     * Instantiate the Parser and parse domain file specified in the given path.
     *
     * @param path        the path to the pddl file to test
     * @param errorToTest the type of issue to test
     * @param fileType    the type of file to test (DOMAIN or PROBLEM)
     * @return an ErrorManager from the parsing file
     */
    private ErrorManager generateErrorMessagesInDomain(String path, String errorToTest, FileType fileType) {
        final Parser parser = new Parser();
        ErrorManager errManager = new ErrorManager();
        File file = new File(path);
        try {
            if (fileType == FileType.DOMAIN_FILE) {
                parser.parseDomain(file);
                errManager = parser.getErrorManager();
            } else if (fileType == FileType.PROBLEM_FILE) {
                File domain = new File("src/test/resources/encoding/domain.pddl");
                parser.parse(domain, file);
                errManager = parser.getErrorManager();
            }
        } catch (FileNotFoundException fnfExcepion) {
            System.err.println(errorToTest + " test file not found !");
            System.err.println("  -- " + file);
        }
        return errManager;
    }

    /**
     * Method that tests brackets parsing error in domain file.
     */
    @Test
    public void testBracketsErrorDomainFile() {
        String pathFileTest = "src/test/resources/parser/domain_lexical_error_0.pddl";
        String errorToTest = "Brackets";
        FileType fileType = FileType.DOMAIN_FILE;

        ErrorManager errManager = generateErrorMessagesInDomain(pathFileTest, errorToTest, fileType);
        errManager.printAll();
        if (!errManager.getMessages().isEmpty()) {
            for (Message message : errManager.getMessages()) {
                assertTrue(message.getType().equals(errorType));
            }
        }
    }

    /**
     * Method that tests brackets parsing error in domain file.
     */
    @Test
    public void testBracketsErrorProblemFile() {
        String pathFileTest = "src/test/resources/parser/problem_lexical_error_0.pddl";
        String errorToTest = "Brackets";
        FileType fileType = FileType.PROBLEM_FILE;

        ErrorManager errManager = generateErrorMessagesInDomain(pathFileTest, errorToTest, fileType);
        errManager.printAll();
        if (!errManager.getMessages().isEmpty()) {
            for (Message message : errManager.getMessages()) {
                assertTrue(message.getType().equals(errorType));
            }
        }
    }
}
