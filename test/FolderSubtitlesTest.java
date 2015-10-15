import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

public class FolderSubtitlesTest {
    @Mock
    Login login;

    @Mock
    FileSubtitle fileSubtitle;

    private FolderSubtitles folderSubtitles;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        folderSubtitles = new FolderSubtitles(login, fileSubtitle);
    }

    @Test
    public void userShouldBeAbleToLogin() throws IOException, ParserConfigurationException, SAXException {
        folderSubtitles.start();

        verify(login).loginToken();
    }

    @Test
    public void subtitleShouldBeDownloadedForFile() throws ParserConfigurationException, SAXException, IOException {
        folderSubtitles.start();

        verify(fileSubtitle).downloadSubtitle(anyString(), anyString());
    }

}