package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repair implements Serializable {
    private String repairId;
    private String description;
    private Integer cost;
    private String dateOfRepair;
    private Car repairedCar;
    private ArrayList<Part> usedParts;

    public Repair() {}

    public Repair(String repairId, String description, Integer cost, String dateOfRepair) {
        this.repairId = repairId;
        this.description = description;
        this.cost = cost;
        this.dateOfRepair = dateOfRepair;
        this.repairedCar = null;
        this.usedParts = new ArrayList<>();
    }

    public String getRepairId() {
        return repairId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCost() {
        return cost;
    }
    
    public String getDateOfRepair() {
        return dateOfRepair;
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

    public void setDateOfRepair(String dateOfRepair) {
        this.dateOfRepair = dateOfRepair;
    }

    public void setRepairedCar(Car repairedCar) {
        this.repairedCar = repairedCar;
    }

    public void setUsedParts(List<Part> usedParts) {
        this.usedParts = new ArrayList<>(usedParts);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Repair)) {
            return false;
        }
        Repair casted = (Repair)obj;
        return repairId.equals(casted.repairId);
    }
}
