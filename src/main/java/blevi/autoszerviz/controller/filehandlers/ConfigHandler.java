package blevi.autoszerviz.controller.filehandlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import blevi.autoszerviz.controller.logic.ProgramConfig;

/**
 * Utility class, handles the serialization of the configuration file.
 */
public class ConfigHandler {
    private ConfigHandler() {
        throw new IllegalStateException();
    }

    /**
     * Writes the configuration in the user's home directory.
     * @param programConfig The configuration to be written
     * @throws IOException
     */
    public static void writeConfig(ProgramConfig programConfig) throws IOException {
        try {
            FileOutputStream fileOutput = new FileOutputStream(System.getProperty("user.dir") + "/carmechanic.config");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(programConfig);
            objectOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the configuration from the user's home directory.
     * @return The new configuration for the program
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ProgramConfig readConfig() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "/carmechanic.config");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Object object = objectInput.readObject();
            if(!object.getClass().equals(ProgramConfig.class)) {
                objectInput.close();
                throw new ClassNotFoundException();
            }
            ProgramConfig programConfig = (ProgramConfig)object;
            objectInput.close();
            return programConfig;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ProgramConfig();
    }
}
