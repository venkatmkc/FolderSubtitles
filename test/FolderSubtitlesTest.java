import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import javax.jws.soap.SOAPBinding;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class FolderSubtitlesTest {
    @Mock
    RequestConstructor requestConstructor;

    @Mock
    User user;

    private FolderSubtitles folderSubtitles;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        folderSubtitles = new FolderSubtitles(requestConstructor, user);
    }

    @Test
    public void userShouldBeAbleToLogin() {
        folderSubtitles.start();

        verify(user).login(requestConstructor);
    }

}
