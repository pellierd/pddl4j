package fr.uga.pddl4j.test.parser;

import fr.uga.pddl4j.parser.Message;

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
    //private Message.Type errorType = Message.Type.PARSER_WARNING;

    /**
     * Method that tests brackets parsing error in domain file.
     */
    /*@Test
    public void testBracketsErrorDomainFile() {
        final String pathFileTest = "src/test/resources/parser/domain_lexical_error_0.pddl";
        final String errorToTest = "Bracket issue";
        Tools.FileType fileType = Tools.FileType.DOMAIN_FILE;

        final ErrorManager errManager = Tools.generateErrorMessages(pathFileTest, errorToTest, fileType);
        errManager.printAll();
        if (!errManager.getMessages().isEmpty()) {
            for (Message message : errManager.getMessages()) {
                Assert.assertTrue(message.getType().equals(errorType));
            }
        }

        Assert.assertTrue(errManager.getMessages().size() == 1);
    }*/

}
