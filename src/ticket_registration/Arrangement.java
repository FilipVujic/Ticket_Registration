/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration;

import java.util.LinkedList;
import ticket_registration.customer.Customer;
import ticket_registration.transport.Transport;

/**
 *
 * @author filip
 */
public class Arrangement {

    
    //Attributes

    public static LinkedList<Arrangement> listOfAllArrangements = new LinkedList<>();
    
    public Customer customer;
    public Destination destination;
    public Destination departure;
    public Transport transport;
    public int price;
    public int arrangementID;
    
    
    //ToString and Display

    @Override
    public String toString() {
        return "Arrangement{" + "customer=" + customer + ", destination=" + destination + ", departure=" + departure + ", transport=" + 
                transport + ", price=" + price + ", arrangementID=" + arrangementID + '}';
    }
    
    
    public static void displayAllArangements() {
    
        System.out.println("All arrangements: ");
        System.out.println("");
        
        for (int i = 0; i < Arrangement.listOfAllArrangements.size(); i++){

            System.out.println(Arrangement.listOfAllArrangements.get(i).getCustomer().getName() + " " + 
                    Arrangement.listOfAllArrangements.get(i).getCustomer().getSurname() + " - " + 
                    Arrangement.listOfAllArrangements.get(i).getDestination().getCity() + " " + 
                    Arrangement.listOfAllArrangements.get(i).getDestination().getCountry() + " - " + 
                    Arrangement.listOfAllArrangements.get(i).getArrangementID());
        }
    }
    
    public static void displayArrangementInfo(int arrangementID) {
    
            for (int i = 0; i < Arrangement.listOfAllArrangements.size(); i++)
                if (arrangementID == Arrangement.listOfAllArrangements.get(i).getArrangementID()) {
        
                    System.out.println("Arrangement ID: " + 
                            Arrangement.listOfAllArrangements.get(i).getArrangementID());
                    System.out.println();
                    System.out.println("----------------------------------------");
                    System.out.println();
                    System.out.println(Arrangement.listOfAllArrangements.get(i).customer.toString());
                    System.out.println();
                    System.out.println("----------------------------------------");
                    System.out.println();
                    System.out.println(Arrangement.listOfAllArrangements.get(i).destination.toString());
                    System.out.println();
                    System.out.println("----------------------------------------");
                    System.out.println();
                    System.out.println(Arrangement.listOfAllArrangements.get(i).transport.toString());
                    System.out.println();
                    System.out.println("----------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println("Price: " + 
                            Arrangement.listOfAllArrangements.get(i).price + " EUR");
                    System.out.println();
                }
                
    }


    //Getters and Setters
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    
     public Destination getDeparture() {
        return departure;
    }

    public void setDeparture(Destination departure) {
        this.departure = departure;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArrangementID() {
        return arrangementID;
    }

    public void setArrangementID(int arrangementID) {
        this.arrangementID = arrangementID;
    }
    
    
    
}
