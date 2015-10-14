import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class User {

    private ConsoleInputOutput consoleInputOutput;
    private String username;
    private String password;

    private static final String userAgent = "OSTestUserAgent";

    public User(ConsoleInputOutput consoleInputOutput) {
        this.consoleInputOutput = consoleInputOutput;
    }

    public void getUsernameFromUser() {
        username = consoleInputOutput.getInputFromUser();
    }


    public void getPasswordFromUser() {
        password = consoleInputOutput.getInputFromUser();
    }

    public String login(RequestConstructor requestConstructor, Requester requester, TokenParser tokenParser) throws IOException, ParserConfigurationException, SAXException {
        consoleInputOutput.printMessage(Messages.USERNAME_PROMPT);
        getUsernameFromUser();
        consoleInputOutput.printMessage(Messages.PASSWORD_PROMPT);
        getPasswordFromUser();
        String requestMessage = requestConstructor.loginRequestMessage(username, password, userAgent);
        String tokenResponse = requester.request(requestMessage);
        return tokenParser.parseLoginTokenResponse(tokenResponse);
    }
}
