import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput();
        RequestConstructor requestConstructor = new RequestConstructor();
        HttpGatewayApi httpGatewayApi = new HttpGatewayApi();
        TokenRequester tokenRequester = new TokenRequester(httpGatewayApi);
        User user = new User(consoleInputOutput);
        TokenParser tokenParser = new TokenParser();
        OpenSubtitleHasher openSubtitleHasher = new OpenSubtitleHasher();
        FolderSubtitles folderSubtitles = new FolderSubtitles(requestConstructor, tokenRequester, user, tokenParser, consoleInputOutput, openSubtitleHasher);
        folderSubtitles.start();
    }
}
