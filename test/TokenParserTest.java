import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by venkatmk on 13/10/15.
 */
public class TokenParserTest {
    @Test
    public void tokenResponseShouldBeParsedToToken() throws IOException, SAXException, ParserConfigurationException {
        TokenParser tokenParser = new TokenParser();
        String response = "null<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<methodResponse>\n" +
                "<params>\n" +
                " <param>\n" +
                "  <value>\n" +
                "   <struct>\n" +
                "    <member>\n" +
                "     <name>token</name>\n" +
                "     <value>\n" +
                "      <string>ijrjtrcf7qof0u168t0pii0bg6</string>\n" +
                "     </value>\n" +
                "    </member>\n" +
                "    <member>\n" +
                "     <name>status</name>\n" +
                "     <value>\n" +
                "      <string>200 OK</string>\n" +
                "     </value>\n" +
                "    </member>\n" +
                "    <member>\n" +
                "     <name>seconds</name>\n" +
                "     <value>\n" +
                "      <double>0.009</double>\n" +
                "     </value>\n" +
                "    </member>\n" +
                "   </struct>\n" +
                "  </value>\n" +
                " </param>\n" +
                "</params>\n" +
                "</methodResponse>";

        String loginToken = tokenParser.parseLoginTokenResponse(response);

        assertThat(loginToken, is(equalTo("ijrjtrcf7qof0u168t0pii0bg6")));
    }

    @Test
    public void searchResponseShouldBeParsedToDownloadLink() throws ParserConfigurationException, SAXException, IOException {
        TokenParser tokenParser = new TokenParser();
        String response = "null<methodResponse>\n" +
                " <params>\n" +
                "  <param>\n" +
                "   <value>\n" +
                "    <struct>\n" +
                "     <member>\n" +
                "      <name>data</name>\n" +
                "      <value>\n" +
                "       <array>\n" +
                "        <data>\n" +
                "         <value>\n" +
                "          <struct>\n" +
                "           <member>\n" +
                "            <name>IDSubMovieFile</name>\n" +
                "            <value><string>144635</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieHash</name>\n" +
                "            <value><string>7d9cd5def91c9432</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieByteSize</name>\n" +
                "            <value><string>735934464</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieTimeMS</name>\n" +
                "            <value><string>6631000</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>IDSubtitleFile</name>\n" +
                "            <value><string>1951854837</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubFileName</name>\n" +
                "            <value><string>nedivx-27dresses.en.HI.srt</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubActualCD</name>\n" +
                "            <value><string>1</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubSize</name>\n" +
                "            <value><string>149346</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubHash</name>\n" +
                "            <value><string>d7fb67a524f86b83245a927d7b2d0b75</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>IDSubtitle</name>\n" +
                "            <value><string>3272414</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>UserID</name>\n" +
                "            <value><string>451347</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubLanguageID</name>\n" +
                "            <value><string>eng</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubFormat</name>\n" +
                "            <value><string>srt</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubSumCD</name>\n" +
                "            <value><string>1</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubAuthorComment</name>\n" +
                "            <value><string>Extracted from DVD. Hearing Impaired.</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubAddDate</name>\n" +
                "            <value><string>2008-04-15 01:51:02</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubBad</name>\n" +
                "            <value><string>0</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubRating</name>\n" +
                "            <value><string>10.0</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubDownloadsCnt</name>\n" +
                "            <value><string>1013</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieReleaseName</name>\n" +
                "            <value><string>27.Dresses.DVDRip.XviD-NeDiVx (Hearing Impaired)</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>IDMovie</name>\n" +
                "            <value><string>30833</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>IDMovieImdb</name>\n" +
                "            <value><string>988595</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieName</name>\n" +
                "            <value><string>27 Dresses</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieNameEng</name>\n" +
                "            <value><string/></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieYear</name>\n" +
                "            <value><string>2008</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>MovieImdbRating</name>\n" +
                "            <value><string>6.2</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>UserNickName</name>\n" +
                "            <value><string>LeapinLar</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>ISO639</name>\n" +
                "            <value><string>en</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>LanguageName</name>\n" +
                "            <value><string>English</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>SubDownloadLink</name>\n" +
                "            <value><string>http://www.opensubtitles.org/en/download/file/1951854837.gz</string></value>\n" +
                "           </member>\n" +
                "           <member>\n" +
                "            <name>ZipDownloadLink</name>\n" +
                "            <value><string>http://www.opensubtitles.org/en/download/sub/3272414</string></value>\n" +
                "           </member>\n" +
                "          </struct>\n" +
                "         </value>\n" +
                "        </data>\n" +
                "       </array>\n" +
                "      </value>\n" +
                "     </member>\n" +
                "     <member>\n" +
                "      <name>seconds</name>\n" +
                "      <value><double>0.02</double></value>\n" +
                "     </member>\n" +
                "    </struct>\n" +
                "   </value>\n" +
                "  </param>\n" +
                " </params>\n" +
                "</methodResponse>";

        String downloadLink = tokenParser.parseSearchResponse(response);

        assertThat(downloadLink, is(equalTo("http://www.opensubtitles.org/en/download/file/1951854837.gz")));
    }
}
