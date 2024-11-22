package blevi.autoszerviz.model.wrappers;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.controller.DataAccessInterface;
import blevi.autoszerviz.model.datatypes.Client;

public class ClientData extends AbstractTableModel {
    private List<Client> clients;
    public ClientData() {
        clients = DataAccessInterface.getDatabase().getClients();
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
        switch(column) {
            case 1 :
                return "Name";
            case 2 :
                return "Phone number";
            case 3 :
                return "E-mail address";
            default :
                return "Index";
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 1 :
                return clients.get(rowIndex).getName();
            case 2 :
                return clients.get(rowIndex).getNumber();
            case 3 :
                return clients.get(rowIndex).getEmail();
            default :
                return rowIndex + 1;
        }
    }

    public void addClientData(String name) {
        clients.add(new Client("1",name,"06201234567","test@example.com"));
        fireTableDataChanged();
    }
}
