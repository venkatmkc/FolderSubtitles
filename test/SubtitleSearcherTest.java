import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class SubtitleSearcherTest {

    @Mock
    OpenSubtitleHasher openSubtitleHasher;

    private SubtitleSearcher subtitleSearcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        subtitleSearcher = new SubtitleSearcher(openSubtitleHasher);
    }

    @Test
    public void fileHashShouldBeComputed() throws ParserConfigurationException, SAXException, IOException {
        String fileLocation = "file location";
        String loginToken = "loginToken";
        subtitleSearcher.search(fileLocation, loginToken);

        verify(openSubtitleHasher).computeHash("file location");
    }

    @Test
    public void fileSizeShouldBeCalculated() throws ParserConfigurationException, SAXException, IOException {
        String fileLocation = "file location";
        String loginToken = "loginToken";
        subtitleSearcher.search(fileLocation, loginToken);

        verify(openSubtitleHasher).fileSize("file location");
    }
}