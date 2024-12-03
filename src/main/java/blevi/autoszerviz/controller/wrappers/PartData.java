package blevi.autoszerviz.controller.wrappers;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Part;

public class PartData extends AbstractTableModel {
    private List<Part> parts;

    public PartData(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return parts.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Serial number";
            case 1:
                return "Manufacturer";
            case 2:
                return "Name";
            default:
                return "Type";
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
                return parts.get(rowIndex).getSerialNumber();
            case 1:
                return parts.get(rowIndex).getManufacturer();
            case 2:
                return parts.get(rowIndex).getName();
            default:
                return parts.get(rowIndex).getType();
        }
    }
}
