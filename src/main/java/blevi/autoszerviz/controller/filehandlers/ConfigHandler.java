package blevi.autoszerviz.controller.filehandlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import blevi.autoszerviz.controller.logic.ProgramConfig;

public class ConfigHandler {
    private ConfigHandler() {
        throw new IllegalStateException();
    }
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
