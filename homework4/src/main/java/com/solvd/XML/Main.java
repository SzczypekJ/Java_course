package com.solvd.XML;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        File xmlFile = new File("car.xml");
        File xsdFile = new File("carSchema.xsd");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new StreamSource(xsdFile));
        Validator validator = schema.newValidator();

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        try {
            validator.validate(new StreamSource(xmlFile));
            System.out.println("XML is valid against the schema.");
        } catch (SAXException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
