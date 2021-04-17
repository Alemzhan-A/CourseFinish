package Cashier;


import TicketsPackage.ListTickets;
import TicketsPackage.Tickets;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierMouseListener extends MouseAdapter {

    private JTable table;
    private CashierMainFrame parent;
    private JPanel panel;

    public CashierMouseListener(JTable table, CashierMainFrame parent, JPanel panel) {
        this.table = table;
        this.parent = parent;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / table.getRowHeight();
        if (row < table.getRowCount() && row >= 0 && col == table.getColumnModel().getColumnIndex("EDIT")) {
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
