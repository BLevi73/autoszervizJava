package blevi.autoszerviz.controller.logic;

import java.io.Serializable;

public class ProgramConfig implements Serializable {
    private long autosaveInterval;
    public ProgramConfig() {
        autosaveInterval = 10000;
    }
    public long getAutosaveInterval() {
        return autosaveInterval;
    }
    public void setAutosaveInterval(int autosaveInterval) {
        this.autosaveInterval = autosaveInterval;
    }
}
