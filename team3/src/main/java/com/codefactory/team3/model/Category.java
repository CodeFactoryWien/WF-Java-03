package com.codefactory.team3.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    private int id;
    @Column(name ="categoryname")
    private String categoryName;
    @Column (name = "categorysize")
    private int size;
    @Column(name = "categoryprice")
    private double categoryPrice;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(double categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
