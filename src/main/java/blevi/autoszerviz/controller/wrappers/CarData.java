package blevi.autoszerviz.controller.wrappers;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Car;

public class CarData extends AbstractTableModel {
    private List<Car> cars;

    public CarData(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public int getColumnCount() {
        return 7;
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
                return "Trim level";
            case 5:
                return "Drivetrain type";
            default:
                return "Horsepower";
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
                return cars.get(rowIndex).getTrimLevel();
            case 5:
                return cars.get(rowIndex).getDrivetrainType();
            default:
                return cars.get(rowIndex).getHorsepower();
        }
    }
}
