import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class OpenSubtitleHasherTest {
    @Test
    public void fileSizeShouldBeCalculated() {
        OpenSubtitleHasher openSubtitleHasher = new OpenSubtitleHasher();
        String fileLocation = "/Users/venkatmk/breakdance.avi";

        assertEquals(12909756, openSubtitleHasher.fileSize(fileLocation));
    }
}