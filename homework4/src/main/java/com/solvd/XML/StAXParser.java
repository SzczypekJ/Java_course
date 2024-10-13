package com.solvd.XML;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;

public class StAXParser {
    public static void main(String[] args) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream("car.xml"));

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
                String tagName = event.asStartElement().getName().getLocalPart();
                if (tagName.equals("model")) {
                    event = eventReader.nextEvent();
                    System.out.println("Model: " + event.asCharacters().getData());
                } else if (tagName.equals("age")) {
                    event = eventReader.nextEvent();
                    System.out.println("Age: " + event.asCharacters().getData());
                }
            }
        }
    }
}
