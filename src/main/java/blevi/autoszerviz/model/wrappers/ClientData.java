package blevi.autoszerviz.model.wrappers;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Client;

public class ClientData extends AbstractTableModel {
    ArrayList<Client> clients;
    public ClientData() {
        clients = new ArrayList<>();
        clients.add(new Client("Feri", "06704564564", "ferenc.a@gmail.com"));
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
}
