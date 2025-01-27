package com.solvd.xmlparsers;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidationXML {
    public static boolean validateXMLSchema(String xsdFile, String xmlFile) {
        try{
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = factory.newSchema(new File(xsdFile));

            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(xmlFile)));
            return true;

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
