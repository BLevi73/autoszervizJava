package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;

public class Part implements Serializable {
    private String serialNumber;
    private String manufacturer;
    private String name;
    private String type;

    public Part() {}

    public Part(String serialNumber, String manufacturer, String name, String type) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.name = name;
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Part)) {
            return false;
        }
        Part casted = (Part)obj;
        return serialNumber.equals(casted.serialNumber);
    }

    @Override
    public String toString() {
        return "Serial number: " + serialNumber + "\n" +
        "Manufacturer: " + manufacturer + "\n" +
        "Name: " + name + "\n" +
        "Type: " + type + "\n";
    }
}
