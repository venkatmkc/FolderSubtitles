/**
 * Created by venkatmk on 16/10/15.
 */
public class VideoFinder {
    private String[] videoFormats;

    public VideoFinder(String[] videoFormats) {
        this.videoFormats = videoFormats;
    }

    public boolean isVideoFile(String filename) {
        for(String videoFormat : videoFormats) {
            if(filename.contains(videoFormat)) {
                return true;
            }
        }
        return false;
    }
}
