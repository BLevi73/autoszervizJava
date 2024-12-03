package blevi.autoszerviz.model.datatypes;

import java.io.Serializable;

public class Car implements Serializable {
    private String licencePlate;
    private Integer modelYear;
    private String manufacturer;
    private String model;
    private String chassisType;
    private Integer horsepower;

    public Car() {
    }

    public Car(String licencePlate, Integer modelYear, String manufacturer, String model, String chassisType, Integer horsepower) {
        this.licencePlate = licencePlate;
        this.modelYear = modelYear;
        this.manufacturer = manufacturer;
        this.model = model;
        this.chassisType = chassisType;
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

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setChassisType(String chassisType) {
        this.chassisType = chassisType;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car casted = (Car) obj;
        return licencePlate.equals(casted.licencePlate);
    }
}
