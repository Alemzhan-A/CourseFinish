package CitiesPackage;

import AircraftsPackage.Aircrafts;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CitiesTableModel extends AbstractTableModel {
    private ArrayList<Cities>cities = new ArrayList<>();

    public CitiesTableModel(ArrayList<Cities> cities) {
        this.cities = cities ;
    }

    @Override
    public int getRowCount() {
        return cities.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return cities.get(rowIndex).getId();
            case 1:
                return cities.get(rowIndex).getName();
            case 2:
                return cities.get(rowIndex).getCountry();
            case 3:
                return cities.get(rowIndex).getShort_name();
            case 4:
                final JButton button = new JButton("EDIT");
                button.setSize(100, 20);
                button.setFont(new Font("Arial", 1, 14));
                button.setForeground(Color.BLUE);
                return button;
            default:
                return "";
        }

    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAME";
            case 2:
                return "COUNTRY";
            case 3:
                return "SHORTNAME";
            case 4:
                return "EDIT";
            default:
                return "";
        }
    }
}
