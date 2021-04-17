package TicketsPackage;

import FlightsPackage.Flights;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TicketsTableModel extends AbstractTableModel {
    private ArrayList<Tickets> tickets = new ArrayList<>();

    public TicketsTableModel(ArrayList<Tickets> tickets) {
        this.tickets = tickets ;
    }

    @Override
    public int getRowCount() {
        return tickets.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tickets.get(rowIndex).getId();
            case 1:
                return tickets.get(rowIndex).getFlight_id();
            case 2:
                return tickets.get(rowIndex).getName();
            case 3:
                return tickets.get(rowIndex).getSurname();
            case 4:
                return tickets.get(rowIndex).getPassport_number();
            case 5:
                return tickets.get(rowIndex).getTicket_type();
            case 6:
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
                return "Flight id:";
            case 2:
                return "Name:";
            case 3:
                return "Surname:";
            case 4:
                return "Passport_number:";
            case 5:
                return "Ticket_type:";
            case 6:
                return "EDIT";
            default:
                return "";
        }
    }
}
