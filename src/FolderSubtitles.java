import java.util.Scanner;

public class FolderSubtitles {
    private RequestConstructor requestConstructor;
    private User user;


    public FolderSubtitles(RequestConstructor requestConstructor, User user) {
        this.requestConstructor = requestConstructor;
        this.user = user;
    }

    public void start() {
        user.login(requestConstructor);
    }
}
