package blevi.autoszerviz.controller.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Client;
import blevi.autoszerviz.view.dialogs.ClientQueryDialog;

public class ClientData extends AbstractTableModel {
    private List<Client> clients;

    public ClientData(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Identification number";
            case 1:
                return "Name";
            case 2:
                return "Phone number";
            default:
                return "E-mail address";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return clients.get(rowIndex).getIdNumber();
            case 1:
                return clients.get(rowIndex).getName();
            case 2:
                return clients.get(rowIndex).getPhoneNumber();
            default:
                return clients.get(rowIndex).getEmail();
        }
    }

    public boolean addClient(Client client) {
        for (Client element : clients) {
            if(element.equals(client)) {
                return false;
            }
        }
        clients.add(client);
        fireTableDataChanged();
        return true;
    }

    public List<Client> getFilteredData(Client filter) {
        List<Client> filteredData = new ArrayList<>();
        boolean idNumberFilterFlag;
        boolean nameFilterFlag;
        boolean phoneNumberFilterFlag;
        boolean emailFilterFlag;
        for (Client clientElement : clients) {
            idNumberFilterFlag = evaluateIdNumberFilter(clientElement, filter);
            nameFilterFlag = evaluateNameFilter(clientElement, filter);
            phoneNumberFilterFlag = evaluatePhoneNumberFilter(clientElement, filter);
            emailFilterFlag = evaluateEmailFilter(clientElement, filter);
            if (idNumberFilterFlag && nameFilterFlag && phoneNumberFilterFlag && emailFilterFlag) {
                filteredData.add(clientElement);
            }
        }
        return filteredData;
    }

    private boolean evaluateIdNumberFilter(Client element, Client filter) {
        if (filter.getIdNumber().isBlank()) {
            return true;
        } else {
            switch (ClientQueryDialog.getIdNumberOrdering()) {
                case 1:
                    return element.getIdNumber().compareTo(filter.getIdNumber()) < 0;
                case 2:
                    return element.getIdNumber().compareTo(filter.getIdNumber()) > 0;
                default:
                    return element.getIdNumber().compareTo(filter.getIdNumber()) == 0;
            }
        }
    }
    private boolean evaluateNameFilter(Client element, Client filter) {
        if (filter.getName().isBlank()) {
            return true;
        } else {
            switch (ClientQueryDialog.getNameOrdering()) {
                case 1:
                    return element.getName().compareTo(filter.getName()) < 0;
                case 2:
                    return element.getName().compareTo(filter.getName()) > 0;
                default:
                    return element.getName().compareTo(filter.getName()) == 0;
            }
        }
    }
    private boolean evaluatePhoneNumberFilter(Client element, Client filter) {
        if (filter.getPhoneNumber().isBlank()) {
            return true;
        } else {
            switch (ClientQueryDialog.getPhoneNumberOrdering()) {
                case 1:
                    return element.getPhoneNumber().compareTo(filter.getPhoneNumber()) < 0;
                case 2:
                    return element.getPhoneNumber().compareTo(filter.getPhoneNumber()) > 0;
                default:
                    return element.getPhoneNumber().compareTo(filter.getPhoneNumber()) == 0;
            }
        }
    }
    private boolean evaluateEmailFilter(Client element, Client filter) {
        if (filter.getEmail().isBlank()) {
            return true;
        } else {
            switch (ClientQueryDialog.getEmailOrdering()) {
                case 1:
                    return element.getEmail().compareTo(filter.getEmail()) < 0;
                case 2:
                    return element.getEmail().compareTo(filter.getEmail()) > 0;
                default:
                    return element.getEmail().compareTo(filter.getEmail()) == 0;
            }
        }
    }
}
