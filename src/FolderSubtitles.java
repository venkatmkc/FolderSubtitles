import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FolderSubtitles {
    private RequestConstructor requestConstructor;
    private Requester requester;
    private User user;
    private TokenParser tokenParser;
    private ConsoleInputOutput consoleInputOutput;
    private SubtitleSearcher subtitleSearcher;
    private HttpDownloader httpDownloader;
    private ZipChanger zipchanger;


    public FolderSubtitles(RequestConstructor requestConstructor, Requester requester, User user, TokenParser tokenParser, ConsoleInputOutput consoleInputOutput, SubtitleSearcher subtitleSearcher, HttpDownloader httpDownloader, ZipChanger zipchanger) {
        this.requestConstructor = requestConstructor;
        this.requester = requester;
        this.user = user;
        this.tokenParser = tokenParser;
        this.consoleInputOutput = consoleInputOutput;
        this.subtitleSearcher = subtitleSearcher;
        this.httpDownloader = httpDownloader;
        this.zipchanger = zipchanger;
    }

    public void start() throws IOException, ParserConfigurationException, SAXException {
        String loginToken = user.login(requestConstructor, requester, tokenParser);
        consoleInputOutput.printMessage(Messages.FILE_LOCATION_PROMPT);
        String fileLocation = consoleInputOutput.getInputFromUser();
        String downloadLink = subtitleSearcher.search(fileLocation, loginToken);
        String zipFileLocation = httpDownloader.download(downloadLink, fileLocation);
        zipchanger.extractZipToSrt(zipFileLocation);
    }
}
