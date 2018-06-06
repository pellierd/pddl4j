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
 * Implements the <tt>ParserParserWarningTest</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * This class will test the parser on parser warning issues in domain and problem files.
 * </p>
 *
 * @author E Hermellin
 * @version 0.1 - 20.03.2017
 */
public class ParserParserWarningTest {

    /**
     * The path of the benchmarks files.
     */
    private Message.Type errorType = Message.Type.PARSER_WARNING;

    /**
     * Method that tests warning message on domain name.
     */
    @Test
    public void testDomainNameWarning() {
        final String pathFileTest = "src/test/resources/parser/problem_parser_warning.pddl";
        final String errorToTest = "Domain name warning";
        Tools.FileType fileType = Tools.FileType.PROBLEM_FILE;

        System.out.println("ParserParserWarningTest: Test " + errorToTest);

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
