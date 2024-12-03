package blevi.autoszerviz.controller.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Repair;
import blevi.autoszerviz.view.dialogs.RepairDialog;

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

    public RepairData getFilteredData(Repair filter) {
        List<Repair> filteredData = new ArrayList<>();
        boolean repairIdFlag;
        boolean descriptionFlag;
        boolean costFlag;
        boolean dateFlag;
        for (Repair repairElement : repairs) {
            repairIdFlag = evaluateRepairIdFlag(repairElement, filter);
            descriptionFlag = evaluateDescriptionFlag(repairElement, filter);
            costFlag = evaluateCostFlag(repairElement, filter);
            dateFlag = evaluateDateFlag(repairElement, filter);
            if(repairIdFlag && descriptionFlag && costFlag && dateFlag) {
                filteredData.add(repairElement);
            }
        }
        return new RepairData(filteredData);
    }

    private boolean evaluateRepairIdFlag(Repair element, Repair filter) {
        if(filter.getRepairId().isBlank()) {
            return true;
        } else {
            switch (RepairDialog.getRepairIdOrdering()) {
                case 1:
                    return element.getRepairId().compareTo(filter.getRepairId()) < 0;
                case 2:
                    return element.getRepairId().compareTo(filter.getRepairId()) > 0;
                default:
                    return element.getRepairId().compareTo(filter.getRepairId()) == 0;
            }
        }
    }
    private boolean evaluateDescriptionFlag(Repair element, Repair filter) {
        if(filter.getDescription().isBlank()) {
            return true;
        } else {
            switch (RepairDialog.getDescriptionOrdering()) {
                case 1:
                    return element.getDescription().compareTo(filter.getDescription()) < 0;
                case 2:
                    return element.getDescription().compareTo(filter.getDescription()) > 0;
                default:
                    return element.getDescription().compareTo(filter.getDescription()) == 0;
            }
        }
    }
    private boolean evaluateCostFlag(Repair element, Repair filter) {
        if(filter.getCost() == null) {
            return true;
        } else {
            switch (RepairDialog.getCostOrdering()) {
                case 1:
                    return element.getCost().compareTo(filter.getCost()) < 0;
                case 2:
                    return element.getCost().compareTo(filter.getCost()) > 0;
                default:
                    return element.getCost().compareTo(filter.getCost()) == 0;
            }
        }
    }
    private boolean evaluateDateFlag(Repair element, Repair filter) {
        if(filter.getDateOfRepair().isBlank()) {
            return true;
        } else {
            switch (RepairDialog.getDateOrdering()) {
                case 1:
                    return element.getDateOfRepair().compareTo(filter.getDateOfRepair()) < 0;
                case 2:
                    return element.getDateOfRepair().compareTo(filter.getDateOfRepair()) > 0;
                default:
                    return element.getDateOfRepair().compareTo(filter.getDateOfRepair()) == 0;
            }
        }
    }
}
