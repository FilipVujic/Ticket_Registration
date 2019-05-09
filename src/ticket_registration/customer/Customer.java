/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import ticket_registration.Arrangement;
import ticket_registration.Destination;
import ticket_registration.transport.Transport;


/**
 *
 * @author filip
 */
public class Customer {
    
    
    //Attributes
    
    String name;
    String surname;
    Date dateOfBirth;
    String address;
    int passportNumber;
    public static LinkedList<Customer> listOfAllCustomers = new LinkedList<>();

    
    //Constructor
    
    public Customer(String name, String surname, String dateOfBirth, String address, int passportNumber) throws ParseException {
        
        SimpleDateFormat dateOfBirth1 = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try{
        date = dateOfBirth1.parse(dateOfBirth);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        }
        catch(Exception e){System.out.println("Date of birth parsing failed for: " + name + " " +
                surname);}
        
        
        if (passportNumber < 100000 || passportNumber > 99999999) {
            
            System.out.println("Please enter passport number between 6-8 characters!");
            System.exit(1);
        }
        
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = date;
        this.address = address;
        this.passportNumber = passportNumber;
        
        listOfAllCustomers.add(this);
    }
    
   
    
    //Methods
    
    public void makeArangement(Arrangement a1, Destination departure, Destination destination, Transport transport, int price, int arrangementID) {
        
        if (arrangementID < 1000 || arrangementID > 99999999) {
        
            System.out.println("Please enter ID between 4-8 characters.");
            System.exit(1);
        }
        
        a1.customer = this;
        a1.destination = destination;
        a1.departure = departure;
        a1.transport = transport;
        a1.price = price;
        a1.arrangementID = arrangementID;
        
        Arrangement.listOfAllArrangements.add(a1);
    }

    
    //ToString and Display
    
    @Override
    public String toString() {
        return "Customer info" + "\n" + "\n" + "Name: " + name + " " + surname + "\n" + "Date Of Birth: " + dateOfBirth + "\n" + "Address: " + address + 
                "\n" + "Passport Number: " + passportNumber + "\n";
    }

    
    
    public static void displayCustomerNames() {
        
            for (int i = 0; i < Customer.listOfAllCustomers.size(); i++) {
                
                    System.out.println(Customer.listOfAllCustomers.get(i).getName() + " " + 
                            Customer.listOfAllCustomers.get(i).getSurname() + " - " +
                            Customer.listOfAllCustomers.get(i).getPassportNumber() + "\n");
                    
                }
            
        }
    

    //Getters and Setters
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
    
    
    
}
