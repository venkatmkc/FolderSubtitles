import java.io.IOException;
import java.net.HttpURLConnection;

public class Requester {
    private HttpGatewayApi httpGatewayApi;
    private final String openOrgServerUrl = "http://api.opensubtitles.org/xml-rpc";

    public Requester(HttpGatewayApi httpGatewayApi) {
        this.httpGatewayApi = httpGatewayApi;
    }

    public String request(String requestMessage) throws IOException {
        HttpURLConnection httpURLConnection = httpGatewayApi.startConnection(openOrgServerUrl);
        httpGatewayApi.sendRequestToServer(httpURLConnection, requestMessage);
        return httpGatewayApi.getResponseFromServer(httpURLConnection);
    }
}
