package Admin;


import AircraftsPackage.Aircrafts;
import AircraftsPackage.ListAircrafts;
import CitiesPackage.Cities;
import CitiesPackage.ListCities;
import FlightsPackage.Flights;
import FlightsPackage.ListFlights;
import TicketsPackage.ListTickets;
import TicketsPackage.Tickets;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    private JTable table;
    private MainFrame parent;
    private JPanel panel;

    public MouseListener(JTable table, MainFrame parent, JPanel panel) {
        this.table = table;
        this.parent = parent;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / table.getRowHeight();
        if (row < table.getRowCount() && row >= 0 && col == table.getColumnModel().getColumnIndex("EDIT")) {
            if (panel instanceof ListAircrafts) {

                if (parent.getDbManager().ListAircrafts() != null) {
                    Aircrafts aircrafts = parent.getDbManager().ListAircrafts().get(row);

                    parent.getListAircrafts().setVisible(false);
                    parent.getAircraftEditPage().setAircraft(aircrafts);
                    parent.getAircraftEditPage().setVisible(true);
                }
            }
            if (panel instanceof ListCities) {

                if (parent.getDbManager().ListCities() != null) {
                    Cities city = parent.getDbManager().ListCities().get(row);

                    parent.getListCities().setVisible(false);
                    parent.getCityEditPage().setCities(city);
                    parent.getCityEditPage().setVisible(true);
                }
            }
            if (panel instanceof ListFlights) {

                if (parent.getDbManager().ListFlights() != null) {
                    Flights flights = parent.getDbManager().ListFlights().get(row);

                    parent.getListFlights().setVisible(false);
                    parent.getFlightsEditPage().setFlights(flights);
                    parent.getFlightsEditPage().updateComboValues();
                    parent.getFlightsEditPage().setVisible(true);
                }
            }
            if (panel instanceof ListTickets) {

                if (parent.getDbManager().ListTickets() != null) {
                    Tickets tickets = parent.getDbManager().ListTickets().get(row);
                    parent.getListTickets().setVisible(false);
                    parent.getTicketsEditPage().setTickets(tickets);
                    parent.getTicketsEditPage().updateComboValues();
                    parent.getTicketsEditPage().setVisible(true);
                }
            }
        }
    }
}
