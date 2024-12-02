package blevi.autoszerviz.controller.filehandlers;

import java.io.File;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import blevi.autoszerviz.model.datasources.Data;

public class XMLHandler {
    private XMLHandler() {
        throw new IllegalStateException();
    }
    public static void writeToXML(Data data, String filepath) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            xmlMapper.writeValue(new File(filepath), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Data readFromXML(String filepath) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(new File(filepath), Data.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data();
    }
}
