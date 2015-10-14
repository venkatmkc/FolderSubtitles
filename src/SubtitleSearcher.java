import java.io.IOException;

public class SubtitleSearcher {
    private OpenSubtitleHasher openSubtitleHasher;

    public SubtitleSearcher(OpenSubtitleHasher openSubtitleHasher) {
        this.openSubtitleHasher = openSubtitleHasher;
    }

    public void search(String fileLocation, String loginToken) throws IOException {
        String fileHash = openSubtitleHasher.computeHash(fileLocation);
        long fileSize = openSubtitleHasher.fileSize(fileLocation);
    }
}
