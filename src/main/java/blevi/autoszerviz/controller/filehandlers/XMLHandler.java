package blevi.autoszerviz.controller.filehandlers;

import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.model.datatypes.*;

public class XMLHandler extends DefaultHandler {
    private StringBuilder stringValue;
    private Data data;
    private Employee employee;
    private Client client;
    private Car car;
    private Repair repair;
    private Part part;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (stringValue == null) {
            stringValue = new StringBuilder();
        } else {
            stringValue.append(ch, start, length);
        }
    }
    @Override
    public void startDocument() throws SAXException {
        data = new Data();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "employee":
                
                break;
        
            default:
                break;
        }
    }
    public void writeXML(Data data) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
