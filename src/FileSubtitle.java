import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FileSubtitle {
    private SubtitleSearcher subtitleSearcher;
    private HttpDownloader httpDownloader;
    private ZipChanger zipchanger;

    public FileSubtitle(SubtitleSearcher subtitleSearcher, HttpDownloader httpDownloader, ZipChanger zipchanger) {
        this.subtitleSearcher = subtitleSearcher;
        this.httpDownloader = httpDownloader;
        this.zipchanger = zipchanger;
    }

    public void downloadSubtitle(String loginToken, String fileLocation) throws IOException, ParserConfigurationException, SAXException {
        String downloadLink = subtitleSearcher.search(fileLocation, loginToken);
        String zipFileLocation = httpDownloader.download(downloadLink, fileLocation);
        zipchanger.extractZipToSrt(zipFileLocation);
    }
}
