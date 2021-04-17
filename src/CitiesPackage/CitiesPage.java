package CitiesPackage;


import Admin.MainFrame;

import javax.swing.*;

public class CitiesPage extends JPanel {
    private MainFrame parent;
    private JButton addbutton,listbutton,backbutton;
    public CitiesPage(MainFrame parent){
        setLayout(null);
        setSize(600,600);
        this.parent = parent;
        addbutton = new JButton("ADD CITY");
        addbutton.setLocation(150,70);
        addbutton.setSize(300,50);
        addbutton.addActionListener(e->{
            parent.getAddCity().setVisible(true);
            parent.getCitiesPage().setVisible(false);
        });
        add(addbutton);

        listbutton = new JButton("LIST OF CITIES");
        listbutton.setLocation(150,140);
        listbutton.setSize(300,50);
        listbutton.addActionListener(e->{
            parent.getCitiesPage().setVisible(false);
            parent.getListCities().setVisible(true);
            parent.getListCities().generateTable();
        });
        add(listbutton);

        backbutton = new JButton("BACK");
        backbutton.setLocation(150,320);
        backbutton.setSize(300,50);
        backbutton.addActionListener(e->{
            parent.getMainMenu().setVisible(true);
            parent.getCitiesPage().setVisible(false);
        });
        add(backbutton);

    }

}
