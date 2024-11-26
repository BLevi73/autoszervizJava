package blevi.autoszerviz.controller.filehandlers;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import blevi.autoszerviz.model.datasources.Data;

public class ZipHandler {
    private ZipHandler() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    public static void writeToZip(Data source, String filepath) throws IOException {
        if(!filepath.endsWith(".zip")) {
            filepath = filepath.concat(".zip");
        }
        try {
            FileOutputStream fileOutput = new FileOutputStream(filepath);
            ZipOutputStream zipOutput = new ZipOutputStream(fileOutput);
            ZipEntry entry = new ZipEntry("data.dat");
            zipOutput.putNextEntry(entry);
            byte[] byteArray = convertToByteArray(source);
            zipOutput.write(byteArray,0 , byteArray.length);
            zipOutput.closeEntry();
            zipOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Data loadFromZip(String filepath) throws IOException, ClassNotFoundException {
        if(!filepath.endsWith(".zip")) {
            throw new IOException("The file is not a .zip file");
        }
        try {
            ZipFile zipFile = new ZipFile(filepath);
            ZipEntry entry = zipFile.getEntry("data.dat");
            ObjectInputStream objectInput = new ObjectInputStream(zipFile.getInputStream(entry));
            Object object = objectInput.readObject();
            if (!object.getClass().equals(Data.class)) {
                zipFile.close();
                throw new ClassNotFoundException("The data is not a valid data for the program");
            }
            Data data = (Data)object;
            zipFile.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Data();
    }

    private static byte[] convertToByteArray(Object obj) {
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
            objectOutput.writeObject(obj);
            byteOutput.toByteArray();
            return byteOutput.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteOutput.toByteArray();
    }
}
