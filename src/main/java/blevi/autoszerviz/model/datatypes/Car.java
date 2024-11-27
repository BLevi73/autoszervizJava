package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;

public class Car implements Serializable {
    private String licencePlate;
    private int modelYear;
    private String manufacturer;
    private String model;
    private String chassisType;
    private String drivetrainType;
    private int horsepower;

    public Car(String licencePlate, int modelYear, String manufacturer, String model, String chassisType, String drivetrainType, int horsepower) {
        this.licencePlate = licencePlate;
        this.modelYear = modelYear;
        this.manufacturer = manufacturer;
        this.model = model;
        this.chassisType = chassisType;
        this.drivetrainType = drivetrainType;
        this.horsepower = horsepower;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getChassisType() {
        return chassisType;
    }

    public String getDrivetrainType() {
        return drivetrainType;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
