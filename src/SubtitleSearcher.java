import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SubtitleSearcher {
    private OpenSubtitleHasher openSubtitleHasher;
    private RequestConstructor requestConstructor;
    private Requester requester;
    private TokenParser tokenParser;

    public SubtitleSearcher(OpenSubtitleHasher openSubtitleHasher, RequestConstructor requestConstructor, Requester requester, TokenParser tokenParser) {
        this.openSubtitleHasher = openSubtitleHasher;
        this.requestConstructor = requestConstructor;
        this.requester = requester;
        this.tokenParser = tokenParser;
    }

    public String search(String fileLocation, String loginToken) throws IOException, ParserConfigurationException, SAXException {
        String fileHash = openSubtitleHasher.computeHash(fileLocation);
        long fileSize = openSubtitleHasher.fileSize(fileLocation);
        String requestMessage = requestConstructor.searchRequestMessage(loginToken, fileHash, fileSize);
        String searchResponse = requester.request(requestMessage);
        return tokenParser.parseSearchResponse(searchResponse);
    }
}
