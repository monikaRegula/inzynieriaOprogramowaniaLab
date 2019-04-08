/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author asus
 */
public class Ticket extends Flight{
   private String seat;
   private double price;
   private boolean isAvailable;
   private String flightNumber;
   private Client client;
   private Flight flight;

    public Ticket() {
    }
   

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
   
    @Override
         public String toString(){
        return "TICKET: Seat: "+ seat+ " flightNumber: "+flightNumber
                + "client: "+ client.getName() + client.getLastName();
    }
    
}
