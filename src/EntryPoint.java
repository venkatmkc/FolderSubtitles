import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput();
        RequestConstructor requestConstructor = new RequestConstructor();
        HttpGatewayApi httpGatewayApi = new HttpGatewayApi();
        Requester requester = new Requester(httpGatewayApi);
        User user = new User(consoleInputOutput);
        TokenParser tokenParser = new TokenParser();
        OpenSubtitleHasher openSubtitleHasher = new OpenSubtitleHasher();
        SubtitleSearcher subtitleSearcher = new SubtitleSearcher(openSubtitleHasher, requestConstructor, requester, tokenParser);
        FolderSubtitles folderSubtitles = new FolderSubtitles(requestConstructor, requester, user, tokenParser, consoleInputOutput, openSubtitleHasher, subtitleSearcher);
        folderSubtitles.start();
    }
}
