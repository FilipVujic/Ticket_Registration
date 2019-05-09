/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration.transport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
//import java.util.Random;
import ticket_registration.Destination;

/**
 *
 * @author filip
 */
public abstract class Transport {
    
    
    //Attributes
    
    int numberOfSeatsAvailable;
    int transportID;
    Destination placeOfDeparture;
    Destination placeOfArrival;
    Date timeOfDeparture;
    Date timeOfArrival;
    
    public static LinkedList<Transport> listOfAllTransports = new LinkedList<>();
    
    
    //Constructor
    
    public Transport(int numberOfSeatsAvailable, Destination placeOfDeparture, Destination placeOfArrival, String timeOfDeparture, String timeOfArrival, int transportID) throws ParseException {
    
        SimpleDateFormat departure = new SimpleDateFormat("dd-MM-yyyy HH-mm");
        Date dateOfDeparture = departure.parse(timeOfDeparture);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfDeparture);
        
        SimpleDateFormat arrival = new SimpleDateFormat("dd-MM-yyyy HH-mm");
        Date dateOfArrival = departure.parse(timeOfArrival);
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(dateOfDeparture);
        
        
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
        //transportID = 10000000 + new Random().nextInt(90000);
        this.placeOfDeparture = placeOfDeparture;
        this.placeOfArrival = placeOfArrival;
        this.timeOfDeparture = dateOfDeparture;
        this.timeOfArrival = dateOfArrival;
        
        if (transportID < 100000 || transportID > 99999999) {
            
            System.out.println("Please enter passport number between 6-8 characters!");
            System.exit(1);
        }
        
        this.transportID = transportID;
        
        listOfAllTransports.add(this);
    }
    
    

    //ToString and Display
    
    @Override
    public String toString() {
        return "Transport info" + "\n" + "\n" + "Type: " + this.getClass().getSimpleName() + "Number Of Seats Available: " + numberOfSeatsAvailable + "\n" + "Transport ID: " + transportID + 
                "\n" + "Place Of Departure: " + placeOfDeparture.getCity() + "\n" + "Place Of Arrival: " + placeOfArrival.getCity() + "\n" + 
                "Time Of Departure: " + timeOfDeparture + "\n" + "Time Of Arrival: " + timeOfArrival + "\n";
    }
    
    
    public static void displayAllTransports() {
        
            for (int i = 0; i < Transport.listOfAllTransports.size(); i++) {
                
                    System.out.println(Transport.listOfAllTransports.get(i).getClass().getSimpleName()+ ", " + 
                            Transport.listOfAllTransports.get(i).getPlaceOfDeparture().getCity() + " - " +
                            Transport.listOfAllTransports.get(i).getPlaceOfArrival().getCity() + ", " +
                            Transport.listOfAllTransports.get(i).getTimeOfDeparture() + " - " +
                            Transport.listOfAllTransports.get(i).getTimeOfArrival() + ", "+ 
                            Transport.listOfAllTransports.get(i).getTransportID() + "\n");
                    
                }
            
        }
    
    
    //Getters and Setters

    public int getNumberOfSeatsAvailable() {
        return numberOfSeatsAvailable;
    }

    public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    public Destination getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(Destination placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public Destination getPlaceOfArrival() {
        return placeOfArrival;
    }

    public void setPlaceOfArrival(Destination placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }

    public Date getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(Date timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public Date getTimeOfArrival() {
        return timeOfArrival;
    }

    public void Date(Date timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public int getTransportID() {
        return transportID;
    }

    public void setTransportID(int transportID) {
        this.transportID = transportID;
    }

    
    
}

