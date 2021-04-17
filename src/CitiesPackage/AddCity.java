package CitiesPackage;

import Admin.MainFrame;

import javax.swing.*;

public class AddCity extends JPanel {
    private MainFrame parent;
    private JButton backbutton,addbutton;
    private JLabel name,country,shortname;
    private JTextField aname,acountry,ashortname;
    public AddCity(MainFrame parent){
        this.parent = parent;
        setLayout(null);
        setSize(600,600);

        name = new JLabel("NAME:");
        name.setLocation(150,70);
        name.setSize(100,100);
        add(name);

        country = new JLabel("Country:");
        country.setLocation(150,120);
        country.setSize(100,100);
        add(country);

        shortname = new JLabel("ShortName:");
        shortname.setLocation(150,170);
        shortname.setSize(100,100);
        add(shortname);

        aname = new JTextField();
        aname.setSize(150,30);
        aname.setLocation(250,105);
        add(aname);

        acountry = new JTextField();
        acountry.setSize(150,30);
        acountry.setLocation(250,155);
        add(acountry);

        ashortname = new JTextField();
        ashortname.setSize(150,30);
        ashortname.setLocation(250,205);
        add(ashortname);

        backbutton = new JButton("BACK");
        backbutton.setSize(320,40);
        backbutton.setLocation(130,400);
        backbutton.addActionListener(e -> {
            parent.getAddCity().setVisible(false);
            parent.getCitiesPage().setVisible(true);
        });
        add(backbutton);

        addbutton = new JButton("ADD");
        addbutton.setLocation(165,350);
        addbutton.setSize(250,40);
        addbutton.addActionListener(e -> {
            String name = aname.getText();
            String country = acountry.getText();
            String shortname = ashortname.getText();
            Cities cities = new Cities(null,name,country,shortname);
            if(parent.getDbManager().addCities(cities)){
                System.out.println("COMPLETE!");
                aname.setText("");
                acountry.setText("");
                ashortname.setText("");
            }else{
                System.out.println("ERROR!");
            }

        });
        add(addbutton);
    }
}
