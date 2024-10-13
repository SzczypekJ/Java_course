package com.solvd.XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserExample {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
            boolean isModel = false;
            boolean isAge = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("model")) {
                    isModel = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    isAge = true;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isModel) {
                    System.out.println("Model: " + new String(ch, start, length));
                    isModel = false;
                }
                if (isAge) {
                    System.out.println("Age: " + new String(ch, start, length));
                    isAge = false;
                }
            }
        };
        saxParser.parse("car.xml", handler);
    }
}
