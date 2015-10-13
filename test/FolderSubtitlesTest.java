import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class FolderSubtitlesTest {
    @Mock
    RequestConstructor requestConstructor;

    @Mock
    User user;

    @Mock
    TokenRequester tokenRequester;

    private FolderSubtitles folderSubtitles;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        folderSubtitles = new FolderSubtitles(requestConstructor, tokenRequester, user);
    }

    @Test
    public void userShouldBeAbleToLogin() throws IOException {
        folderSubtitles.start();

        verify(user).login(requestConstructor, tokenRequester);
    }

}
