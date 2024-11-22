package blevi.autoszerviz.controller.filehandlers;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.ZipOutputStream;

import blevi.autoszerviz.model.datasources.ZipData;

public class ZipHandler {
    private ZipHandler() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    public static void writeToZip(ZipData data, String filepath) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(filepath);
            ZipOutputStream zipOutput = new ZipOutputStream(fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] convertToByteArray(Object obj) {
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
            objectOutput.writeObject(obj);
            return byteOutput.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
