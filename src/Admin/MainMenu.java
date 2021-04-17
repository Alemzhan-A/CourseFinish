package Admin;


import javax.swing.*;

public class MainMenu extends JPanel {
    private MainFrame parent;
    private JButton exitbutton,citiesbutton,flightsbutton,aircraftsbutton,ticketsbutton;
    public MainMenu(MainFrame parent){
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

        citiesbutton = new JButton("CITIES");
        citiesbutton.addActionListener(e -> {
            parent.getMainMenu().setVisible(false);
            parent.getCitiesPage().setVisible(true);
        });
        citiesbutton.setLocation(155,100);
        citiesbutton.setSize(280,35);
        add(citiesbutton);

        flightsbutton = new JButton("FLIGHTS");
        flightsbutton.addActionListener(e -> {
            parent.getMainMenu().setVisible(false);
            parent.getFlightsPage().setVisible(true);
        });
        flightsbutton.setLocation(155,170);
        flightsbutton.setSize(280,35);
        add(flightsbutton);

        aircraftsbutton = new JButton("AIRCRAFTS");
        aircraftsbutton.addActionListener(e -> {
            parent.getMainMenu().setVisible(false);
            parent.getAircraftsPage().setVisible(true);
        });
        aircraftsbutton.setLocation(155,240);
        aircraftsbutton.setSize(280,35);
        add(aircraftsbutton);

    }

}
