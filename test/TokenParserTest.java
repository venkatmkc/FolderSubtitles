import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by venkatmk on 13/10/15.
 */
public class TokenParserTest {
    @Test
    public void tokenResponseShouldBeParsedToToken() throws IOException, SAXException, ParserConfigurationException {
        TokenParser tokenParser = new TokenParser();
        String response = "null<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<methodResponse>\n" +
                "<params>\n" +
                " <param>\n" +
                "  <value>\n" +
                "   <struct>\n" +
                "    <member>\n" +
                "     <name>token</name>\n" +
                "     <value>\n" +
                "      <string>ijrjtrcf7qof0u168t0pii0bg6</string>\n" +
                "     </value>\n" +
                "    </member>\n" +
                "    <member>\n" +
                "     <name>status</name>\n" +
                "     <value>\n" +
                "      <string>200 OK</string>\n" +
                "     </value>\n" +
                "    </member>\n" +
                "    <member>\n" +
                "     <name>seconds</name>\n" +
                "     <value>\n" +
                "      <double>0.009</double>\n" +
                "     </value>\n" +
                "    </member>\n" +
                "   </struct>\n" +
                "  </value>\n" +
                " </param>\n" +
                "</params>\n" +
                "</methodResponse>";

        String loginToken = tokenParser.parseLoginTokenResponse(response);

        assertThat(loginToken, is(equalTo("ijrjtrcf7qof0u168t0pii0bg6")));
    }
}
