package FlightsPackage;

import CitiesPackage.Cities;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FlightsTableModel extends AbstractTableModel {
    private ArrayList<Flights> flights = new ArrayList<>();

    public FlightsTableModel(ArrayList<Flights> flights) {
        this.flights = flights ;
    }

    @Override
    public int getRowCount() {
        return flights.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return flights.get(rowIndex).getId();
            case 1:
                return flights.get(rowIndex).getAircraft_id();
            case 2:
                return flights.get(rowIndex).getDeprature_city_id();
            case 3:
                return flights.get(rowIndex).getArrival_city_id();
            case 4:
                return flights.get(rowIndex).getDeparture_time();
            case 5:
                return flights.get(rowIndex).getEconom_place_price();
            case 6:
                return flights.get(rowIndex).getBusiness_place_price();
            case 7:
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
                return "Aircraft Id:";
            case 2:
                return "Departure city id:";
            case 3:
                return "Arrival city id:";
            case 4:
                return "Departure Time:";
            case 5:
                return "ec price:";
            case 6:
                return "bc price:";
            case 7:
                return "EDIT";
            default:
                return "";
        }
    }
}
