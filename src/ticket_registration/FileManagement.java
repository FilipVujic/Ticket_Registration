/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import static ticket_registration.Arrangement.listOfAllArrangements;
import ticket_registration.customer.Customer;
import ticket_registration.customer.VIP_Customer;



/**
 *
 * @author filip
 */
public abstract class FileManagement {
    
    
    //Attributes
    
    static java.io.PrintWriter output;

    //Methods
    
    public static void writeAllDestinationsToFile() throws FileNotFoundException {
        
        int counter = 0;
        java.io.File listOfAllDestinations = new java.io.File("List of all destinations.txt");
        
        while(listOfAllDestinations.exists() == true) {
            
            counter++;
            if (counter == 1) {
            listOfAllDestinations = new java.io.File(listOfAllDestinations.toString().substring(0, (listOfAllDestinations.toString().length() - 4))
            + "(" + counter +")" + ".txt");
            } else if (counter == 10) {
                
                System.out.println("File already exists!");
                System.exit(1);
            } 
            
            else {
            
                listOfAllDestinations = new java.io.File(listOfAllDestinations.toString().substring(0, (listOfAllDestinations.toString().length() - 7))
            + "(" + counter +")" + ".txt");
            }
            
        }
            output = new java.io.PrintWriter(listOfAllDestinations);
            output.println("All available destinations: " + "\n" + "\n");
        
        for (int i = 0; i < Destination.listOfAllDestinations.size(); i++){
            
            output.print(Destination.listOfAllDestinations.get(i).getCity() + ", " + Destination.listOfAllDestinations.get(i).getCountry() + ", " + 
                    Destination.listOfAllDestinations.get(i).getCurrency() + ", " + 
                    Destination.listOfAllDestinations.get(i).getRegion() + ", " + Destination.listOfAllDestinations.get(i).getContinent());
            output.println();
        }
        output.close();
    }
    
    
    
    
    public static void writeArrangementToFile(Arrangement arrangement) throws FileNotFoundException {
        
        int counter = 0;
        String arrName = (arrangement.customer.getName() + "_" + arrangement.customer.getSurname() + " - " + 
                arrangement.destination.city + "_" + arrangement.destination.country + " - " + arrangement.arrangementID);
        java.io.File arrangementName = new java.io.File(arrName + ".txt");
        
        while(arrangementName.exists() == true) {
            
            counter++;
            if (counter == 1) {
            arrangementName = new java.io.File(arrangementName.toString().substring(0, (arrangementName.toString().length() - 4))
            + "(" + counter +")" + ".txt");
            } else if (counter == 10) {
                
                System.out.println("File already exists!");
                System.exit(1);
            } 
            
            else {
            
                arrangementName = new java.io.File(arrangementName.toString().substring(0, (arrangementName.toString().length() - 7))
            + "(" + counter +")" + ".txt");
            }
        }
            output = new java.io.PrintWriter(arrangementName);
            
            output.println("Arrangement ID: " + arrangement.getArrangementID());
            output.println();
            output.println("----------------------------------------");
            output.println();
            output.println(arrangement.customer.toString());
            output.println();
            output.println("----------------------------------------");
            output.println();
            output.println(arrangement.destination.toString());
            output.println();
            output.println("----------------------------------------");
            output.println();
            output.println(arrangement.transport.toString());
            output.println();
            output.println("----------------------------------------");
            output.println();
            output.println();
            output.println("Price: " + arrangement.price + " EUR");
            output.println();
            
            output.close();
    }
    
    
    public static void writeAllCustomersOfArrangement(Arrangement a1) throws FileNotFoundException {
        
        
        int counter = 0;
        String arrName = (a1.getDestination().getCity() + " - " + a1.getDestination().getCountry() + " - Passingers");
        java.io.File arrangementName = new java.io.File(arrName + ".txt");
        
        while(arrangementName.exists() == true) {
            
            counter++;
            if (counter == 1) {
            arrangementName = new java.io.File(arrangementName.toString().substring(0, (arrangementName.toString().length() - 4))
            + "(" + counter +")" + ".txt");
            } else if (counter == 10) {
                
                System.out.println("File already exists!");
                System.exit(1);
            } 
            
            else {
            
                arrangementName = new java.io.File(arrangementName.toString().substring(0, (arrangementName.toString().length() - 7))
            + "(" + counter +")" + ".txt");
            }
        
        }
        
        output = new java.io.PrintWriter(arrangementName);
        output.println(a1.getDestination().getCity() + " - " + a1.getDestination().getCountry() + 
                " - List of all passengers: " + "\n" + "\n");

        
        for (int i = 0; i < listOfAllArrangements.size(); i++){
        
            if (a1.getDestination().getCity().equalsIgnoreCase(listOfAllArrangements.get(i).getDestination().getCity())
                    && (a1.getDeparture().getCity().equals(listOfAllArrangements.get(i).getDeparture().getCity()) &&
                            (a1.getTransport().getTimeOfDeparture().equals(listOfAllArrangements.get(i).getTransport().getTimeOfDeparture())))
                    && (a1.getTransport().getTimeOfArrival().equals(listOfAllArrangements.get(i).getTransport().getTimeOfArrival())) ){
                

                output.println(listOfAllArrangements.get(i).getCustomer().getName() + " " +
                        listOfAllArrangements.get(i).getCustomer().getSurname() + "\n" + "Passport No.: " + 
                        listOfAllArrangements.get(i).getCustomer().getPassportNumber()+ "\n");
            }
        }
        
        output.close();
    }
    
    public static void createCustomersFromFile() throws FileNotFoundException, IOException, ParseException {
    
        String name;
        String surname;
        String dateOfBirth;
        String address;
        int passportNumber;
        double discount = 0;
        int voucher = 0;
        int vip = 0;
        
        BufferedReader reader = new BufferedReader(new FileReader("customers.txt"));
        
        String line = null;
        
        do {
            
            line = reader.readLine();
            
            if (line != null) {
            
                System.out.println(line);
                try (Scanner scan = new Scanner(line)) {
                
                    scan.useDelimiter(", ");
                    do  {
                        name = scan.next();
                        surname = scan.next();
                        dateOfBirth = scan.next();
                        address = scan.next();
                        passportNumber = scan.nextInt();
                        if (scan.hasNextDouble()) {
                        discount = scan.nextDouble();
                        if (scan.hasNextInt())
                        voucher = scan.nextInt();
                        vip = 1;
                        }
                        
                        switch(vip) {
                            case 1: VIP_Customer vip_customer$ = new VIP_Customer(name, surname, dateOfBirth, address, passportNumber, discount, voucher);
                                    vip = 0;
                                break;
                            case 0: Customer customer$ = new Customer(name, surname, dateOfBirth, address, (int)passportNumber);
                        } 
                        

                        

                    } while(scan.hasNext());
        
                }
            }
            
        } while ( line != null);
    }
    
    public static void createDestinationsFromFile() throws FileNotFoundException, IOException, ParseException {
    
        String city;
        String currency;
        String country;
        String region;
        String continent;
        
        BufferedReader reader = new BufferedReader(new FileReader("destinations.txt"));
        
        String line = null;
        
        do {
            
            line = reader.readLine();
            
            if (line != null) {
            
                try (Scanner scan = new Scanner(line)) {
                
                    scan.useDelimiter(", ");
                    do  {
                        city = scan.next();
                        currency = scan.next();
                        country = scan.next();
                        region = scan.next();
                        continent = scan.next();

                        Destination destination$ = new Destination(city, currency, country, region, continent);

                    } while(scan.hasNext());
        
                }
            }
            
        } while ( line != null);
    }
    
}
