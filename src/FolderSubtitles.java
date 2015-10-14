import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FolderSubtitles {
    private RequestConstructor requestConstructor;
    private TokenRequester tokenRequester;
    private User user;
    private TokenParser tokenParser;
    private ConsoleInputOutput consoleInputOutput;
    private OpenSubtitleHasher openSubtitleHasher;


    public FolderSubtitles(RequestConstructor requestConstructor, TokenRequester tokenRequester, User user, TokenParser tokenParser, ConsoleInputOutput consoleInputOutput, OpenSubtitleHasher openSubtitleHasher) {
        this.requestConstructor = requestConstructor;
        this.tokenRequester = tokenRequester;
        this.user = user;
        this.tokenParser = tokenParser;
        this.consoleInputOutput = consoleInputOutput;
        this.openSubtitleHasher = openSubtitleHasher;
    }

    public void start() throws IOException, ParserConfigurationException, SAXException {
        String loginToken = user.login(requestConstructor, tokenRequester, tokenParser);
        consoleInputOutput.printMessage(Messages.FILE_LOCATION_PROMPT);
        String fileLocation = consoleInputOutput.getInputFromUser();
    }
}
