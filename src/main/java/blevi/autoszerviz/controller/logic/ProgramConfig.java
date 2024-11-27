package blevi.autoszerviz.controller.logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ProgramConfig implements Serializable {
    private long autosaveInterval;
    public ProgramConfig() {
        autosaveInterval = 60000;
    }
    public long getAutosaveInterval() {
        return autosaveInterval;
    }
    public void setAutosaveInterval(int autosaveInterval) {
        this.autosaveInterval = autosaveInterval;
    }
    public void write() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(System.getProperty("user.home") + "/carmechanic.config");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(this);
            objectOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ProgramConfig load() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileInput = new FileInputStream(System.getProperty("user.home") + "/carmechanic.config");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Object object = objectInput.readObject();
            if (!object.getClass().equals(ProgramConfig.class)) {
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
