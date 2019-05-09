/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration.customer;

import java.text.ParseException;
import ticket_registration.Arrangement;
import ticket_registration.Destination;
import ticket_registration.transport.Transport;


/**
 *
 * @author filip
 */
public class VIP_Customer extends Customer {
    
    
    //Attributes
    
    double discount;
    int voucher;

    
    //Constructor
    
    public VIP_Customer(String name, String surname, String dateOfBirth, String address, int passportNumber, double discount, int voucher) throws ParseException {
        super(name, surname, dateOfBirth, address, passportNumber);
        
        if (discount >= 1) {
        
            System.out.println("Discount must be between 0.1 - 0.9!");
            System.exit(1);
        }
        
        this.discount = discount;
        this.voucher = voucher;
    }

    
    //Methods
   
    @Override
    public void makeArangement(Arrangement a1, Destination departure, Destination destination, Transport transport, int price, int arrangementID) {
        
        if (arrangementID < 1000 || arrangementID > 99999999) {
        
            System.out.println("Please enter ID between 4-8 characters.");
            System.exit(1);
        }
        
        a1.customer = this;
        a1.destination = destination;
        a1.departure = departure;
        a1.transport = transport;
        a1.price = (int)Math.round((price-voucher)*(1-this.discount));
        a1.arrangementID = arrangementID;
        
        Arrangement.listOfAllArrangements.add(a1);
    }
    
    
    //ToString
    
    @Override
    public String toString() {
        
        String temp;   
        temp = super.toString() + "\n" + "Discount: " + Math.round(discount*100) + "%" + "\n" + "Voucher: " + voucher + " EUR" + "\n";

        return temp;
    }

    
    //Getters and Setters
    
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }
    
    
}
