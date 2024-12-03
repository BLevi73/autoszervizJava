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

/**
 * Utility class, handles the serialization of the data in Zip format.
 */
public class ZipHandler {
    private ZipHandler() {
        throw new IllegalStateException();
    }

    /**
     * Writes the data in a Zip format file at the given path.
     * @param data The data to be written
     * @param filepath The absolute path of the file to be written
     * @throws IOException
     */
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
    /**
     * Reads the data from a Zip format file from the given path.
     * @param filepath The absolute path of the file to be read
     * @return The data read from the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Data readFromZip(String filepath) throws IOException, ClassNotFoundException {
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

    /**
     * Converts an object to a byte array.
     * @param obj The object to be converted
     * @return the object as byte array
     */
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
