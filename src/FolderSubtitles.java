import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FolderSubtitles {
    private Login login;
    private FileSubtitle fileSubtitle;
    private final String fileLocation = "/Users/venkatmk/breakdance.avi";

    public FolderSubtitles(Login login, FileSubtitle fileSubtitle) {
        this.login = login;
        this.fileSubtitle = fileSubtitle;
    }

    public void start() throws ParserConfigurationException, SAXException, IOException {
        String loginToken = login.loginToken();
        fileSubtitle.downloadSubtitle(loginToken, fileLocation);
    }
}
