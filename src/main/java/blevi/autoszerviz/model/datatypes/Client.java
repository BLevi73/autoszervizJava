package blevi.autoszerviz.model.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private ArrayList<Vehicle> ownedVehicles;

    public Client(String name, String number, String email) {
        super(name, number, email);
        this.ownedVehicles = new ArrayList<>();
    }

    public List<Vehicle> getOwnedVehicles() {
        return ownedVehicles;
    }
}
