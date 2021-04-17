package TicketsPackage;

import AircraftsPackage.Aircrafts;
import FlightsPackage.Flights;
import Cashier.CashierMainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class AddTicket extends JPanel {
    private CashierMainFrame parent;
    private JButton backbutton, addbutton;
    private JLabel flight_id, name, surname, passport_number, ticket_type;
    private JTextField aflight_id, aname, asurname, apassport_number, aticket_type;
    private JComboBox ticket_typee,flight_idd;
    private String[] types = new String[2];

    public AddTicket(CashierMainFrame parent) {

        types[0] = "Econom";
        types[1] = "Business";
        this.parent = parent;
        setLayout(null);
        setSize(600, 600);

        ArrayList<Flights>flights = parent.getDbManager().ListFlights();
        String[] getArr = new String[flights.size()];
        for(int i = 0;i<flights.size();i++) {
            getArr[i] = (flights.get(i).getData());
        }


        flight_idd = new JComboBox(getArr);
        flight_idd.setSize(150,30);
        flight_idd.setLocation(250,105);
        add(flight_idd);

        flight_id = new JLabel("Flight id:");
        flight_id.setLocation(150, 70);
        flight_id.setSize(100, 100);
        add(flight_id);

        name = new JLabel("Name:");
        name.setLocation(150, 120);
        name.setSize(100, 100);
        add(name);

        surname = new JLabel("Surname:");
        surname.setLocation(150, 170);
        surname.setSize(100, 100);
        add(surname);

        passport_number = new JLabel("Passport_number:");
        passport_number.setLocation(150, 220);
        passport_number.setSize(100, 100);
        add(passport_number);

        ticket_type = new JLabel("Ticket type:");
        ticket_type.setLocation(150, 270);
        ticket_type.setSize(100, 100);
        add(ticket_type);

        aname = new JTextField();
        aname.setSize(150, 30);
        aname.setLocation(250, 155);
        add(aname);

        asurname = new JTextField();
        asurname.setSize(150, 30);
        asurname.setLocation(250, 205);
        add(asurname);

        apassport_number = new JTextField();
        apassport_number.setSize(150, 30);
        apassport_number.setLocation(250, 255);
        add(apassport_number);


        ticket_typee = new JComboBox(types);
        ticket_typee.setSize(150,30);
        ticket_typee.setLocation(250,305);
        add(ticket_typee);



        backbutton = new JButton("BACK");
        backbutton.setSize(320, 40);
        backbutton.setLocation(130, 450);
        backbutton.addActionListener(e -> {
            parent.getAddTicket().setVisible(false);
            parent.getTicketsPage().setVisible(true);
        });
        add(backbutton);

        addbutton = new JButton("ADD");
        addbutton.setLocation(165, 400);
        addbutton.setSize(250, 40);
        addbutton.addActionListener(e -> {
            String[] arr = flight_idd.getSelectedItem().toString().split(" ");
            int flyid = Integer.valueOf(arr[0]);

            int fid = flyid;
            String name = aname.getText();
            String surname = asurname.getText();
            String psnumber = apassport_number.getText();
            String type = (String) ticket_typee.getSelectedItem();
            Tickets tickets = new Tickets(null, fid, name, surname, psnumber, type);
            if (parent.getDbManager().addTicket(tickets)) {
                System.out.println("COMPLETE!");
                aname.setText("");
                asurname.setText("");
                apassport_number.setText("");
            } else {
                System.out.println("ERROR!");
            }

        });
        add(addbutton);
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