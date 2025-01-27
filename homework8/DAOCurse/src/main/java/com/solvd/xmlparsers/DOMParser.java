package com.solvd.xmlparsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {

    public void parseXML(String xmlFilePath) {
        try{

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(false);
            dbf.setNamespaceAware(true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFilePath);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " +doc.getDocumentElement().getNodeName());

            NodeList students = doc.getElementsByTagName("Student");

            for (int i = 0; i < students.getLength(); i++) {
                Node studentNode = students.item(i);

                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;

                    String id = studentElement.getElementsByTagName("ID").item(0).getTextContent();
                    String name = studentElement.getElementsByTagName("Name").item(0).getTextContent();
                    String age = studentElement.getElementsByTagName("Age").item(0).getTextContent();

                    System.out.println("\nStudent ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);

                    NodeList courses = studentElement.getElementsByTagName("Course");

                    for (int j = 0; j < courses.getLength(); j++) {
                        Element courseElement = (Element) courses.item(j);
                        String courseName = courseElement.getElementsByTagName("Name").item(0).getTextContent();
                        String courseCode = courseElement.getElementsByTagName("Code").item(0).getTextContent();
                        String numberOfPeople = courseElement.getElementsByTagName("Numberofpeople").item(0).getTextContent();

                        System.out.println("\tCourse Name: " + courseName);
                        System.out.println("\tCourse Code: " + courseCode);
                        System.out.println("\tNumber of People: " + numberOfPeople);
                    }

                    Element carElement = (Element) studentElement.getElementsByTagName("Car").item(0);
                    String carProducent = carElement.getElementsByTagName("Producent").item(0).getTextContent();
                    String carModel = carElement.getElementsByTagName("Model").item(0).getTextContent();
                    String carYear = carElement.getElementsByTagName("Year").item(0).getTextContent();

                    System.out.println("Car Producent: " + carProducent);
                    System.out.println("Car Model: " + carModel);
                    System.out.println("Car Year: " + carYear);
                }

            }

        }catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error during parsing " + e.getMessage());
        }
    }
}
