import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class FolderSubtitlesTest {
    @Mock
    ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void usernameShouldBePromptedFromTheUser() {
        FolderSubtitles folderSubtitles = new FolderSubtitles(consoleInputOutput);

        folderSubtitles.start();

        Mockito.verify(consoleInputOutput).printMessage("Username : ");
    }

}
