package blevi.autoszerviz.model.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private ArrayList<Car> ownedCars;

    public Client() {
        super();
    }

    public Client(String idNumber, String name, String number, String email) {
        super(idNumber, name, number, email);
        this.ownedCars = new ArrayList<>();
    }

    public List<Car> getOwnedVehicles() {
        return ownedCars;
    }
}
