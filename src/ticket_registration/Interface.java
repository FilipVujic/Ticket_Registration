/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import ticket_registration.customer.Customer;
import ticket_registration.transport.Transport;

/**
 *
 * @author filip
 */
public abstract class Interface {
    
    static int option;
    static Scanner read;
    
    public static void initialMenu(){
    
        read = new Scanner(System.in);
        System.out.println("_______________________________");
        System.out.println("MAIN MENU");
        System.out.println("");
        System.out.println("For customer menu enter 1.");
        System.out.println("For arrangements menu enter 2.");
        System.out.println("For destination menu enter 3.");
        System.out.println("For transport menu enter 4.");
        System.out.println("For file operations menu enter 5.");
        System.out.println("To exit the program, enter 0.");
        System.out.println("");
        
        option = read.nextInt();
        
        switch (option) {
            
            case 1: Interface.customerMenu();
                    break;
            case 2: Interface.arrangementsMenu();
                    break;
            case 3: Interface.destinationMenu();
                    break;
            case 4: Interface.transportMenu();
                    break;
            case 5: Interface.fileOperationsMenu();
                    break;
            case 0: System.exit(0);
                    break;
            default: System.out.println("Please enter the correct option.");
            
        }
        
        Interface.initialMenu();
    }
    

    
    public static void customerMenu () {
    
        read = new Scanner(System.in);
        System.out.println("_______________________________");
        System.out.println("CUSTOMER MENU");
        System.out.println("");
        System.out.println("To create a customer enter 1.");
        System.out.println("To view customer info enter 2.");
        System.out.println("To view all customers enter 3.");
        System.out.println("To go to main menu enter 0.");
        System.out.println("");
        
        option = read.nextInt();
        
        switch (option) {
            
            case 1: {
            
                String tempString;
                int tempInt;
                String nameX;
                String surnameX;
                String dateOfBirthX;
                String addressX;
                int passportNumberX;

                read = new Scanner(System.in);

                System.out.println("Enter customer name: ");
                tempString = read.next();
                nameX = tempString;

                System.out.println("Enter customer surname: ");
                tempString = read.next();
                surnameX = tempString;

                System.out.println("Enter customer date of birth (dd-mm-yyy): ");
                tempString = read.next();
                dateOfBirthX = tempString;

                System.out.println("Enter customer address: ");
                tempString = read.next();
                addressX = tempString;

                System.out.println("Enter customer passport No.: ");
                tempInt = read.nextInt();
                passportNumberX = tempInt;

                try {

                    Customer $customer$$ = new Customer(nameX, surnameX, dateOfBirthX, addressX, passportNumberX);
                } catch (ParseException ex) {
                    System.out.println("Date of birth parsing failed for: " + nameX + " " +
                surnameX);
                }       
            
            };
                    break;
                    
            case 2: {
            
                read = new Scanner(System.in);
                int passportNo;
                System.out.println("Enter customer passport No.:");
                passportNo = read.nextInt();
                
                for (int i = 0; i < Customer.listOfAllCustomers.size(); i++) {
                
                    if (Customer.listOfAllCustomers.get(i).getPassportNumber() == passportNo)
                        System.out.println(Customer.listOfAllCustomers.get(i).toString());
                }
                
            };
                    break;
            
            case 3: Customer.displayCustomerNames();
                    
                    break;
                    
            case 0: Interface.initialMenu();
                    break;
            default: System.out.println("Please enter the correct option.");
            
        }
        Interface.customerMenu();
    }
    
    
    public static void arrangementsMenu() {
    
        read = new Scanner(System.in);
        
        System.out.println("_______________________________");
        System.out.println("ARRANGEMENTS MENU");
        System.out.println("");
        System.out.println("To view all arrangements enter 1.");
        System.out.println("To view a specific arrangement info enter 2.");
        System.out.println("To create an arrangement enter 3.");
        System.out.println("To go to main menu enter 0.");
        System.out.println("");
        
        option = read.nextInt();
        
        switch(option){
            
            case 1: Arrangement.displayAllArangements();
                    break;
            case 2: {
            
                read = new Scanner(System.in);
                
                System.out.println("Enter arrangement ID: ");
                int arrangementID = read.nextInt();
                
                Arrangement.displayArrangementInfo(arrangementID);
                
                
            }
            
            case 3: {
            
                int customerPassportNo;
                String destinationCity;
                String destinationCountry;
                String departureCity;
                String departureCountry;
                int transportID;
                int price;
                int arrangementID;
                
                Customer c1 = null;
                Destination departure = null;
                Destination arrival = null;
                Transport t1 = null;
                
                System.out.println("Enter customer passport No.: ");
                read = new Scanner(System.in);
                customerPassportNo = read.nextInt();
                
                for (int i = 0; i < Customer.listOfAllCustomers.size(); i++) {
                    
                    if (customerPassportNo == Customer.listOfAllCustomers.get(i).getPassportNumber())
                        c1 = Customer.listOfAllCustomers.get(i);
                }
                
                
                System.out.println("Enter destination city: ");
                read = new Scanner(System.in);
                destinationCity = read.next();
                
                System.out.println("Enter destination country: ");
                read = new Scanner(System.in);
                destinationCountry = read.next();
                
                for (int i = 0; i < Destination.listOfAllDestinations.size(); i++) {
                    
                    if ((destinationCity.equals(Destination.listOfAllDestinations.get(i).getCity())) && 
                            (destinationCountry.equals(Destination.listOfAllDestinations.get(i).getCountry())))
                        departure = Destination.listOfAllDestinations.get(i);
                }
                
                
                
                
                System.out.println("Enter departure city: ");
                read = new Scanner(System.in);
                departureCity = read.next();
                
                System.out.println("Enter departure country: ");
                read = new Scanner(System.in);
                departureCountry = read.next();
                
                for (int i = 0; i < Destination.listOfAllDestinations.size(); i++) {
                    
                    if ((departureCity.equals(Destination.listOfAllDestinations.get(i).getCity())) && 
                            (departureCountry.equals(Destination.listOfAllDestinations.get(i).getCountry())))
                        departure = Destination.listOfAllDestinations.get(i);
                }
                
                
                System.out.println("Enter transport ID: ");
                read = new Scanner(System.in);
                transportID = read.nextInt();
                
                for (int i = 0; i < Destination.listOfAllDestinations.size(); i++)
                    if (transportID == Transport.listOfAllTransports.get(i).getTransportID())
                        t1 = Transport.listOfAllTransports.get(i);
                
                
                System.out.println("Enter arrangement price: ");
                read = new Scanner(System.in);
                price = read.nextInt();
                
                
                System.out.println("Enter arrangement ID (6-8 digits): ");
                read = new Scanner(System.in);
                arrangementID = read.nextInt();
                
                Arrangement arrangement$ = new Arrangement();
                c1.makeArangement(arrangement$, departure, departure, t1, price, arrangementID);
                
                
            }
                    break;
            case 0: Interface.initialMenu();
                    break;
            default: System.out.println("Please enter the correct option.");
        }
        
        Interface.arrangementsMenu();
    }
    
