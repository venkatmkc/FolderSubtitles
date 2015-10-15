import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginTest {
    @Mock
    RequestConstructor requestConstructor;

    @Mock
    RequestGateway requestGateway;

    @Mock
    ResponseParser responseParser;

    private Login login;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        login = new Login(requestConstructor, requestGateway, responseParser);
        when(requestConstructor.loginRequestMessage("default", "default", "OSTestUserAgent")).thenReturn("request");
        when(requestGateway.request("request")).thenReturn("response");
        when(responseParser.parseLoginTokenResponse("response")).thenReturn("request");
    }




    @Test
    public void requestMessageShouldBeObtained() throws IOException, ParserConfigurationException, SAXException {
        login.loginToken();

        verify(requestConstructor).loginRequestMessage("default", "default", "OSTestUserAgent");
    }

    @Test
    public void requestShouldBeSentToObtainUserToken() throws IOException, ParserConfigurationException, SAXException {
        login.loginToken();

        verify(requestGateway).request("request");
    }

    @Test
    public void xmlLoginTokenResponseShouldBeParsed() throws IOException, ParserConfigurationException, SAXException {
        login.loginToken();

        verify(responseParser).parseLoginTokenResponse("response");
    }
    @Test
    public void loginShouldProduceLoginToken() throws ParserConfigurationException, SAXException, IOException {
        String loginToken = login.loginToken();

        assertThat(loginToken, is(equalTo("request")));
    }
}