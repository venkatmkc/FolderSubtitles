import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequestConstructorTest {
    @Test
    public void loginRequestMessageShouldBeConstructed() {
        RequestConstructor requestConstructor = new RequestConstructor();
        String username = "eduo";
        String password = "******";
        String language = "en";
        String userAgent = "SolEol 0.0.8";

        String loginRequestMessage = requestConstructor.loginRequestMessage(username, password, userAgent);

        assertThat(loginRequestMessage, is(equalTo("<methodCall>\n" +
                " <methodName>LogIn</methodName>\n" +
                " <params>\n" +
                "  <param>\n" +
                "   <value><string>eduo</string></value>\n" +
                "  </param>\n" +
                "  <param>\n" +
                "   <value><string>******</string></value>\n" +
                "  </param>\n" +
                "  <param>\n" +
                "   <value><string>en</string></value>\n" +
                "  </param>\n" +
                "  <param>\n" +
                "   <value><string>SolEol 0.0.8</string></value>\n" +
                "  </param>\n" +
                " </params>\n" +
                "</methodCall>")));
    }

    @Test
    public void searchRequestShoulddBeConstructed() {
        RequestConstructor requestConstructor = new RequestConstructor();
        String loginToken = "5fdgt2e9qriblpbojnq0j46op1";
        String fileHash = "7d9cd5def91c9432";
        long fileSize = 735934464;

        String searchRequestMessage = requestConstructor.searchRequestMessage(loginToken, fileHash, fileSize);

        assertThat(searchRequestMessage, is(equalTo("<methodCall>\n" +
                " <methodName>SearchSubtitles</methodName>\n" +
                " <params>\n" +
                "  <param>\n" +
                "   <value><string>5fdgt2e9qriblpbojnq0j46op1</string></value>\n" +
                "  </param>\n" +
                "  <param>\n" +
                "   <value>\n" +
                "    <array>\n" +
                "     <data>\n" +
                "      <value>\n" +
                "       <struct>\n" +
                "        <member>\n" +
                "         <name>sublanguageid</name>\n" +
                "         <value><string>eng</string>\n" +
                "         </value>\n" +
                "        </member>\n" +
                "        <member>\n" +
                "         <name>moviehash</name>\n" +
                "         <value><string>7d9cd5def91c9432</string></value>\n" +
                "        </member>\n" +
                "        <member>\n" +
                "         <name>moviebytesize</name>\n" +
                "         <value><double>735934464</double></value>\n" +
                "        </member>\n" +
                "       </struct>\n" +
                "      </value>\n" +
                "     </data>\n" +
                "    </array>\n" +
                "   </value>\n" +
                "  </param>\n" +
                " </params>\n" +
                "</methodCall>")));
    }
}
