import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class User {

    private ConsoleInputOutput consoleInputOutput;
    private String username;
    private String password;

    private static final String userAgent = "OSTestUserAgent";

    public User(ConsoleInputOutput consoleInputOutput) {
        this.consoleInputOutput = consoleInputOutput;
    }

    public void promptUsername() {
        consoleInputOutput.printMessage("Username : ");
    }

    public void getUsernameFromUser() {
        username = consoleInputOutput.getInputFromUser();
    }

    public void promptPassword() {
        consoleInputOutput.printMessage("Password : ");
    }

    public void getPasswordFromUser() {
        password = consoleInputOutput.getInputFromUser();
    }

    public void login(RequestConstructor requestConstructor, TokenRequester tokenRequester) throws IOException {
        promptUsername();
        getUsernameFromUser();
        promptPassword();
        getPasswordFromUser();
        String requestMessage = requestConstructor.loginRequestMessage(username, password, userAgent);
        String tokenResponse = tokenRequester.loginToken(requestMessage);
        System.out.println(tokenResponse);
    }


}
