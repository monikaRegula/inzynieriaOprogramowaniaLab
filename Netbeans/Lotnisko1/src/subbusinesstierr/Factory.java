/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstierr;

import subbusinesstier.entities.Client;
import subbusinesstier.entities.Flight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import javafx.util.converter.LocalDateStringConverter;
import subbusinesstier.entities.Purchase;
import subbusinesstier.entities.Ticket;

/**
 *
 * @author asus
 */
public class Factory {

    public Factory() {
    }
   
    
    public Flight createFlight(String[] table){
        Flight flight = new Flight();
        int day = Integer.parseInt(table[0]);
        int month = Integer.parseInt(table[1]);
        int year = Integer.parseInt(table[2]);
        LocalDate date =  LocalDate.of( year, month,day);
        flight.setDate(date);
        flight.setDestination(table[3]);
        flight.setPlaneNumber(Integer.parseInt(table[4]));
        flight.setNumberOfSeats(Integer.parseInt(table[5]));
        int hour = Integer.parseInt(table[6]);
        int minute = Integer.parseInt(table[7]);
        flight.setHour(LocalTime.of(hour, minute));
       return flight;
    }
    
    public Client createClient(String[] table){
        Client client = new Client();
        client.setName(table[0]);
        client.setLastName(table[1]);
        client.setMail(table[2]);
        //default values for registrationStatus and clientPurchaseStatus
        client.setRegistrationStatus(false);
        client.setClientPurchaseStatus(false);
        return client;
    }
           
    
    
    public Ticket createTicket(Flight flight){
        Ticket ticket = new Ticket();
        double defaultPrice = 200;
        ticket.setFlight(flight);
        ticket.setIsAvailable(true); //default value
        ticket.setPrice(defaultPrice);
        return ticket;
 }
    
          
    public Purchase createPurchase(String[] data){
        Purchase purchase = new Purchase();
        purchase.setPurchaseStatus(Boolean.getBoolean(data[1]));
        return purchase;
 }
   
           
   
}
