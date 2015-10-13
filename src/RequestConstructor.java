/**
 * Created by venkatmk on 13/10/15.
 */
public class RequestConstructor {

    public String loginRequestMessage(String username, String password, String userAgent) {
        return "<methodCall>\n" +
                " <methodName>LogIn</methodName>\n" +
                " <params>\n" +
                "  <param>\n" +
                "   <value><string>" + username + "</string></value>\n" +
                "  </param>\n" +
                "  <param>\n" +
                "   <value><string>" + password + "</string></value>\n" +
                "  </param>\n" +
                "  <param>\n" +
                "   <value><string>en</string></value>\n" +
                "  </param>\n" +
                "  <param>\n" +
                "   <value><string>" + userAgent + "</string></value>\n" +
                "  </param>\n" +
                " </params>\n" +
                "</methodCall>";
    }
}
