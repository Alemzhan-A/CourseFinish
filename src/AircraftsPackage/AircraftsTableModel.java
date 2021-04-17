package AircraftsPackage;

import AircraftsPackage.Aircrafts;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AircraftsTableModel extends AbstractTableModel {
    private ArrayList<Aircrafts>aircrafts;

    public AircraftsTableModel(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
    }

    @Override
    public int getRowCount() {
        return aircrafts.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return aircrafts.get(rowIndex).getId();
            case 1:
                return aircrafts.get(rowIndex).getName();
            case 2:
                return aircrafts.get(rowIndex).getModel();
            case 3:
                return aircrafts.get(rowIndex).getEconom_class_capcity();
            case 4:
                return aircrafts.get(rowIndex).getBusiness_class_capacity();
            case 5:
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
                return "MODEL";
            case 3:
                return "EC CAPACITY";
            case 4:
                return "BC CAPACITY";
            case 5:
                return "EDIT";
            default:
                return "";
        }
    }
}
