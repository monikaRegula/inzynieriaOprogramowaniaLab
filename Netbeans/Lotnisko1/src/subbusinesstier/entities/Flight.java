/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subbusinesstierr.Factory;

/**
 *
 * @author asus
 */
public class Flight {
    private LocalDate date;
    private LocalTime hour;
    private int planeNumber;
    private String destination;
    private int numberOfSeats;
    private ArrayList<Ticket> tickets;

   
    public Flight() {
        tickets = new ArrayList<>();
    }
    

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public int getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(int planeNumber) {
        this.planeNumber = planeNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
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
    final Flight other = (Flight) obj;
        if (this.planeNumber != other.planeNumber) {
        return false;
        }
    if (!Objects.equals(this.destination, other.destination)) {
        return false;
    }
    if (!Objects.equals(this.date, other.date)) {
        return false;
    }
    if (!Objects.equals(this.hour, other.hour)) {
        return false;
    }
    if(!Objects.equals(this.numberOfSeats,other.numberOfSeats)){
            return true;
        }
        return true;
    }
  
      
    @Override
    public String toString(){
        String result = "FLIGHT: Lot: " + getDate();
        result += " Godzina: " + getHour();
        result += " Destynacja: "+getDestination();
        result += " Liczba miejsc: " + getNumberOfSeats();
        result += " Nr samolotu: "+getPlaneNumber();
        return result+ "\n"; 
    }
    
   public String[] toString_() {
        String[] flightData = new String[5];
        flightData[0] = String.valueOf(getDate());
        flightData[1] = String.valueOf(getHour());
        flightData[2] = String.valueOf(getDestination());
        flightData[3] = String.valueOf(getNumberOfSeats());
        flightData[4] = String.valueOf(getPlaneNumber());
        return flightData;
    }
  
    
    public void addTickets(){
        Factory f = new Factory();
        for (int i = 1;i<this.getNumberOfSeats()+1;i++){
        Ticket ticket = f.createTicket(this); //kazdy nowy bilet, utworzony przez fabryke zna swój lot
        ticket.setSeat("A"+String.valueOf(i));
        tickets.add(ticket);
        }
 
        }
     public Ticket searchTicket(Ticket ticket){
       int idx;
        if ((idx = tickets.indexOf(ticket)) != -1) {
            ticket = tickets.get(idx);
            return ticket;
        }
        return null;
    }
   
     public String modelTickets(){   
        return tickets.toString(); }
     
     
     public String addPurchase(Client client, String [] purchaseData) {
        Factory factory = new Factory();
        Ticket ticket = factory.createTicket(this), existTicket;
        ticket.setSeat(purchaseData[1]);
        if((existTicket=this.searchTicket(ticket))!=null){
          return client.addPurchase(existTicket,purchaseData);
        }
        return "Brak wolnego biletu";
     }
     
    public void printAvilableTickets(){
            Flight flight = this;
           flight.getTickets().stream()
           .filter(a-> a.isIsAvailable() == true)
           .forEach(System.out::println);         
    }


    public void printAllTickets(Flight flight){
           flight.getTickets().stream().
           forEach(System.out::println);
           System.out.println(flight.tickets.toString());
    }


    public void modifyNumberOfSeats()
    { --this.numberOfSeats; }
     
    
}
