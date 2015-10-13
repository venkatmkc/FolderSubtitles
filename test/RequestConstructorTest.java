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
}
