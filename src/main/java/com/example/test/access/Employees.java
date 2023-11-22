package com.example.test.access;

public class Employees {

    private String city;
    private String street;

    Employees(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
