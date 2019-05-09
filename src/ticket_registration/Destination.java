/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration;

import java.util.LinkedList;

/**
 *
 * @author filip
 */
public class Destination {
    
    
    //Attributes
    
    static LinkedList<Destination> listOfAllDestinations = new LinkedList<Destination>();
    
    String city;
    String currency;
    String country;
    String region;
    String continent;

    
    //Constructor
    
    public Destination(String city, String currency, String country, String region, String continent) {
        this.city = city;
        this.currency = currency;
        this.country = country;
        this.region = region;
        this.continent = continent;
        
        listOfAllDestinations.add(this);
    }

    
    //ToString and Display
    
    @Override
    public String toString() {
        return "Destination Info" + "\n" + "\n" + "City: " + city + "\n" + "Currency: " + currency + "\n" + "Country: " + country + "\n" +
                "Region: " + region + "\n" + "Continent: " + continent + "\n";
    }
    
    public static void displayAllDestinations() {
    
        for (int i = 0; i < listOfAllDestinations.size(); i++)
        System.out.println(listOfAllDestinations.get(i).city + " " + listOfAllDestinations.get(i).country + " " + listOfAllDestinations.get(i).getContinent());
    }

    
    //Getters and Setters
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    
}
