/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration.transport;

import java.text.ParseException;
import ticket_registration.Destination;

/**
 *
 * @author filip
 */
public class Bus extends Transport{
    
    
    //Attributes
    
    boolean doubleDecker;
    boolean mini;

    
    //Constructor
    
    public Bus(int numberOfSeatsAvailable, Destination placeOfDeparture, Destination placeOfArrival, String timeOfDeparture, String timeOfArrival, 
            int transportID, boolean doubleDecker, boolean mini) throws ParseException {
        
        super(numberOfSeatsAvailable, placeOfDeparture, placeOfArrival, timeOfDeparture, timeOfArrival, transportID);
        if (doubleDecker == mini) System.out.println("The bus can't both be a double decker and a mini.");
        else {
            this.doubleDecker = doubleDecker;
            this.mini = mini;
        }
    }
    
    
    //ToString
    
    @Override
    public String toString() {
        
        String temp = super.toString();
        return temp + "Double decker: " + doubleDecker + "\n" + "Mini: " + mini + "\n";
    }

    
    //Getters and Setters
    
    public boolean isDoubleDecker() {
        return doubleDecker;
    }

    public void setDoubleDecker(boolean doubleDecker) {
        this.doubleDecker = doubleDecker;
    }

    public boolean isMini() {
        return mini;
    }

    public void setMini(boolean mini) {
        this.mini = mini;
    }
    
    
}
