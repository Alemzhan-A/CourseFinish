package TicketsPackage;

import Cashier.CashierMainFrame;
import FlightsPackage.Flights;

import javax.swing.*;
import java.util.ArrayList;

public class TicketsEditPage extends JPanel {
    private CashierMainFrame parent;

    private JLabel fid, name,surname,pass_num,type;
    private JTextField aname,asurname,apass_num;
    private JButton save, back, delete;
    private JComboBox ticket_typee,flight_idd;
    private String[] types = new String[2];

    private Tickets tickets = null;

    public TicketsEditPage(CashierMainFrame parent) {
        this.parent = parent;

        setSize(600, 600);
        setLayout(null);

        flight_idd = new JComboBox();
        flight_idd.setSize(250,30);
        flight_idd.setLocation(220,50);
        add(flight_idd);
        ArrayList<Flights> flights = parent.getDbManager().ListFlights();
        for(int i = 0;i<flights.size();i++) {
            String data = (flights.get(i).getData());
            flight_idd.addItem(data);
        }

        types[0] = "Econom";
        types[1] = "Business";
        ticket_typee = new JComboBox(types);
        ticket_typee.setSize(250,30);
        ticket_typee.setLocation(220,250);
        add(ticket_typee);

        fid = new JLabel("Flight Id: ");
        fid.setBounds(90, 50, 100, 30);
        add(fid);

        name = new JLabel("Name: ");
        name.setBounds(90, 100, 100, 30);
        add(name);

        surname = new JLabel("Surname: ");
        surname.setBounds(90, 150, 100, 30);
        add(surname);

        pass_num = new JLabel("Passport num: ");
        pass_num.setBounds(90, 200, 100, 30);
        add(pass_num);

        type = new JLabel("Ticket type: ");
        type.setBounds(90, 250, 100, 30);
        add(type);

        aname = new JTextField();
        aname.setBounds(220, 100, 250, 30);
        add(aname);

        asurname= new JTextField();
        asurname.setBounds(220, 150, 250, 30);
        add(asurname);

        apass_num = new JTextField();
        apass_num.setBounds(220, 200, 250, 30);
        add(apass_num);



        back = new JButton("BACK");
        back.setSize(200,55);
        back.setLocation(180,400);
        back.addActionListener(e->{
            parent.getTicketsEditPage().setVisible(false);
            parent.getListTickets().generateTable();
            parent.getListTickets().setVisible(true);
        });
        add(back);

        save = new JButton("SAVE");
        save.setSize(200,40);
        save.setLocation(300,350);
        save.addActionListener(e->{
            String[] arr = flight_idd.getSelectedItem().toString().split(" ");
            int flyid = Integer.valueOf(arr[0]);
            Long id = null;
            int afidd = flyid;
            String namee = aname.getText();
            String sur = asurname.getText();
            String psnum = apass_num.getText();
            String type = (String) ticket_typee.getSelectedItem();

            tickets.setFlight_id(afidd);
            tickets.setName(namee);
            tickets.setSurname(sur);
            tickets.setPassport_number(psnum);
            tickets.setTicket_type(type);
            if (parent.getDbManager().saveTickets(tickets)){
                System.out.println("SAVE COMPLETE!");
            } else
                System.out.println("ERROR!");
        });
        add(save);

        delete = new JButton("DELETE");
        delete.setSize(200,40);
        delete.setLocation(80,350);
        delete.addActionListener(e->{
            if (parent.getDbManager().deleteTicket(tickets.getId())){
                System.out.println("DELETE COMPLETE!");
            } else
                System.out.println("cannot delete!");

            parent.getTicketsEditPage().setVisible(false);
            parent.getListTickets().generateTable();
            parent.getListTickets().setVisible(true);
        });
        add(delete);


    }


    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
        aname.setText(tickets.getName());
        asurname.setText(tickets.getSurname());
        apass_num.setText(tickets.getPassport_number());
    }
    public void updateComboValues(){
        flight_idd.removeAllItems();
        ArrayList<Flights>flights = parent.getDbManager().ListFlights();
        for(int i = 0;i<flights.size();i++) {
            String data = flights.get(i).getData();
            flight_idd.addItem(data);
        }
    }
}
