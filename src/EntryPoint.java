import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput();
        RequestConstructor requestConstructor = new RequestConstructor();
        HttpGatewayApi httpGatewayApi = new HttpGatewayApi();
        TokenRequester tokenRequester = new TokenRequester(httpGatewayApi);
        User user = new User(consoleInputOutput);
        FolderSubtitles folderSubtitles = new FolderSubtitles(requestConstructor, tokenRequester, user);
        folderSubtitles.start();
    }
}
