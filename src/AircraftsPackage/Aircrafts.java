package AircraftsPackage;

import java.util.ArrayList;

public class Aircrafts {
    private Long id;
    private String name;
    private String model;
    private int business_class_capacity;
    private int econom_class_capcity;

    public Aircrafts() {}

    public Aircrafts(Long id, String name, String model, int business_class_capacity, int econom_class_capcity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.business_class_capacity = business_class_capacity;
        this.econom_class_capcity = econom_class_capcity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getBusiness_class_capacity() {
        return business_class_capacity;
    }

    public int getEconom_class_capcity() {
        return econom_class_capcity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBusiness_class_capacity(int business_class_capacity) {
        this.business_class_capacity = business_class_capacity;
    }
    public String getData(){
        return id + " " +  name + " " + model;
    }

    public void setEconom_class_capcity(int econom_class_capcity) {
        this.econom_class_capcity = econom_class_capcity;
    }


}
