import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Matchers.any;

public class RequesterTest {
    @Mock
    HttpGatewayApi httpGatewayApi;

    private Requester requester;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        requester = new Requester(httpGatewayApi);
    }

    @Test
    public void connectionShouldBeEstablishedWithTheServer() throws IOException {
        requester.request("hello");

        Mockito.verify(httpGatewayApi).startConnection("http://api.opensubtitles.org/xml-rpc");
    }
}