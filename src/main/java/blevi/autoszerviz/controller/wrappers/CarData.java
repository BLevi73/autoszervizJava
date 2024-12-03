package blevi.autoszerviz.controller.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Car;
import blevi.autoszerviz.view.dialogs.CarDialog;
import blevi.autoszerviz.view.dialogs.ClientDialog;

public class CarData extends AbstractTableModel {
    private List<Car> cars;

    public CarData(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return cars.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Licence plate";
            case 1:
                return "Model year";
            case 2:
                return "Manufacturer";
            case 3:
                return "Model";
            case 4:
                return "Chassis type";
            default:
                return "Horsepower";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 1:
                return Integer.class;
            case 5:
                return Integer.class;
            default:
                return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return cars.get(rowIndex).getLicencePlate();
            case 1:
                return cars.get(rowIndex).getModelYear();
            case 2:
                return cars.get(rowIndex).getManufacturer();
            case 3:
                return cars.get(rowIndex).getModel();
            case 4:
                return cars.get(rowIndex).getChassisType();
            default:
                return cars.get(rowIndex).getHorsepower();
        }
    }

    public CarData getFilteredData(Car filter) {
        List<Car> filteredData = new ArrayList<>();
        boolean licencePlateFlag;
        boolean modelYearFlag;
        boolean manufacturerFlag;
        boolean modelFlag;
        boolean chassisTypeFlag;
        boolean horsepowerFlag;
        for (Car carElement : cars) {
            licencePlateFlag = evaluateLicencePlateFilter(carElement, filter);
            modelYearFlag = evaluateModelYearFilter(carElement, filter);
            manufacturerFlag = evaluateManufacturerFilter(carElement, filter);
            modelFlag = evaluateModelFilter(carElement, filter);
            chassisTypeFlag = evaluateChassisTypeFilter(carElement, filter);
            horsepowerFlag = evaluateHorsepowerFilter(carElement, filter);
            if (licencePlateFlag && modelYearFlag && manufacturerFlag && modelFlag && chassisTypeFlag
                    && horsepowerFlag) {
                filteredData.add(carElement);
            }
        }
        return new CarData(filteredData);
    }

    private boolean evaluateLicencePlateFilter(Car element, Car filter) {
        if (filter.getLicencePlate().isBlank()) {
            return true;
        } else {
            switch (CarDialog.getLicencePlateOrdering()) {
                case 1:
                    return element.getLicencePlate().compareTo(filter.getLicencePlate()) < 0;
                case 2:
                    return element.getLicencePlate().compareTo(filter.getLicencePlate()) > 0;
                default:
                    return element.getLicencePlate().compareTo(filter.getLicencePlate()) == 0;
            }
        }
    }

    private boolean evaluateModelYearFilter(Car element, Car filter) {
        if (filter.getModelYear() == null) {
            return true;
        } else {
            switch (CarDialog.getModelYearOrdering()) {
                case 1:
                    return element.getModelYear().compareTo(filter.getModelYear()) < 0;
                case 2:
                    return element.getModelYear().compareTo(filter.getModelYear()) > 0;
                default:
                    return element.getModelYear().compareTo(filter.getModelYear()) == 0;
            }
        }
    }

    private boolean evaluateManufacturerFilter(Car element, Car filter) {
        if (filter.getManufacturer().isBlank()) {
            return true;
        } else {
            switch (CarDialog.getManufacturerOrdering()) {
                case 1:
                    return element.getManufacturer().compareTo(filter.getManufacturer()) < 0;
                case 2:
                    return element.getManufacturer().compareTo(filter.getManufacturer()) > 0;
                default:
                    return element.getManufacturer().compareTo(filter.getManufacturer()) == 0;
            }
        }
    }

    private boolean evaluateModelFilter(Car element, Car filter) {
        if (filter.getModel().isBlank()) {
            return true;
        } else {
            switch (CarDialog.getModelOrdering()) {
                case 1:
                    return element.getModel().compareTo(filter.getModel()) < 0;
                case 2:
                    return element.getModel().compareTo(filter.getModel()) > 0;
                default:
                    return element.getModel().compareTo(filter.getModel()) == 0;
            }
        }
    }

    private boolean evaluateChassisTypeFilter(Car element, Car filter) {
        if (filter.getChassisType().isBlank()) {
            return true;
        } else {
            switch (CarDialog.getChassisTypeOrdering()) {
                case 1:
                    return element.getChassisType().compareTo(filter.getChassisType()) < 0;
                case 2:
                    return element.getChassisType().compareTo(filter.getChassisType()) > 0;
                default:
                    return element.getChassisType().compareTo(filter.getChassisType()) == 0;
            }
        }
    }

    private boolean evaluateHorsepowerFilter(Car element, Car filter) {
        if (filter.getHorsepower() == null) {
            return true;
        } else {
            switch (CarDialog.getHorsepowerOrdering()) {
                case 1:
                    return element.getHorsepower().compareTo(filter.getHorsepower()) < 0;
                case 2:
                    return element.getHorsepower().compareTo(filter.getHorsepower()) > 0;
                default:
                    return element.getHorsepower().compareTo(filter.getHorsepower()) == 0;
            }
        }
    }
}
