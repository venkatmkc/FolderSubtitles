
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

        public String searchRequestMessage(String loginToken, String fileHash, long fileSize) {
                return "<methodCall>\n" +
                        " <methodName>SearchSubtitles</methodName>\n" +
                        " <params>\n" +
                        "  <param>\n" +
                        "   <value><string>" + loginToken + "</string></value>\n" +
                        "  </param>\n" +
                        "  <param>\n" +
                        "   <value>\n" +
                        "    <array>\n" +
                        "     <data>\n" +
                        "      <value>\n" +
                        "       <struct>\n" +
                        "        <member>\n" +
                        "         <name>sublanguageid</name>\n" +
                        "         <value><string>eng</string>\n" +
                        "         </value>\n" +
                        "        </member>\n" +
                        "        <member>\n" +
                        "         <name>moviehash</name>\n" +
                        "         <value><string>" + fileHash + "</string></value>\n" +
                        "        </member>\n" +
                        "        <member>\n" +
                        "         <name>moviebytesize</name>\n" +
                        "         <value><double>" + fileSize + "</double></value>\n" +
                        "        </member>\n" +
                        "       </struct>\n" +
                        "      </value>\n" +
                        "     </data>\n" +
                        "    </array>\n" +
                        "   </value>\n" +
                        "  </param>\n" +
                        " </params>\n" +
                        "</methodCall>";
        }
}
