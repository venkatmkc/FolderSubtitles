import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserTest{
    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Mock
    RequestConstructor requestConstructor;

    @Mock
    TokenRequester tokenRequester;

    private User user;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new User(consoleInputOutput);
        when(consoleInputOutput.getInputFromUser()).thenReturn("username", "password");
        when(requestConstructor.loginRequestMessage("username", "password", "OSTestUserAgent")).thenReturn("request");
    }

    @Test
    public void usernameShouldBePromptedFromTheUser() {
        user.promptUsername();

        verify(consoleInputOutput).printMessage("Username : ");
    }

    @Test
    public void usernameShouldBeObtainedFromTheUser() {
        user.getUsernameFromUser();

        verify(consoleInputOutput).getInputFromUser();
    }

    @Test
    public void passwordShouldBePromptedFromTheUser() {
        user.promptPassword();

        verify(consoleInputOutput).printMessage("Password : ");
    }

    @Test
    public void passwordShouldBeObtainedFromTheUser() {
        user.getPasswordFromUser();

        verify(consoleInputOutput).getInputFromUser();
    }

    @Test
    public void requestMessageShouldBeObtained() throws IOException {
        user.login(requestConstructor, tokenRequester);

        verify(requestConstructor).loginRequestMessage("username", "password", "OSTestUserAgent");
    }

    @Test
    public void requestShouldBeSentToObtainUserToken() throws IOException {
        user.login(requestConstructor, tokenRequester);

        verify(tokenRequester).loginToken("request");
    }
}