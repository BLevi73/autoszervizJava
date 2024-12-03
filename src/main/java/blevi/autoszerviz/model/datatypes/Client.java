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
    
    public void setOwnedVehicles(List<Car> ownedCars) {
        this.ownedCars = new ArrayList<>(ownedCars);
    }

    public void addCar(Car car) {
        ownedCars.add(car);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Client)) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String toPrint = "Identification number: " + getIdNumber() + "\n" +
        "Full name: " + getName() + "\n" +
        "Phone number: " + getPhoneNumber() + "\n" +
        "E-mail: " + getEmail() + "\n" +
        "Owned cars:" + "\n";
        for (Car car : ownedCars) {
            toPrint = toPrint + "-----\n" + car.toString();
        }
        return toPrint;
    }
}
