package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;

public class Car implements Serializable {
    private String licencePlate;
    private Integer modelYear;
    private String manufacturer;
    private String model;
    private String chassisType;
    private String drivetrainType;
    private Integer horsepower;

    public Car() {}

    public Car(String licencePlate, Integer modelYear, String manufacturer, String model, String chassisType, String drivetrainType, Integer horsepower) {
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

    public Integer getModelYear() {
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

    public Integer getHorsepower() {
        return horsepower;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car casted = (Car)obj;
        return licencePlate.equals(casted.licencePlate);
    }
}
