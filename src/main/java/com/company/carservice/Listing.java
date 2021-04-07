package com.company.carservice;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ListingKey.class)
public class Listing {

    @Id
    private String dealerId;

    @Id
    private String code;

    private String make;
    private String model;
    private int kW;
    private String color;
    private int year;
    private int price;

    public Listing() {
    }

    public String getDealerId() {
        return dealerId;
    }

    public String getCode() {
        return code;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getkW() {
        return kW;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setkW(int kW) {
        this.kW = kW;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return dealerId.equals(listing.dealerId) && code.equals(listing.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealerId, code);
    }
}
