package TicketsPackage;



import Cashier.CashierMainFrame;

import javax.swing.*;

public class TicketsPage extends JPanel {
    private CashierMainFrame parent;
    private JButton addbutton,listbutton,backbutton;
    public TicketsPage(CashierMainFrame parent){
        setLayout(null);
        setSize(600,600);
        this.parent = parent;
        addbutton = new JButton("ADD TICKET");
        addbutton.setLocation(150,70);
        addbutton.setSize(300,50);
        addbutton.addActionListener(e->{
            parent.getAddTicket().setVisible(true);
            parent.getAddTicket().updateComboValues();
            parent.getTicketsPage().setVisible(false);
        });
        add(addbutton);

        listbutton = new JButton("LIST OF TICKETS");
        listbutton.setLocation(150,140);
        listbutton.setSize(300,50);
        listbutton.addActionListener(e->{
            parent.getListTickets().setVisible(true);
            parent.getListTickets().generateTable();
            parent.getTicketsPage().setVisible(false);
        });
        add(listbutton);

        backbutton = new JButton("BACK");
        backbutton.setLocation(150,320);
        backbutton.setSize(300,50);
        backbutton.addActionListener(e->{
            parent.getCashiermainMenu().setVisible(true);
            parent.getTicketsPage().setVisible(false);
        });
        add(backbutton);

    }

}
