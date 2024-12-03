package blevi.autoszerviz.controller.logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ProgramConfig class, contains the autosave interval expressed in milliseconds.
 */
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
    /**
     * Writes the object into a config file, located in the user home directory.
     */
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

    /**
     * Loads the object from a config file, located in the user home directory.
     * @return the ProgramConfig object
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
