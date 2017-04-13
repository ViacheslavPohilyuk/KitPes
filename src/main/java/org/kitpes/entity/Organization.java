package org.kitpes.entity;


/**
 * Created by mac on 11.04.17.
 */
public class Organization {
    private String name;
    private String number;
    private String country;
    private String city;

    public Organization(String name, String number, String country, String city) {
        this.name = name;
        this.number = number;
        this.country = country;
        this.city = city;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getCountry() { return this.country; }

    public void setCountry(String country) { this.country = country; }

    public String getCity() { return this.city; }

    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
