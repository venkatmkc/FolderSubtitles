import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FolderSubtitles {
    private RequestConstructor requestConstructor;
    private Requester requester;
    private User user;
    private TokenParser tokenParser;
    private ConsoleInputOutput consoleInputOutput;
    private OpenSubtitleHasher openSubtitleHasher;
    private SubtitleSearcher subtitleSearcher;


    public FolderSubtitles(RequestConstructor requestConstructor, Requester requester, User user, TokenParser tokenParser, ConsoleInputOutput consoleInputOutput, OpenSubtitleHasher openSubtitleHasher, SubtitleSearcher subtitleSearcher) {
        this.requestConstructor = requestConstructor;
        this.requester = requester;
        this.user = user;
        this.tokenParser = tokenParser;
        this.consoleInputOutput = consoleInputOutput;
        this.openSubtitleHasher = openSubtitleHasher;
        this.subtitleSearcher = subtitleSearcher;
    }

    public void start() throws IOException, ParserConfigurationException, SAXException {
        String loginToken = user.login(requestConstructor, requester, tokenParser);
        consoleInputOutput.printMessage(Messages.FILE_LOCATION_PROMPT);
        String fileLocation = consoleInputOutput.getInputFromUser();
        System.out.println(subtitleSearcher.search(fileLocation, loginToken));
    }
}
