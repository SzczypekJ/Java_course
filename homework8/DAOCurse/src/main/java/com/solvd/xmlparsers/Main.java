package com.solvd.xmlparsers;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/mappers/university.xml";
        String xsdFile = "src/main/resources/mappers/xsdschema.xml";

        if (ValidationXML.validateXMLSchema(xsdFile, xmlFile)) {
            System.out.println("XML Schema Validation Successful");
        } else {
            System.out.println("XML Schema Validation Failed");
        }

        DOMParser domParser = new DOMParser();
        domParser.parseXML(xmlFile);
    }
}
