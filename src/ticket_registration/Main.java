/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket_registration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import ticket_registration.customer.Customer;
import ticket_registration.customer.VIP_Customer;
import ticket_registration.transport.Airplane;
import ticket_registration.transport.Bus;
import ticket_registration.transport.Train;



/**
 *
 * @author filip
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        // TODO code application logic here
        
        Destination belgrade_serbia = new Destination("Belgrade", "RSD", "Serbia", "Balkans", "Europe");
        Destination berlin_germany = new Destination("Berlin", "EUR", "Germany", "West Europe", "Europe");
        Destination moscow_russia = new Destination("Moscow", "RUB", "Russia", "East Europe", "Europe");
        Destination athens_greece = new Destination("Athens", "EUR", "Greece", "Balkans", "Europe");
        
        Customer filip = new Customer("Filip", "Vujic", "25-03-1994", "Belgrade", 151242);
//        Customer katarina = new Customer("Katarina", "Milosevic", "15-05-1994", "Belgrade", 662623);
//        Customer milos = new Customer("Milos", "Petrovic", "25-02-1992", "Belgrade", 150124);
//        Customer jovana = new Customer("Jovana", "Dimitrijevic", "05-07-1995", "Nis", 515134);
//        Customer danica = new Customer("Danica", "Savic", "30-02-1991", "Belgrade", 724523);
        VIP_Customer teodora_vip = new VIP_Customer("Teodora", "Nikolic", "3-11-1993", "Belgrade", 512356, 0.1, 20);
//        VIP_Customer milena_vip = new VIP_Customer("Milena", "Lukic", "13-11-1992", "Belgrade", 135126, 0, 20);
//        VIP_Customer nemanja_vip = new VIP_Customer("Nemanja", "Nikolic", "13/10/1993", "Novi Sad", 104013, 0.1, 20);

//        Bus miniBus = new Bus(10, belgrade_serbia, berlin_germany, "03-05-2019 10-00", "03-05-2019 10-00", 105930, false, true);
//        Bus miniBus2 = new Bus(10, belgrade_serbia, berlin_germany, "25-06-2019 14-00", "10-07-2019 14-00", 114066, false, true);
//        Bus doubleDecker = new Bus(50, belgrade_serbia, moscow_russia, "3-2-2019 12-30", "11-02-2019 13-30", 592034, true, false);
//        Train fastTrain = new Train(100, belgrade_serbia, athens_greece, "03-05-2019 10-00", "03-05-2019 10-00", 150293, true);
        Airplane plane = new Airplane(300, belgrade_serbia, berlin_germany, "03-05-2019 10-00", "03-05-2019 10-00", 150634, true);
        
        Arrangement a1 = new Arrangement();
//        Arrangement a2 = new Arrangement();
//        Arrangement a3 = new Arrangement();
//        Arrangement a4 = new Arrangement();
//        Arrangement a5 = new Arrangement();
//        Arrangement a6 = new Arrangement();
        Arrangement a7 = new Arrangement();
//        Arrangement a8 = new Arrangement();
        
        filip.makeArangement(a1, belgrade_serbia, berlin_germany, plane, 300, 948172);
//        katarina.makeArangement(a2, belgrade_serbia, berlin_germany, plane, 300, 162643);
//        milos.makeArangement(a3, belgrade_serbia, berlin_germany, miniBus, 250, 256323);
//        jovana.makeArangement(a4, belgrade_serbia, berlin_germany, miniBus2, 200, 412452);
//        danica.makeArangement(a5, belgrade_serbia, athens_greece, fastTrain, 300, 725234);
        teodora_vip.makeArangement(a7, belgrade_serbia, moscow_russia, plane, 100, 623451);
//        milena_vip.makeArangement(a6, belgrade_serbia, moscow_russia, plane, 300, 722435);
//        nemanja_vip.makeArangement(a8, belgrade_serbia, moscow_russia, fastTrain, 300, 195920);
        
//        FileManagement.writeAllCustomersOfArrangement(a1);
    
//        FileManagement.writeAllDestinationsToFile();
     
//        FileManagement.writeArrangementToFile(a1);
//        FileManagement.writeArrangementToFile(a2);
//        FileManagement.writeArrangementToFile(a3);
//        FileManagement.writeArrangementToFile(a4);
//        FileManagement.writeArrangementToFile(a5);
//        FileManagement.writeArrangementToFile(a6);
//        FileManagement.writeArrangementToFile(a7);
//        FileManagement.writeArrangementToFile(a8);

        FileManagement.createCustomersFromFile();
        FileManagement.createDestinationsFromFile();
        

        Interface.initialMenu();

        
        
        
        
        
        
        
        
        
        
    }
    
}
