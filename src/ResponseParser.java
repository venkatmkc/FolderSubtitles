import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

public class ResponseParser {
    public String parseLoginTokenResponse(String response) throws ParserConfigurationException, IOException, SAXException {
        Document document = parseResponseToDocument(response);
        NodeList nodes =  document.getElementsByTagName("string");
        Node loginTokenNode = nodes.item(0);
        return getTargetNodeData(loginTokenNode);
    }

    private String getTargetNodeData(Node loginTokenNode) {
        CharacterData tokenCharacterData = (CharacterData) loginTokenNode.getFirstChild();
        return tokenCharacterData.getData();
    }

    private Document parseResponseToDocument(String response) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource inputSource = new InputSource();
        response = removeNull(response);
        inputSource.setCharacterStream(new StringReader(response));
        return documentBuilder.parse(inputSource);
    }

    private String removeNull(String response) {
        response = response.substring(4);
        return response;
    }

    public String parseSearchResponse(String response) throws IOException, SAXException, ParserConfigurationException {
        Document document = parseResponseToDocument(response);
        NodeList nodes = document.getElementsByTagName("string");
        Node downloadLinkNode = nodes.item(lastNodeIndex(nodes) - 1);
        return getTargetNodeData(downloadLinkNode);
    }

    private int lastNodeIndex(NodeList nodes) {
        return nodes.getLength() - 1;
    }
}
