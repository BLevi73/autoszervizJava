package blevi.autoszerviz.model.datatypes;

public class Employee extends Person {
    
    private String position;

    public Employee(String idNumber, String name, String number, String email, String position) {
        super(idNumber, name, number, email);
        this.position = position;
    }

    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
