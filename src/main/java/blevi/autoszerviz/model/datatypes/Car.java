package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;
import java.time.Year;

public class Car implements Serializable {
    private String licencePlate;
    private int modelYear;
    private String manufacturer;
    private String model;
    private String trimLevel;
    private String drivetrainType;
    private int horsepower;

    public Car(String licencePlate, int modelYear, String manufacturer, String model, String trimlevel, String drivetrainType, int horsepower) {
        this.licencePlate = licencePlate;
        this.modelYear = modelYear;
        this.manufacturer = manufacturer;
        this.model = model;
        this.trimLevel = trimlevel;
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

    public String getTrimLevel() {
        return trimLevel;
    }

    public String getDrivetrainType() {
        return drivetrainType;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
