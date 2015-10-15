import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class FileSubtitleTest {
    @Mock
    RequestConstructor requestConstructor;

    @Mock
    Login login;

    @Mock
    RequestGateway requestGateway;

    @Mock
    ResponseParser responseParser;


    @Mock
    SubtitleSearcher subtitleSearcher;

    @Mock
    HttpDownloader httpDownloader;

    @Mock
    ZipChanger zipchanger;

    private FileSubtitle fileSubtitle;

    @Before
    public void setUp() throws IOException, ParserConfigurationException, SAXException {
        MockitoAnnotations.initMocks(this);
        fileSubtitle = new FileSubtitle(subtitleSearcher, httpDownloader, zipchanger);
        when(subtitleSearcher.search("file location", "computed hash")).thenReturn("target url");
    }




    @Test
    public void searchShouldBePerformedForTheFile() throws ParserConfigurationException, SAXException, IOException {
        fileSubtitle.downloadSubtitle("login token", "filename");

        verify(subtitleSearcher).search(anyString(), anyString());
    }

    @Test
    public void subtitleShouldBeDownloaded() throws ParserConfigurationException, SAXException, IOException {
        fileSubtitle.downloadSubtitle("login token", "filename");

        verify(httpDownloader).download(anyString(), anyString());
    }

    @Test
    public void zipFileShouldBeExtractedToSrt() throws ParserConfigurationException, SAXException, IOException {
        fileSubtitle.downloadSubtitle("login token", "filename");

        verify(zipchanger).extractZipToSrt(anyString());
    }
}
