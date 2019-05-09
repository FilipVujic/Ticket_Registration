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
public class Train extends Transport {
    
    
    //Attributes
    
    boolean fast;
    

    //Constructor
    
    public Train(int numberOfSeatsAvailable, Destination placeOfDeparture, Destination placeOfArrival, String timeOfDeparture, String timeOfArrival, 
            int transportID, boolean fast) throws ParseException {
        
        super(numberOfSeatsAvailable, placeOfDeparture, placeOfArrival, timeOfDeparture, timeOfArrival, transportID);
        
            this.fast = fast;
         
    }
    
    
    //ToString
    
    @Override
    public String toString() {
        
        String temp = super.toString();
        
        return temp + "Fast: " + fast + "\n";
    }
    

    //Getters and Setters
    
    public boolean isFast() {
        return fast;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }
    
    
}
