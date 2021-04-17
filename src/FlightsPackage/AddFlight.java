package FlightsPackage;

import Admin.MainFrame;
import AircraftsPackage.Aircrafts;
import CitiesPackage.Cities;

import javax.swing.*;
import java.util.ArrayList;

public class AddFlight extends JPanel {
    private MainFrame parent;
    private JButton backbutton,addbutton;
    private JLabel air_id,dep_id,arr_id,dep_time,ec_price,bc_price;
    private JTextField aair_id,adep_id,aarr_id,adep_time,aec_price,abc_price;
    private JComboBox arrival_citycombo,departure_citycombo,aircraftscombo;
    public AddFlight(MainFrame parent){


        this.parent = parent;
        setLayout(null);
        setSize(600,600);

        ArrayList<Aircrafts>aircrafts = parent.getDbManager().ListAircrafts();
        String[] getArr = new String[aircrafts.size()];
            for(int i = 0;i<aircrafts.size();i++) {
                getArr[i] = (aircrafts.get(i).getData());
            }


        aircraftscombo = new JComboBox(getArr);
        aircraftscombo.setSize(200,30);
        aircraftscombo.setLocation(250,105);
        add(aircraftscombo);

        ArrayList<Cities>cities = parent.getDbManager().ListCities();
        String[] getCityarr = new String[cities.size()];
        for(int i = 0;i<cities.size();i++) {
            getCityarr[i] = (cities.get(i).getData());
        }


        arrival_citycombo = new JComboBox(getCityarr);
        arrival_citycombo.setSize(200,30);
        arrival_citycombo.setLocation(250,205);
        add(arrival_citycombo);

        departure_citycombo = new JComboBox(getCityarr);
        departure_citycombo.setSize(200,30);
        departure_citycombo.setLocation(250,155);
        add(departure_citycombo);


        air_id = new JLabel("Aircraft id:");
        air_id.setLocation(150,70);
        air_id.setSize(100,100);
        add(air_id);

        dep_id = new JLabel("Departure city:");
        dep_id.setLocation(150,120);
        dep_id.setSize(100,100);
        add(dep_id);

        arr_id = new JLabel("Arrival city:");
        arr_id.setLocation(150,170);
        arr_id.setSize(100,100);
        add(arr_id);

        dep_time = new JLabel("Departure time:");
        dep_time.setLocation(150,220);
        dep_time.setSize(100,100);
        add(dep_time);

        ec_price = new JLabel("ec price:");
        ec_price.setLocation(150,270);
        ec_price.setSize(100,100);
        add(ec_price);

        bc_price = new JLabel("bc price:");
        bc_price.setLocation(150,320);
        bc_price.setSize(100,100);
        add(bc_price);

        adep_time = new JTextField();
        adep_time.setSize(150,30);
        adep_time.setLocation(250,255);
        add(adep_time);

        aec_price = new JTextField();
        aec_price.setSize(150,30);
        aec_price.setLocation(250,305);
        add(aec_price);

        abc_price = new JTextField();
        abc_price.setSize(150,30);
        abc_price.setLocation(250,355);
        add(abc_price);



        backbutton = new JButton("BACK");
        backbutton.setSize(320,40);
        backbutton.setLocation(130,450);
        backbutton.addActionListener(e -> {
            parent.getAddFlight().setVisible(false);
            parent.getFlightsPage().setVisible(true);
        });
        add(backbutton);

        addbutton = new JButton("ADD");
        addbutton.setLocation(165,400);
        addbutton.setSize(250,40);
        addbutton.addActionListener(e -> {
            String[] arr = aircraftscombo.getSelectedItem().toString().split(" ");
            int aircid = Integer.valueOf(arr[0]);

            String[] arra = arrival_citycombo.getSelectedItem().toString().split(" ");
            int arrcityid = Integer.valueOf(arra[0]);

            String[] array = departure_citycombo.getSelectedItem().toString().split(" ");
            int depcityid = Integer.valueOf(array[0]);

            int airid = aircid;
            int depid = depcityid;
            int arrid = arrcityid;
            String time = adep_time.getText();
            int eprice = Integer.parseInt(aec_price.getText());
            int bprice = Integer.parseInt(abc_price.getText());
            Flights flights = new Flights(null,airid,depid,arrid,time,eprice,bprice);
            if(parent.getDbManager().addFlight(flights)){
                System.out.println("COMPLETE!");
                abc_price.setText("");
                aec_price.setText("");
                adep_time.setText("");
            }else{
                System.out.println("ERROR!");
            }

        });
        add(addbutton);
    }
    public void updateComboValues(){
        ArrayList<Aircrafts>aircrafts = parent.getDbManager().ListAircrafts();
        aircraftscombo.removeAllItems();
        for(int i =0;i<aircrafts.size();i++){
            String data = aircrafts.get(i).getData();
            aircraftscombo.addItem(data);
        }
        arrival_citycombo.removeAllItems();
        departure_citycombo.removeAllItems();
        ArrayList<Cities>cities = parent.getDbManager().ListCities();
        for(int i = 0;i<cities.size();i++){
            String data = cities.get(i).getData();
            arrival_citycombo.addItem(data);
            departure_citycombo.addItem(data);
        }

    }
}
