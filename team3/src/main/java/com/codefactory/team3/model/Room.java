package com.codefactory.team3.model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roomID")
    private int id;

    @Column (name = "roomname")
    private String name;
    @Column(name = "fk_categoryid")
    private int fk_categoryID;
    @Column(name = "fk_hotelid")
    private int fk_hotelID;


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

    public int getFk_hotelID() {
        return fk_hotelID;
    }

    public void setFk_hotelID(int fk_hotelID) {
        this.fk_hotelID = fk_hotelID;
    }

    public int getFk_categoryID() {
        return fk_categoryID;
    }

    public void setFk_categoryID(int fk_categoryID) {
        this.fk_categoryID = fk_categoryID;
    }
}
