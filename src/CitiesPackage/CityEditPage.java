package CitiesPackage;

import Admin.MainFrame;

import javax.swing.*;

public class CityEditPage extends JPanel {
    private MainFrame parent;

    private JLabel name, country, shortname;
    private JTextField nameText,countryText, shortnameText;
    private JButton save, back, delete;

    private Cities cities = null;

    public CityEditPage(MainFrame parent) {
        this.parent = parent;

        setSize(600, 600);
        setLayout(null);

        name = new JLabel("Name: ");
        name.setBounds(90, 50, 100, 30);
        add(name);

        country = new JLabel("Country: ");
        country.setBounds(90, 100, 100, 30);
        add(country);

        shortname = new JLabel("ShortName: ");
        shortname.setBounds(90, 150, 100, 30);
        add(shortname);

        nameText = new JTextField();
        nameText.setBounds(220, 50, 250, 30);
        add(nameText);

        countryText = new JTextField();
        countryText.setBounds(220, 100, 250, 30);
        add(countryText);

        shortnameText= new JTextField();
        shortnameText.setBounds(220, 150, 250, 30);
        add(shortnameText);

        back = new JButton("BACK");
        back.setSize(200,55);
        back.setLocation(180,400);
        back.addActionListener(e->{
            parent.getCityEditPage().setVisible(false);
            parent.getListCities().generateTable();
            parent.getListCities().setVisible(true);
        });
        add(back);

        save = new JButton("SAVE");
        save.setSize(200,40);
        save.setLocation(300,310);
        save.addActionListener(e->{
            Long id = null;
            String name = nameText.getText();
            String country = countryText.getText();
            String shortname = shortnameText.getText();

            cities.setName(name);
            cities.setCountry(country);
            cities.setShort_name(shortname);
            if (parent.getDbManager().saveCities(cities)){
                System.out.println("SAVE COMPLETE!");
            } else
                System.out.println("ERROR!");
        });
        add(save);

        delete = new JButton("DELETE");
        delete.setSize(200,40);
        delete.setLocation(80,310);
        delete.addActionListener(e->{
            if (parent.getDbManager().deleteCities(cities.getId())){
                System.out.println("DELETE COMPLETE!");
            } else
                System.out.println("cannot delete!");

            parent.getCityEditPage().setVisible(false);
            parent.getListCities().generateTable();
            parent.getListCities().setVisible(true);
        });
        add(delete);


    }


    public void setCities(Cities cities) {
        this.cities = cities;
        nameText.setText(cities.getName());
        countryText.setText(cities.getCountry());
        shortnameText.setText(cities.getShort_name());
    }
}