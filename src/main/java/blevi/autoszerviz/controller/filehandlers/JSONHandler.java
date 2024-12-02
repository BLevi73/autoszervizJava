package blevi.autoszerviz.controller.filehandlers;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import blevi.autoszerviz.model.datasources.Data;

public class JSONHandler {
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
}
