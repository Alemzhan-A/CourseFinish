package Cashier;

import Admin.DBManager;
import Admin.MainFrame;
import TicketsPackage.*;

import javax.swing.*;

public class CashierMainFrame extends JFrame {
    private DBManager dbManager = new DBManager();
    private CashierMainMenu CashiermainMenu;
    private AddTicket addTicket;
    private ListTickets listTickets;
    private TicketsEditPage ticketsEditPage;
    private TicketsPage ticketsPage;

    public CashierMainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("CASHIER");
        setLayout(null);
        setSize(600,600);

        CashiermainMenu = new CashierMainMenu(this);
        CashiermainMenu.setVisible(true);
        add(CashiermainMenu);


        addTicket = new AddTicket(this);
        addTicket.setVisible(false);
        add(addTicket);

        listTickets = new ListTickets(this);
        listTickets.setVisible(false);
        add(listTickets);

        ticketsEditPage = new TicketsEditPage(this);
        ticketsEditPage.setVisible(false);
        add(ticketsEditPage);

        ticketsPage = new TicketsPage(this);
        ticketsPage.setVisible(false);
        add(ticketsPage);




    }

    public CashierMainMenu getCashiermainMenu() {
        return CashiermainMenu;
    }

    public TicketsPage getTicketsPage() {
        return ticketsPage;
    }

    public TicketsEditPage getTicketsEditPage() {
        return ticketsEditPage;
    }

    public ListTickets getListTickets() {
        return listTickets;
    }

    public AddTicket getAddTicket() {
        return addTicket;
    }

    public DBManager getDbManager() {
        return dbManager;
    }


}
