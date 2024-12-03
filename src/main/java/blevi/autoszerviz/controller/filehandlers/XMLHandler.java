package blevi.autoszerviz.controller.filehandlers;

import java.io.File;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import blevi.autoszerviz.model.datasources.Data;

/**
 * Utility class, handles the serialization of the data in XML format.
 */
public class XMLHandler {
    private XMLHandler() {
        throw new IllegalStateException();
    }
    /**
     * Writes the data in an XML format file at the given path.
     * @param data The data to be written
     * @param filepath The absolute path of the file to be written
     */
    public static void writeToXML(Data data, String filepath) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            xmlMapper.writeValue(new File(filepath), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Reads the data from an XML format file from the given path.
     * @param filepath The absolute path of the file to be read
     * @return The data read from the file
     */
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
