import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Matchers.any;

public class RequestGatewayTest {
    @Mock
    HttpGatewayApi httpGatewayApi;

    private RequestGateway requestGateway;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        requestGateway = new RequestGateway(httpGatewayApi);
    }

    @Test
    public void connectionShouldBeEstablishedWithTheServer() throws IOException {
        requestGateway.request("hello");

        Mockito.verify(httpGatewayApi).startConnection("http://api.opensubtitles.org/xml-rpc");
    }
}