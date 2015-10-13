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

    public void login(RequestConstructor requestConstructor) {
        promptUsername();
        getUsernameFromUser();
        promptPassword();
        getPasswordFromUser();
        requestConstructor.loginRequestMessage(username, password, userAgent);
    }
}
