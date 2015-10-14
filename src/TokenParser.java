import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

public class TokenParser {
    public String parseLoginTokenResponse(String response) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource inputSource = new InputSource();
        response = removeNull(response);
        inputSource.setCharacterStream(new StringReader(response));
        Document document = documentBuilder.parse(inputSource);
        NodeList nodes =  document.getElementsByTagName("string");
        Node loginTokenNode = nodes.item(0);
        CharacterData tokenCharacterData = (CharacterData) loginTokenNode.getFirstChild();
        return tokenCharacterData.getData();
    }

    private String removeNull(String response) {
        response = response.substring(4);
        return response;
    }
}
