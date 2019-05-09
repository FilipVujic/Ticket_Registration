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
public class Airplane extends Transport {
    
    
    //Attributes
    
    boolean supersonic;
    

    //Constructor
    
    public Airplane(int numberOfSeatsAvailable, Destination placeOfDeparture, Destination placeOfArrival, String timeOfDeparture, String timeOfArrival, 
            int transportID, boolean supersonic) throws ParseException {
        
        super(numberOfSeatsAvailable, placeOfDeparture, placeOfArrival, timeOfDeparture, timeOfArrival, transportID);
        
            this.supersonic = supersonic;
    }

    
    //ToString
    
    @Override
    public String toString() {
        
        String temp = super.toString();
        
        return temp + "Supersonic: " + supersonic + "\n";
    }
    
    
    
    //Getters and Setters
    
    public boolean isSupersonic() {
        return supersonic;
    }

    public void setSupersonic(boolean supersonic) {
        this.supersonic = supersonic;
    }
    
    
}
