package blevi.autoszerviz.controller.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Part;
import blevi.autoszerviz.view.dialogs.PartDialog;

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

    public PartData getFilteredData(Part filter) {
        List<Part> filteredData = new ArrayList<>();
        boolean serialNumberFlag;
        boolean manufacturerFlag;
        boolean nameFlag;
        boolean typeFlag;
        for (Part partElement : parts) {
            serialNumberFlag = evaluateSerialNumberFlag(partElement, filter);
            manufacturerFlag = evaluateManufacturerFlag(partElement, filter);
            nameFlag = evaluateNameFlag(partElement, filter);
            typeFlag = evaluateTypeFlag(partElement, filter);
            if(serialNumberFlag && manufacturerFlag && nameFlag && typeFlag) {
                filteredData.add(partElement);
            }
        }
        return new PartData(filteredData);
    }

    private boolean evaluateSerialNumberFlag(Part element, Part filter) {
        if(filter.getSerialNumber().isBlank()) {
            return true;
        } else {
            switch (PartDialog.getSerialNumberOrdering()) {
                case 1:
                    return element.getSerialNumber().compareTo(filter.getSerialNumber()) < 0;
                case 2:
                    return element.getSerialNumber().compareTo(filter.getSerialNumber()) > 0;
                default:
                    return element.getSerialNumber().compareTo(filter.getSerialNumber()) == 0;
            }
        }
    }
    private boolean evaluateManufacturerFlag(Part element, Part filter) {
        if(filter.getManufacturer().isBlank()) {
            return true;
        } else {
            switch (PartDialog.getManufactuerOrdering()) {
                case 1:
                    return element.getManufacturer().compareTo(filter.getManufacturer()) < 0;
                case 2:
                    return element.getManufacturer().compareTo(filter.getManufacturer()) > 0;
                default:
                    return element.getManufacturer().compareTo(filter.getManufacturer()) == 0;
            }
        }
    }
    private boolean evaluateNameFlag(Part element, Part filter) {
        if(filter.getName().isBlank()) {
            return true;
        } else {
            switch (PartDialog.getNameOrdering()) {
                case 1:
                    return element.getName().compareTo(filter.getName()) < 0;
                case 2:
                    return element.getName().compareTo(filter.getName()) > 0;
                default:
                    return element.getName().compareTo(filter.getName()) == 0;
            }
        }
    }
    private boolean evaluateTypeFlag(Part element, Part filter) {
        if(filter.getType().isBlank()) {
            return true;
        } else {
            switch (PartDialog.getTypeOrdering()) {
                case 1:
                    return element.getType().compareTo(filter.getType()) < 0;
                case 2:
                    return element.getType().compareTo(filter.getType()) > 0;
                default:
                    return element.getType().compareTo(filter.getType()) == 0;
            }
        }
    }
}
