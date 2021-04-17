package AircraftsPackage;

import Admin.MainFrame;

import javax.swing.*;

public class AircraftsPage extends JPanel {
    private MainFrame parent;
    private JButton addbutton,listbutton,backbutton;
    public AircraftsPage(MainFrame parent){
        setLayout(null);
        setSize(600,600);
        this.parent = parent;
        addbutton = new JButton("ADD AIRCRAFT");
        addbutton.setLocation(150,70);
        addbutton.setSize(300,50);
        addbutton.addActionListener(e->{
            parent.getAddAircraft().setVisible(true);
            parent.getAircraftsPage().setVisible(false);
        });
        add(addbutton);

        listbutton = new JButton("LIST OF AIRCRAFTS");
        listbutton.setLocation(150,140);
        listbutton.setSize(300,50);
        listbutton.addActionListener(e->{
            parent.getListAircrafts().generateTable();
            parent.getAircraftsPage().setVisible(false);
            parent.getListAircrafts().setVisible(true);
        });
        add(listbutton);

        backbutton = new JButton("BACK");
        backbutton.setLocation(150,320);
        backbutton.setSize(300,50);
        backbutton.addActionListener(e -> {
            parent.getMainMenu().setVisible(true);
            parent.getAircraftsPage().setVisible(false);
        });
        add(backbutton);

    }

}
