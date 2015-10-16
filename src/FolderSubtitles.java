import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FolderSubtitles {
    private Login login;
    private FileSubtitle fileSubtitle;
    private String folderPath;
    private VideoFinder videoFinder;

    public FolderSubtitles(Login login, FileSubtitle fileSubtitle, String folderPath, VideoFinder videoFinder) {
        this.login = login;
        this.fileSubtitle = fileSubtitle;
        this.folderPath = folderPath;
        this.videoFinder = videoFinder;
    }

    public void start() throws ParserConfigurationException, SAXException, IOException {
        String loginToken = login.loginToken();
        ArrayList<String> allFiles = getAllFiles(folderPath);
        ArrayList<String> videoFiles = getAllVideoFiles(videoFinder, allFiles);
        for(String videoFile : videoFiles) {
            fileSubtitle.downloadSubtitle(loginToken, videoFile);
        }
    }

    private ArrayList<String> getAllFiles(String folderPath) {
        File folder = new File(folderPath);
        ArrayList<String> fileNames = new ArrayList<>();
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                fileNames.add(file.getAbsolutePath());
            } else
                fileNames.addAll(getAllFiles(file.getPath()));
        }
        return fileNames;
    }

    private ArrayList<String> getAllVideoFiles(VideoFinder videoFinder, ArrayList<String> allFiles) {
        ArrayList<String> videoFileNames = new ArrayList<>();
        for(String fileName : allFiles) {
            if(videoFinder.isVideoFile(fileName)) {
                videoFileNames.add(fileName);
            }
        }
        return videoFileNames;
    }
}
