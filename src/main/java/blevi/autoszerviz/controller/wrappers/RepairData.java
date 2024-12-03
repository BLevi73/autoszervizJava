package blevi.autoszerviz.controller.wrappers;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Repair;

public class RepairData extends AbstractTableModel {
    private List<Repair> repairs;

    public RepairData(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return repairs.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Repair ID";
            case 1:
                return "Description";
            case 2:
                return "Cost";
            default:
                return "Date of repair";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return repairs.get(rowIndex).getRepairId();
            case 1:
                return repairs.get(rowIndex).getDescription();
            case 2:
                return repairs.get(rowIndex).getCost();
            default:
                return repairs.get(rowIndex).getDateOfRepair();
        }
    }
}
