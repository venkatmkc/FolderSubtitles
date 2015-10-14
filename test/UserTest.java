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

public class UserTest{


    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Mock
    RequestConstructor requestConstructor;

    @Mock
    Requester requester;

    @Mock
    TokenParser tokenParser;

    private User user;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new User(consoleInputOutput);
        when(consoleInputOutput.getInputFromUser()).thenReturn("username", "password");
        when(requestConstructor.loginRequestMessage("username", "password", "OSTestUserAgent")).thenReturn("request");
        when(requester.request("request")).thenReturn("response");
        when(tokenParser.parseLoginTokenResponse("response")).thenReturn("request");
    }

    @Test
    public void usernameShouldBePromptedFromTheUser() throws ParserConfigurationException, SAXException, IOException {
        user.login(requestConstructor, requester, tokenParser);

        verify(consoleInputOutput).printMessage(Messages.USERNAME_PROMPT);
    }

    @Test
    public void usernameShouldBeObtainedFromTheUser() {
        user.getUsernameFromUser();

        verify(consoleInputOutput).getInputFromUser();
    }

    @Test
    public void passwordShouldBePromptedFromTheUser() throws ParserConfigurationException, SAXException, IOException {
        user.login(requestConstructor, requester, tokenParser);

        verify(consoleInputOutput).printMessage(Messages.PASSWORD_PROMPT);
    }

    @Test
    public void passwordShouldBeObtainedFromTheUser() {
        user.getPasswordFromUser();

        verify(consoleInputOutput).getInputFromUser();
    }

    @Test
    public void requestMessageShouldBeObtained() throws IOException, ParserConfigurationException, SAXException {
        user.login(requestConstructor, requester, tokenParser);

        verify(requestConstructor).loginRequestMessage("username", "password", "OSTestUserAgent");
    }

    @Test
    public void requestShouldBeSentToObtainUserToken() throws IOException, ParserConfigurationException, SAXException {
        user.login(requestConstructor, requester, tokenParser);

        verify(requester).request("request");
    }

    @Test
    public void xmlLoginTokenResponseShouldBeParsed() throws IOException, ParserConfigurationException, SAXException {
        user.login(requestConstructor, requester, tokenParser);

        verify(tokenParser).parseLoginTokenResponse("response");
    }
    @Test
    public void loginShouldProduceLoginToken() throws ParserConfigurationException, SAXException, IOException {
        String loginToken = user.login(requestConstructor, requester, tokenParser);

        assertThat(loginToken, is(equalTo("request")));
    }
}