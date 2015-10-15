import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Login {

    private static String username = "default";
    private static String password = "default";

    private static final String userAgent = "OSTestUserAgent";
    private final RequestConstructor requestConstructor;
    private final RequestGateway requestGateway;
    private final ResponseParser responseParser;

    public Login(RequestConstructor requestConstructor, RequestGateway requestGateway, ResponseParser responseParser) {
        this.requestConstructor = requestConstructor;
        this.requestGateway = requestGateway;
        this.responseParser = responseParser;
    }

    public String loginToken() throws IOException, ParserConfigurationException, SAXException {
        String requestMessage = requestConstructor.loginRequestMessage(username, password, userAgent);
        String tokenResponse = requestGateway.request(requestMessage);
        return responseParser.parseLoginTokenResponse(tokenResponse);
    }
}
