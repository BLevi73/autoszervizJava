package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;

public class Person implements Serializable {
    private String idNumber;
    private String name;
    private String phoneNumber;
    private String email;

    public Person(String idNumber, String name, String phoneNumber, String email) {
        this.idNumber = idNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
