package FlightsPackage;

import Admin.MainFrame;
import AircraftsPackage.Aircrafts;
import CitiesPackage.Cities;

import javax.swing.*;
import java.util.ArrayList;

public class FlightsEditPage extends JPanel {
    private MainFrame parent;

    private JLabel airid, depid,arrid,deptime,ecprice,bcprice;
    private JTextField airidText, depidText, arridText,deptimeText,ecpriceText,bcpriceText;
    private JButton save, back, delete;
    private JComboBox arrival_citycombo,departure_citycombo,aircraftscombo;

    private Flights flights = null;

    public FlightsEditPage(MainFrame parent) {
        this.parent = parent;

        setSize(600, 600);
        setLayout(null);

        ArrayList<Aircrafts> aircrafts = parent.getDbManager().ListAircrafts();
        String[] getArr = new String[aircrafts.size()];
        for(int i = 0;i<aircrafts.size();i++) {
            getArr[i] = (aircrafts.get(i).getData());
        }


        aircraftscombo = new JComboBox(getArr);
        aircraftscombo.setSize(250,30);
        aircraftscombo.setLocation(220,50);
        add(aircraftscombo);

        ArrayList<Cities>cities = parent.getDbManager().ListCities();
        String[] getCityarr = new String[cities.size()];
        for(int i = 0;i<cities.size();i++) {
            getCityarr[i] = (cities.get(i).getData());
        }


        arrival_citycombo = new JComboBox(getCityarr);
        arrival_citycombo.setSize(250,30);
        arrival_citycombo.setLocation(220,150);
        add(arrival_citycombo);

        departure_citycombo = new JComboBox(getCityarr);
        departure_citycombo.setSize(250,30);
        departure_citycombo.setLocation(220,100);
        add(departure_citycombo);

        airid = new JLabel("Aircraft id: ");
        airid.setBounds(90, 50, 100, 30);
        add(airid);

        depid = new JLabel("Departure city id: ");
        depid.setBounds(90, 100, 100, 30);
        add(depid);

        arrid = new JLabel("Arrival city id: ");
        arrid.setBounds(90, 150, 100, 30);
        add(arrid);

        deptime = new JLabel("Departure time: ");
        deptime.setBounds(90, 200, 100, 30);
        add(deptime);

        ecprice = new JLabel("ec price: ");
        ecprice.setBounds(90, 250, 100, 30);
        add(ecprice);

        bcprice = new JLabel("bc price: ");
        bcprice.setBounds(90, 300, 100, 30);
        add(bcprice);

        deptimeText = new JTextField();
        deptimeText.setBounds(220, 200, 250, 30);
        add(deptimeText);

        ecpriceText = new JTextField();
        ecpriceText.setBounds(220, 250, 250, 30);
        add(ecpriceText);

        bcpriceText= new JTextField();
        bcpriceText.setBounds(220, 300, 250, 30);
        add(bcpriceText);

        back = new JButton("BACK");
        back.setSize(200,55);
        back.setLocation(180,400);
        back.addActionListener(e->{
            parent.getFlightsEditPage().setVisible(false);
            parent.getListFlights().generateTable();
            parent.getListFlights().setVisible(true);
        });
        add(back);

        save = new JButton("SAVE");
        save.setSize(200,40);
        save.setLocation(300,350);
        save.addActionListener(e->{
            String[] arr = aircraftscombo.getSelectedItem().toString().split(" ");
            int aircid = Integer.valueOf(arr[0]);

            String[] arra = arrival_citycombo.getSelectedItem().toString().split(" ");
            int arrcityid = Integer.valueOf(arra[0]);

            String[] array = departure_citycombo.getSelectedItem().toString().split(" ");
            int depcityid = Integer.valueOf(array[0]);
            Long id = null;
            int airid = aircid;
            int depid = depcityid;
            int arrid = arrcityid;
            String deptime = deptimeText.getText();
            int ecprice = Integer.parseInt(ecpriceText.getText());
            int bcprice = Integer.parseInt(bcpriceText.getText());

            flights.setAircraft_id(airid);
            flights.setDeparture_time(deptime);
            flights.setArrival_city_id(arrid);
            flights.setDeprature_city_id(depid);
            flights.setEconom_place_price(ecprice);
            flights.setBusiness_place_price(bcprice);
            if (parent.getDbManager().saveFlights(flights)){
                System.out.println("SAVE COMPLETE!");
            } else
                System.out.println("ERROR!");
        });
        add(save);

        delete = new JButton("DELETE");
        delete.setSize(200,40);
        delete.setLocation(80,350);
        delete.addActionListener(e->{
            if (parent.getDbManager().deleteFlight(flights.getId())){
                System.out.println("DELETE COMPLETE!");
            } else
                System.out.println("cannot delete!");

            parent.getFlightsEditPage().setVisible(false);
            parent.getListFlights().generateTable();
            parent.getListFlights().setVisible(true);
        });
        add(delete);


    }


    public void setFlights(Flights flights) {
        this.flights = flights;
        deptimeText.setText(flights.getDeparture_time());
        ecpriceText.setText(flights.getEconom_place_price() + "");
        bcpriceText.setText(flights.getBusiness_place_price() + "");
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
