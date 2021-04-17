package FlightsPackage;


import Admin.MainFrame;

import javax.swing.*;

public class FlightsPage extends JPanel {
    private MainFrame parent;
    private JButton addbutton,listbutton,backbutton;
    public FlightsPage(MainFrame parent){
        setLayout(null);
        setSize(600,600);
        this.parent = parent;
        addbutton = new JButton("ADD FLIGHT");
        addbutton.setLocation(150,70);
        addbutton.setSize(300,50);
        addbutton.addActionListener(e->{
            parent.getAddFlight().setVisible(true);
            parent.getAddFlight().updateComboValues();
            parent.getFlightsPage().setVisible(false);
        });
        add(addbutton);

        listbutton = new JButton("LIST OF FLIGHTS");
        listbutton.setLocation(150,140);
        listbutton.setSize(300,50);
        listbutton.addActionListener(e->{
            parent.getListFlights().setVisible(true);
            parent.getListFlights().generateTable();
            parent.getFlightsPage().setVisible(false);
        });
        add(listbutton);

        backbutton = new JButton("BACK");
        backbutton.setLocation(150,320);
        backbutton.setSize(300,50);
        backbutton.addActionListener(e->{
            parent.getMainMenu().setVisible(true);
            parent.getFlightsPage().setVisible(false);
        });
        add(backbutton);

    }

}
