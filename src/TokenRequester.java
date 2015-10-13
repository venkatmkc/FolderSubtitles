import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by venkatmk on 13/10/15.
 */
public class TokenRequester {
    private HttpGatewayApi httpGatewayApi;
    private final String openOrgServerUrl = "http://api.opensubtitles.org/xml-rpc";

    public TokenRequester(HttpGatewayApi httpGatewayApi) {
        this.httpGatewayApi = httpGatewayApi;
    }

    public String loginToken(String requestMessage) throws IOException {
        HttpURLConnection httpURLConnection = httpGatewayApi.startConnection(openOrgServerUrl);
        httpGatewayApi.sendRequestToServer(httpURLConnection, requestMessage);
        return httpGatewayApi.getResponseFromServer(httpURLConnection);
    }
}
