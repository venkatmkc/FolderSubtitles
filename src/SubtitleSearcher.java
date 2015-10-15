import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SubtitleSearcher {
    private OpenSubtitleHasher openSubtitleHasher;
    private RequestConstructor requestConstructor;
    private RequestGateway requestGateway;
    private ResponseParser responseParser;

    public SubtitleSearcher(OpenSubtitleHasher openSubtitleHasher, RequestConstructor requestConstructor, RequestGateway requestGateway, ResponseParser responseParser) {
        this.openSubtitleHasher = openSubtitleHasher;
        this.requestConstructor = requestConstructor;
        this.requestGateway = requestGateway;
        this.responseParser = responseParser;
    }

    public String search(String fileLocation, String loginToken) throws IOException, ParserConfigurationException, SAXException {
        String fileHash = openSubtitleHasher.computeHash(fileLocation);
        long fileSize = openSubtitleHasher.fileSize(fileLocation);
        String requestMessage = requestConstructor.searchRequestMessage(loginToken, fileHash, fileSize);
        String searchResponse = requestGateway.request(requestMessage);
        return responseParser.parseSearchResponse(searchResponse);
    }
}
