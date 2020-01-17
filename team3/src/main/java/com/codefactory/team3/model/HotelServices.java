package com.codefactory.team3.model;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class HotelServices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serviceid")
    private int id;

    @Column (name = "servicename")
    private String name;
    @Column (name = "serviceprice")
    private double capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
