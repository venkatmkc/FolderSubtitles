import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class FolderSubtitlesTest {
    @Mock
    RequestConstructor requestConstructor;

    @Mock
    User user;

    @Mock
    Requester requester;

    @Mock
    TokenParser tokenParser;

    @Mock
    ConsoleInputOutput consoleInputOutput;


    @Mock
    SubtitleSearcher subtitleSearcher;

    @Mock
    HttpDownloader httpDownloader;

    @Mock
    ZipChanger zipchanger;

    private FolderSubtitles folderSubtitles;

    @Before
    public void setUp() throws IOException, ParserConfigurationException, SAXException {
        MockitoAnnotations.initMocks(this);
        folderSubtitles = new FolderSubtitles(requestConstructor, requester, user, tokenParser, consoleInputOutput, subtitleSearcher, httpDownloader, zipchanger);
        when(consoleInputOutput.getInputFromUser()).thenReturn("file location");
        when(subtitleSearcher.search("file location", "computed hash")).thenReturn("target url");
    }

    @Test
    public void userShouldBeAbleToLogin() throws IOException, ParserConfigurationException, SAXException {
        folderSubtitles.start();

        verify(user).login(requestConstructor, requester, tokenParser);
    }

    @Test
    public void shouldGetFileLocationFromUser() throws ParserConfigurationException, SAXException, IOException {
        folderSubtitles.start();

        verify(consoleInputOutput).printMessage(Messages.FILE_LOCATION_PROMPT);
    }

    @Test
    public void fileLocationShouldBeObtainedFromTheUser() throws ParserConfigurationException, SAXException, IOException {
        folderSubtitles.start();

        verify(consoleInputOutput).getInputFromUser();
    }

    @Test
    public void searchShouldBePerformedForTheFile() throws ParserConfigurationException, SAXException, IOException {
        folderSubtitles.start();

        verify(subtitleSearcher).search(anyString(), anyString());
    }

    @Test
    public void subtitleShouldBeDownloaded() throws ParserConfigurationException, SAXException, IOException {
        folderSubtitles.start();

        verify(httpDownloader).download(anyString(), anyString());
    }

    @Test
    public void zipFileShouldBeExtractedToSrt() throws ParserConfigurationException, SAXException, IOException {
        folderSubtitles.start();

        verify(zipchanger).extractZipToSrt(anyString());
    }
}
