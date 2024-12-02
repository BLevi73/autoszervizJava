package blevi.autoszerviz.controller.filehandlers;

import java.io.File;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import blevi.autoszerviz.model.datasources.Data;

public class XMLHandler {
    public static void writeToXML(Data data, String filepath) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String dataString = xmlMapper.writeValueAsString(data);
            System.out.println(dataString);
            xmlMapper.writeValue(new File(filepath), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
