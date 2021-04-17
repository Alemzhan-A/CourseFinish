package FlightsPackage;


public class Flights {
    private Long id;
    private int aircraft_id;
    private int deprature_city_id;
    private int arrival_city_id;
    private String departure_time;
    private int econom_place_price;
    private int business_place_price;

    public Flights() {}

    public Flights(Long id, int aircraft_id, int deprature_city_id, int arrival_city_id, String departure_time, int econom_place_price, int business_place_price) {
        this.id = id;
        this.aircraft_id = aircraft_id;
        this.deprature_city_id = deprature_city_id;
        this.arrival_city_id = arrival_city_id;
        this.departure_time = departure_time;
        this.econom_place_price = econom_place_price;
        this.business_place_price = business_place_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(int aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public int getDeprature_city_id() {
        return deprature_city_id;
    }

    public void setDeprature_city_id(int deprature_city_id) {
        this.deprature_city_id = deprature_city_id;
    }

    public int getArrival_city_id() {
        return arrival_city_id;
    }

    public void setArrival_city_id(int arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getEconom_place_price() {
        return econom_place_price;
    }

    public void setEconom_place_price(int econom_place_price) {
        this.econom_place_price = econom_place_price;
    }

    public int getBusiness_place_price() {
        return business_place_price;
    }

    public void setBusiness_place_price(int business_place_price) {
        this.business_place_price = business_place_price;
    }
    public String getData(){
        return id + " " + departure_time;
    }
}
