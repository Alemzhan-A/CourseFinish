package Admin;

import AircraftsPackage.AddAircraft;
import CitiesPackage.AddCity;
import CitiesPackage.CityEditPage;
import CitiesPackage.ListCities;
import FlightsPackage.AddFlight;
import FlightsPackage.FlightsEditPage;
import FlightsPackage.ListFlights;
import TicketsPackage.*;
import AircraftsPackage.AircraftEditPage;
import AircraftsPackage.AircraftsPage;
import AircraftsPackage.ListAircrafts;
import CitiesPackage.CitiesPage;
import FlightsPackage.FlightsPage;
import TicketsPackage.TicketsPage;

import javax.swing.*;

public class MainFrame extends JFrame {
    private DBManager dbManager = new DBManager();
    private MainMenu mainMenu;
    private AircraftsPage aircrafsPage;
    private CitiesPage citiesPage;
    private TicketsPage ticketsPage;
    private FlightsPage flightsPage;
    private AddAircraft addAircraft;
    private ListAircrafts listAircrafts;
    private AircraftEditPage aircraftEditPage;
    private AddCity addCity;
    private ListCities listCities;
    private CityEditPage cityEditPage;
    private AddFlight addFlight;
    private ListFlights listFlights;
    private FlightsEditPage flightsEditPage;
    private AddTicket addTicket;
    private ListTickets listTickets;
    private TicketsEditPage ticketsEditPage;
    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ADMIN");
        setLayout(null);
        setSize(600,600);

        mainMenu = new MainMenu(this);
        mainMenu.setVisible(true);
        add(mainMenu);

        aircrafsPage = new AircraftsPage(this);
        aircrafsPage.setVisible(false);
        add(aircrafsPage);

        citiesPage = new CitiesPage(this);
        citiesPage.setVisible(false);
        add(citiesPage);

        flightsPage = new FlightsPage(this);
        flightsPage.setVisible(false);
        add(flightsPage);

        addAircraft = new AddAircraft(this);
        addAircraft.setVisible(false);
        add(addAircraft);

        listAircrafts = new ListAircrafts(this);
        listAircrafts.setVisible(false);
        add(listAircrafts);

        aircraftEditPage = new AircraftEditPage(this);
        aircraftEditPage.setVisible(false);
        add(aircraftEditPage);

        addCity = new AddCity(this);
        addCity.setVisible(false);
        add(addCity);

        listCities = new ListCities(this);
        listCities.setVisible(false);
        add(listCities);

        cityEditPage = new CityEditPage(this);
        cityEditPage.setVisible(false);
        add(cityEditPage);

        addFlight = new AddFlight(this);
        addFlight.setVisible(false);
        add(addFlight);

        listFlights = new ListFlights(this);
        listFlights.setVisible(false);
        add(listFlights);

        flightsEditPage = new FlightsEditPage(this);
        flightsEditPage.setVisible(false);
        add(flightsEditPage);

    }

    public TicketsEditPage getTicketsEditPage() {
        return ticketsEditPage;
    }

    public ListTickets getListTickets() {
        return listTickets;
    }

    public AddTicket getAddTicket() {
        return addTicket;
    }

    public FlightsEditPage getFlightsEditPage() {
        return flightsEditPage;
    }

    public ListFlights getListFlights() {
        return listFlights;
    }

    public AddFlight getAddFlight() {
        return addFlight;
    }

    public CityEditPage getCityEditPage() {
        return cityEditPage;
    }

    public ListCities getListCities() {
        return listCities;
    }

    public AddCity getAddCity() {
        return addCity;
    }

    public AircraftEditPage getAircraftEditPage() {
        return aircraftEditPage;
    }

    public ListAircrafts getListAircrafts() {
        return listAircrafts;
    }

    public CitiesPage getCitiesPage() {
        return citiesPage;
    }

    public TicketsPage getTicketsPage() {
        return ticketsPage;
    }

    public FlightsPage getFlightsPage() {
        return flightsPage;
    }

    public DBManager getDbManager() {
        return dbManager;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public AircraftsPage getAircraftsPage() {
        return aircrafsPage;
    }

    public AddAircraft getAddAircraft() {
        return addAircraft;
    }

}
