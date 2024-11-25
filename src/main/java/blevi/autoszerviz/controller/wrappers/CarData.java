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
        return 8;
    }

    @Override
    public int getRowCount() {
        return cars.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 1:
                return "Licence plate";
            case 2:
                return "Model year";
            case 3:
                return "Manufacturer";
            case 4:
                return "Model";
            case 5:
                return "Trim level";
            case 6:
                return "Drivetrain type";
            case 7:
                return "Horsepower";
            default:
                return "Index";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                return cars.get(rowIndex).getLicencePlate();
            case 2:
                return cars.get(rowIndex).getModelYear();
            case 3:
                return cars.get(rowIndex).getManufacturer();
            case 4:
                return cars.get(rowIndex).getModel();
            case 5:
                return cars.get(rowIndex).getTrimLevel();
            case 6:
                return cars.get(rowIndex).getDrivetrainType();
            case 7:
                return cars.get(rowIndex).getHorsepower();
            default:
                return rowIndex + 1;
        }
    }
}
