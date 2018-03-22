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
    //private Message.Type errorType = Message.Type.PARSER_ERROR;

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
