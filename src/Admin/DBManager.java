package Admin;

import AircraftsPackage.Aircrafts;
import CitiesPackage.Cities;
import FlightsPackage.Flights;
import TicketsPackage.Tickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;
    public DBManager(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flycenter?useUnicode=true&serverTimezone=UTC","root","");
            System.out.println("CONNECTED");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addAircraft(Aircrafts aircrafts){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into aircrafts(name, model,econom_class_capacity ,business_class_capacity) values (?, ?, ?,?)");
            statement.setString(1, aircrafts.getName());
            statement.setString(2, aircrafts.getModel());
            statement.setInt(3, aircrafts.getBusiness_class_capacity());
            statement.setInt(4,aircrafts.getEconom_class_capcity());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
    public ArrayList<Aircrafts>ListAircrafts(){
        ArrayList<Aircrafts>aircrafts = new ArrayList<Aircrafts>();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from aircrafts");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("Id");
                String name = rs.getString("Name");
                String model = rs.getString("Model");
                int ec_capacity = rs.getInt("business_class_capacity");
                int bc_capcity = rs.getInt("econom_class_capacity");
                Aircrafts aircraft = new Aircrafts(id,name,model,ec_capacity,bc_capcity);
                aircrafts.add(aircraft);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return aircrafts;
    }

    public boolean saveCities(Cities city){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "update cities set name = ?, country = ?, short_name = ? where id = ? ");
            statement.setString(1, city.getName());
            statement.setString(2, city.getCountry());
            statement.setString(3,city.getShort_name());
            statement.setLong(4, city.getId());

            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public boolean deleteAircraft(Long id){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from aircrafts where id = ? ");
            statement.setLong(1,id);
            rows=statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public boolean addCities(Cities city){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into cities(name, country,short_name) values (?, ?, ?)");
            statement.setString(1, city.getName());
            statement.setString(2, city.getCountry());
            statement.setString(3,city.getShort_name());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
    public ArrayList<Cities>ListCities(){
        ArrayList<Cities>cities = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from cities");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("Id");
                String name = rs.getString("Name");
                String country = rs.getString("Country");
                String shortname = rs.getString("Short_name");
                Cities city = new Cities(id,name,country,shortname);
                cities.add(city);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return cities;
    }

    public boolean saveAircrafts(Aircrafts aircrafts){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "update aircrafts set name = ?, model = ?, business_class_capacity = ?, econom_class_capacity = ? where id = ? ");
            statement.setString(1, aircrafts.getName());
            statement.setString(2, aircrafts.getModel());
            statement.setInt(3, aircrafts.getBusiness_class_capacity());
            statement.setInt(4, aircrafts.getEconom_class_capcity());
            statement.setLong(5, aircrafts.getId());

            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public boolean deleteCities(Long id){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from cities where id = ? ");
            statement.setLong(1,id);
            rows=statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public boolean addTicket(Tickets tickets){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into Tickets(flight_id, name,surname, passport_number,ticket_type) values (?, ?, ?,?,?)");
            statement.setInt(1, tickets.getFlight_id());
            statement.setString(2, tickets.getName());
            statement.setString(3, tickets.getSurname());
            statement.setString(4, tickets.getPassport_number());
            statement.setString(5, tickets.getTicket_type());


            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
    public ArrayList<Tickets>ListTickets(){
        ArrayList<Tickets>tickets = new ArrayList<Tickets>();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from tickets");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("Id");
                int fid = rs.getInt("flight_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String psnum = rs.getString("passport_number");
                String type = rs.getString("ticket_type");


                Tickets ticket = new Tickets(id,fid,name,surname,psnum,type);
                tickets.add(ticket);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return tickets;
    }

    public boolean saveTickets(Tickets tickets){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "update tickets set flight_id = ?, name = ?, surname = ?, passport_number = ?, ticket_type = ? where id = ? ");
            statement.setInt(1,tickets.getFlight_id());
            statement.setString(2,tickets.getName());
            statement.setString(3,tickets.getSurname());
            statement.setString(4,tickets.getPassport_number());
            statement.setString(5,tickets.getTicket_type());
            statement.setLong(6,tickets.getId());


            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public boolean deleteTicket(Long id){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from tickets where id = ? ");
            statement.setLong(1,id);
            rows=statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public boolean addFlight(Flights flights){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into Flights(aircraft_id, deprature_city_id,arrival_city_id ,departure_time, econom_place_price,business_place_price) values (?, ?, ?,?,?,?)");
            statement.setInt(1, flights.getAircraft_id());
            statement.setInt(2, flights.getDeprature_city_id());
            statement.setInt(3, flights.getArrival_city_id());
            statement.setString(4, flights.getDeparture_time());
            statement.setInt(5, flights.getEconom_place_price());
            statement.setInt(6, flights.getBusiness_place_price());


            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
    public ArrayList<Flights>ListFlights(){
        ArrayList<Flights>flights = new ArrayList<Flights>();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from Flights");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("Id");
                int aid = rs.getInt("aircraft_id");
                int dpid = rs.getInt("deprature_city_id");
                int arid = rs.getInt("arrival_city_id");
                String time = rs.getString("departure_time");
                int ec_pr = rs.getInt("econom_place_price");
                int bc_pr = rs.getInt("business_place_price");

                Flights fly = new Flights(id,aid,dpid,arid,time,ec_pr,bc_pr);
                flights.add(fly);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return flights;
    }

    public boolean saveFlights(Flights flights){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "update flights set aircraft_id = ?, deprature_city_id = ?, arrival_city_id = ?, departure_time = ?, econom_place_price = ?, business_place_price = ?  where id = ? ");
            statement.setInt(1,flights.getAircraft_id());
            statement.setInt(2,flights.getDeprature_city_id());
            statement.setInt(3,flights.getArrival_city_id());
            statement.setString(4,flights.getDeparture_time());
            statement.setInt(5,flights.getEconom_place_price());
            statement.setInt(6,flights.getBusiness_place_price());
            statement.setLong(7,flights.getId());


            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public boolean deleteFlight(Long id){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from flights where id = ? ");
            statement.setLong(1,id);
            rows=statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }
}