    public static void destinationMenu () {
    
        read = new Scanner(System.in);
        
        System.out.println("_______________________________");
        System.out.println("DESTINATION MENU");
        System.out.println("");
        System.out.println("To view all destinations 1.");
        System.out.println("To go to main menu enter 0.");
        System.out.println("");
        
        option = read.nextInt();
        
        switch(option){
            
            case 1: Destination.displayAllDestinations();
                    break;
            case 0: Interface.initialMenu();
                    break;
            default: System.out.println("Please enter the correct option.");
        }
        
        Interface.destinationMenu();
    }
    
    public static void transportMenu () {
    
        read = new Scanner(System.in);
        
        System.out.println("_______________________________");
        System.out.println("TRANSPORT MENU");
        System.out.println("");
        System.out.println("To view all available transport 1.");
        System.out.println("To go to main menu enter 0.");
        System.out.println("");
        
        option = read.nextInt();
        
        switch(option){
            
            case 1: Transport.displayAllTransports();
                    break;
            case 0: Interface.initialMenu();
                    break;
            default: System.out.println("Please enter the correct option.");
        }
        Interface.transportMenu();
    }
    
    public static void fileOperationsMenu () {
    
        read = new Scanner(System.in);
        
        System.out.println("_______________________________");
        System.out.println("FILE OPERATIONS MENU");
        System.out.println("");
        System.out.println("To write all customers of an arrangement to a file enter 1.");
        System.out.println("To write all destinations to a file enter 2.");
        System.out.println("To write a specific arrangement to a file enter 3.");
        System.out.println("To go to main menu enter 0.");
        System.out.println("");
        
        option = read.nextInt();
        
        switch(option){
            
            case 1: {
                
                read = new Scanner(System.in);
                System.out.println("Enter arrangement ID: ");
                int arrangementID = read.nextInt();
                Arrangement a1 = null;
                for (int i = 0; i < Arrangement.listOfAllArrangements.size(); i++)
                    if (arrangementID == Arrangement.listOfAllArrangements.get(i).getArrangementID())
                        a1 = Arrangement.listOfAllArrangements.get(i);
                try {
                    FileManagement.writeAllCustomersOfArrangement(a1);
                } catch (FileNotFoundException ex) {
                    System.out.println("No such arrangement.");
                }
            }
                    break;
            case 2: {
                try {
                    FileManagement.writeAllDestinationsToFile();
                } catch (FileNotFoundException ex) {
                    System.out.println("Error while creating the file!");
                }
            }
            
            case 3: {
            
                read = new Scanner(System.in);
                System.out.println("Enter arrangement ID: ");
                int arrangementID = read.nextInt();
                Arrangement a1 = null;
                for (int i = 0; i < Arrangement.listOfAllArrangements.size(); i++)
                    if (arrangementID == Arrangement.listOfAllArrangements.get(i).getArrangementID())
                        a1 = Arrangement.listOfAllArrangements.get(i);
                try {
                    FileManagement.writeArrangementToFile(a1);
                } catch (FileNotFoundException ex) {
                    System.out.println("No such arrangement.");
                }
            }
                    break;      
            case 0: Interface.initialMenu();
                    break;
            default: System.out.println("Please enter the correct option.");
        }
        
        Interface.fileOperationsMenu();
    }
}
