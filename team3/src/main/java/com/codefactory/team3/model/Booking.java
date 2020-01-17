package com.codefactory.team3.model;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookingid")
    private int id;
    @Column(name = "fk_userid")
    private int fk_userID;
    @Column(name = "fk_roomid")
    private int fk_roomID;
    @Column(name = "fk_dateid")
    private int fk_dateID;
    @Column(name = "fk_hotelid")
    private int fk_hotelID;
    @Column(name = "humancage")
    private boolean humanCage;
    @Column(name = "breakfast")
    private boolean breakfast;
    @Column(name = "wellness")
    private boolean wellness;
    @Column(name = "pricesum")
    private double priceSum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_userID() {
        return fk_userID;
    }

    public void setFk_userID(int fk_userID) {
        this.fk_userID = fk_userID;
    }

    public int getFk_roomID() {
        return fk_roomID;
    }

    public void setFk_roomID(int fk_roomID) {
        this.fk_roomID = fk_roomID;
    }

    public int getFk_dateID() {
        return fk_dateID;
    }

    public void setFk_dateID(int fk_dateID) {
        this.fk_dateID = fk_dateID;
    }

    public int getFk_hotelID() {
        return fk_hotelID;
    }

    public void setFk_hotelID(int fk_hotelID) {
        this.fk_hotelID = fk_hotelID;
    }

    public boolean isHumanCage() {
        return humanCage;
    }

    public void setHumanCage(boolean humanCage) {
        this.humanCage = humanCage;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isWellness() {
        return wellness;
    }

    public void setWellness(boolean wellness) {
        this.wellness = wellness;
    }

    public double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(double priceSum) {
        this.priceSum = priceSum;
    }
}
