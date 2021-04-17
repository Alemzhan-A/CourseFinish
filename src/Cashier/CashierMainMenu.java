package Cashier;


import javax.swing.*;

public class CashierMainMenu extends JPanel {
    private CashierMainFrame parent;
    private JButton exitbutton,ticketsbutton;
    public CashierMainMenu(CashierMainFrame parent){
        this.parent = parent;
        setSize(600,600);
        setLayout(null);
        exitbutton = new JButton("EXIT");
        exitbutton.addActionListener(e -> {
            System.exit(0);
        });
        exitbutton.setLocation(170,400);
        exitbutton.setSize(250,50);
        add(exitbutton);

        ticketsbutton = new JButton("TICKETS");
        ticketsbutton.addActionListener(e -> {
            parent.getCashiermainMenu().setVisible(false);
            parent.getTicketsPage().setVisible(true);
        });
        ticketsbutton.setLocation(135,150);
        ticketsbutton.setSize(300,60);
        add(ticketsbutton);

    }

}
