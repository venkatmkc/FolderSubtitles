import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        RequestConstructor requestConstructor = new RequestConstructor();
        HttpGatewayApi httpGatewayApi = new HttpGatewayApi();
        RequestGateway requestGateway = new RequestGateway(httpGatewayApi);
        ResponseParser responseParser = new ResponseParser();
        Login login = new Login(requestConstructor, requestGateway, responseParser);
        OpenSubtitleHasher openSubtitleHasher = new OpenSubtitleHasher();
        SubtitleSearcher subtitleSearcher = new SubtitleSearcher(openSubtitleHasher, requestConstructor, requestGateway, responseParser);
        HttpDownloader httpDownloader = new HttpDownloader();
        ZipChanger zipchanger = new ZipChanger();
        FileSubtitle fileSubtitle = new FileSubtitle(subtitleSearcher, httpDownloader, zipchanger);
        VideoFinder videoFinder = new VideoFinder(new String[]{"avi", "mkv"});
        FolderSubtitles folderSubtitles = new FolderSubtitles(login, fileSubtitle, "/Users/venkatmk/old mac/Arv hd/", videoFinder);
        folderSubtitles.start();
    }
}
