import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SubtitleSearcherTest {

    @Mock
    OpenSubtitleHasher openSubtitleHasher;

    @Mock
    RequestConstructor requestConstructor;

    @Mock
    Requester requester;

    @Mock
    TokenParser tokenParser;

    private SubtitleSearcher subtitleSearcher;

    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        MockitoAnnotations.initMocks(this);
        subtitleSearcher = new SubtitleSearcher(openSubtitleHasher, requestConstructor, requester, tokenParser);
        when(requestConstructor.searchRequestMessage(anyString(), anyString(), anyLong())).thenReturn("xmlrequest");
        when(requester.request("xmlrequest")).thenReturn("response");
        when(tokenParser.parseSearchResponse("response")).thenReturn("link");
    }

    @Test
    public void fileHashShouldBeComputed() throws ParserConfigurationException, SAXException, IOException {
        String fileLocation = "file location";
        String loginToken = "request";
        subtitleSearcher.search(fileLocation, loginToken);

        verify(openSubtitleHasher).computeHash("file location");
    }

    @Test
    public void fileSizeShouldBeCalculated() throws ParserConfigurationException, SAXException, IOException {
        String fileLocation = "file location";
        String loginToken = "request";
        subtitleSearcher.search(fileLocation, loginToken);

        verify(openSubtitleHasher).fileSize("file location");
    }

    @Test
    public void requestShouldBeConstructedForSearch() throws IOException, ParserConfigurationException, SAXException {
        String fileLocation = "file location";
        String loginToken = "request";
        subtitleSearcher.search(fileLocation, loginToken);

        verify(requestConstructor).searchRequestMessage(anyString(),anyString(), anyLong());
    }

    @Test
    public void requestShouldBeSent() throws IOException, ParserConfigurationException, SAXException {
        String fileLocation = "file location";
        String loginToken = "request";
        subtitleSearcher.search(fileLocation, loginToken);

        verify(requester).request("xmlrequest");
    }

    @Test
    public void searchShouldProduceDownloadLink() throws IOException, ParserConfigurationException, SAXException {
        String fileLocation = "file location";
        String loginToken = "request";

        String downloadLink = subtitleSearcher.search(fileLocation, loginToken);

        assertThat(downloadLink, is(equalTo("link")));
    }
}