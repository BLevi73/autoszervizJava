package blevi.autoszerviz.controller.wrappers;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Client;

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

    public void addClientData(Client client) {
        clients.add(client);
        fireTableDataChanged();
    }
}
