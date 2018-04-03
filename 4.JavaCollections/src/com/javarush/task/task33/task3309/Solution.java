package com.javarush.task.task33.task3309;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        marshaller.marshal(obj, doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "yes");
        DOMSource source = new DOMSource(doc);
        writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeName().equals(tagName)) {
                Comment commentNode = doc.createComment(comment);
                node.getParentNode().insertBefore(commentNode, node);
            }
            if (node.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                Node textNode = node.getFirstChild();
                if (textNode.getTextContent().matches(".*[&<>\'\"].*"))
                    node.replaceChild(doc.createCDATASection(textNode.getTextContent()), textNode);
            }
        }
        transformer.transform(source, result);
        return writer.toString();
    }


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException, TransformerException {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }
}
