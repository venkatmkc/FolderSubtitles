import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

public class LoginTokenParser {
    public String parseLoginTokenResponse(String response) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(response));
        Document document = documentBuilder.parse(inputSource);
        NodeList nodes =  document.getElementsByTagName("string");
        Node loginTokenNode = nodes.item(0);
        CharacterData tokenCharacterData = (CharacterData) loginTokenNode.getFirstChild();
        return tokenCharacterData.getData();
    }
}
