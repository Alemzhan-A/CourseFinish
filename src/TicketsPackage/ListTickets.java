package TicketsPackage;

import Admin.*;
import Cashier.CashierMainFrame;
import Cashier.CashierMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListTickets extends JPanel {
    private CashierMainFrame parent;
    private JButton backbutton;
    private JScrollPane scrollPane;
    private JTable table;
    private ButtonRenderer renderer = new ButtonRenderer();

    public ListTickets(CashierMainFrame parent) {
        this.parent = parent;
        setSize(600, 600);
        setLayout(null);

        backbutton = new JButton("BACK");
        backbutton.setBounds(170, 400, 250, 50);
        backbutton.addActionListener(e -> {
            parent.getTicketsPage().setVisible(true);
            parent.getListTickets().setVisible(false);
        });
        add(backbutton);

        table = new JTable();
        table.setFont(new Font("Montserrat", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.addMouseListener(new CashierMouseListener(table, parent, this));

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(580, 370);
        scrollPane.setLocation(5, 10);
        add(scrollPane);

    }

    public void generateTable() {
        ArrayList<Tickets> tickets = parent.getDbManager().ListTickets();

        TicketsTableModel model = new TicketsTableModel(tickets);
        table.setModel(model);
        table.getColumn("EDIT").setCellRenderer(renderer);
    }
}
