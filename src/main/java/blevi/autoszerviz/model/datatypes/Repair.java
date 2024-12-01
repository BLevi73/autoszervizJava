package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repair implements Serializable {
    private String repairId;
    private String description;
    private int cost;
    private Car repairedCar;
    private ArrayList<Part> usedParts;

    public Repair(String repairId, String description, int cost) {
        this.repairId = repairId;
        this.description = description;
        this.cost = cost;
        this.repairedCar = null;
        this.usedParts = new ArrayList<>();
    }

    public String getRepairId() {
        return repairId;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Car getRepairedCar() {
        return repairedCar;
    }

    public List<Part> getUsedParts() {
        return usedParts;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRepairedCar(Car repairedCar) {
        this.repairedCar = repairedCar;
    }

    public void setUsedParts(List<Part> usedParts) {
        this.usedParts = new ArrayList<>(usedParts);
    }
}
