package blevi.autoszerviz.controller.filehandlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import blevi.autoszerviz.model.datasources.Data;

/**
 * Utility class, handles the serialization of the data in JSON format.
 */
public class JSONHandler {
    private JSONHandler() {
        throw new IllegalStateException();
    }
    /**
     * Writes the data in a JSON format file at the given path.
     * @param data The data to be written
     * @param filepath The absolute path of the file to be written
     */
    public static void writeToJSON(Data data, String filepath) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String dataString = gson.toJson(data);
        System.out.println(dataString);
        try {
            PrintWriter writer = new PrintWriter(filepath);
            writer.print(dataString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
    /**
     * Reads the data from a JSON format file from the given path.
     * @param filepath The absolute path of the file to be read
     * @return The data read from the file
     */
    public static Data readFromJSON(String filepath) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String dataString;
        try {
            FileReader reader = new FileReader(filepath);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder strBuilder = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                strBuilder.append(line);
            }
            dataString = strBuilder.toString();
            buffer.close();
            return gson.fromJson(dataString, Data.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data();
    }
}
