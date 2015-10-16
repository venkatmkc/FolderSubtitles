import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by venkatmk on 16/10/15.
 */
public class VideoFinderTest {
    @Test
    public void shouldFindWhetherItIsAVideo() {
        String[] videoFormats = {"avi", "mkv", "flv", "mp4"};
        VideoFinder videoFinder = new VideoFinder(videoFormats);

        boolean actualResult = videoFinder.isVideoFile("sample.avi");

        assertTrue(actualResult);
    }
}
