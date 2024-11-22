package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repair implements Serializable {
    private String description;
    private int cost;
    private ArrayList<Part> usedParts;

    public Repair(String description, int cost) {
        this.description = description;
        this.cost = cost;
        this.usedParts = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
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

    public void setUsedParts(List<Part> usedParts) {
        this.usedParts = new ArrayList<>(usedParts);
    }
}
