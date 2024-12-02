package blevi.autoszerviz.controller.filehandlers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import blevi.autoszerviz.model.datasources.Data;

public class XMLHandler {
    public static void writeToXML(Data data, String filepath) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.
        try {
            String dataString = xmlMapper.writeValueAsString(data);
            System.out.println(dataString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
