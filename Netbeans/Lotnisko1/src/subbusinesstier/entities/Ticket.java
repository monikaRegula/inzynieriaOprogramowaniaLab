/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author asus
 */
public class Ticket extends Flight{
   private String seat;
   private double price;
   private boolean isAvailable;
   private Client client;
   private Flight flight;
   private int numberTest;

    public Ticket() {
    }


    public Ticket(int numberTest,Flight flight) {
        this.price = 200;
        this.flight = flight;
        this.isAvailable= (true); //default value
       this.numberTest = numberTest;
       this.client = client;
      
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
        return   "Ticket{" + "seat=" + seat + ", price=" + price + ", isAvailable=" + isAvailable + ", flight=" + flight.toString() + '}';
    }
    
   @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        return true;
        }
        if (obj == null) {
        return false;
        }
        if (getClass() != obj.getClass()) {
        return false;
        }
        final Ticket other = (Ticket) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
        return false;
        }
        if (this.isAvailable != other.isAvailable) {
        return false;
        }
         if (!Objects.equals(this.seat, other.seat)) {
        return false;
        }
         if (!Objects.equals(this.flight, other.flight)) {
        return false;
        }
        return true;
    }

 
    public void modifyNumberOfSeats() { 
        flight.modifyNumberOfSeats(); }
 
}
