import java.io.IOException;

public class FolderSubtitles {
    private RequestConstructor requestConstructor;
    private TokenRequester tokenRequester;
    private User user;


    public FolderSubtitles(RequestConstructor requestConstructor, TokenRequester tokenRequester, User user) {
        this.requestConstructor = requestConstructor;
        this.tokenRequester = tokenRequester;
        this.user = user;
    }

    public void start() throws IOException {
        user.login(requestConstructor, tokenRequester);
    }
}
