import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;

public class TokenRequesterTest {
    @Mock
    HttpGatewayApi httpGatewayApi;

    private TokenRequester tokenRequester;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        tokenRequester = new TokenRequester(httpGatewayApi);
    }

    @Test
    public void connectionShouldBeEstablishedWithTheServer() throws IOException {
        tokenRequester.loginToken("hello");

        Mockito.verify(httpGatewayApi).startConnection("http://api.opensubtitles.org/xml-rpc");
    }
}