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
    TokenRequester tokenRequester;

    @Mock
    TokenParser tokenParser;

    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Mock
    OpenSubtitleHasher openSubtitleHasher;

    private FolderSubtitles folderSubtitles;

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        folderSubtitles = new FolderSubtitles(requestConstructor, tokenRequester, user, tokenParser, consoleInputOutput, openSubtitleHasher);
        when(consoleInputOutput.getInputFromUser()).thenReturn("file location");
        when(openSubtitleHasher.computeHash("file location")).thenReturn("computed hash");
    }

    @Test
    public void userShouldBeAbleToLogin() throws IOException, ParserConfigurationException, SAXException {
        folderSubtitles.start();

        verify(user).login(requestConstructor, tokenRequester, tokenParser);
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
    public void fileHashShouldBeComputed() throws ParserConfigurationException, SAXException, IOException {
        folderSubtitles.start();

        verify(openSubtitleHasher).computeHash("file location");
    }
}
