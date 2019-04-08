/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstierr;

import subbusinesstier.entities.Flight;
import subbusinesstier.entities.Ticket;
import java.util.ArrayList;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.Purchase;

/**
 *
 * @author asus
 */
public class Facade {
    ArrayList<Flight> flights;
    ArrayList<Client> clients;
   
    public Facade() {
        flights = new ArrayList<>();
        clients = new ArrayList<>();
    }
    
   
    public String addFlightToList(String[] data){
        System.out.println("Creating new flight .....");
        Factory factory = new Factory();
        Flight flight = factory.createFlight(data);
      if(searchFlight(flight) == null){
           this.flights.add(flight);
        //default value for ticket is 200
           flight.addTickets();
       }
       return flight.toString();
    }
   
    
    public Flight searchFlight(Flight flight){
   int idx;
        if ((idx = flights.indexOf(flight)) != -1) {
           flight = flights.get(idx);
            return flight;
        }
        return null;
    }
    
    public Object[][] getFlights() {
        Object[][] flightsList = new Object[flights.size()][];
        int i = 0;
        for (Flight next : flights) {
            flightsList[i++] = next.toString_();
        }
        return flightsList;
    }
     
    public String printFligths() {
        String help = "";
        for (Flight f : flights) {
           String help_list = f.toString();
                help += help_list;   
        }
        return help;
       
    }
     
    
     public String printClients() {
        String help = "";
        for (Client c :clients) {
           String help_list = c.toString();
                help += help_list;   
        }
        return help;
       
    }
  
    public String addClientToList(String[] data){
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        System.out.println("Creating new client .....");
        if(searchClient(client) == null){
           this.clients.add(client);
        }
        return client.toString();
    }
   
    
 
    public Client searchClient(Client client){
       int idx;
        if ((idx = clients.indexOf(client)) != -1) {
            client = clients.get(idx);
            return client;
        }
        return null;
    }
     
  
    public Client changeRegistrationStatus(String[] data){
         Factory factory = new Factory();
        Client client = factory.createClient(data);
        if(searchClient(client) != null){
            client.setRegistrationStatus(true);
            return client;
        }
        return null;
    }
    
    
    
    public void searchAvailableTicketsForFlight(String[] data){
        Factory factory = new Factory();
        Flight help = factory.createFlight(data);
        if(searchFlight(help)!= null){
            help.printAvilableTickets();
        }
    }
    
    
    public String addPurchase(String [] flightData, String[] ticketData, String[] clientData,String[] purchaseData){
        Factory factory = new Factory();
        Flight flight = factory.createFlight(flightData),existFlight;
        Ticket ticket = factory.createTicket(flight),existTicket;
        Client client = factory.createClient(clientData),existClient;
        
        if((existFlight = searchFlight(flight))!= null){
            if((existTicket = existFlight.searchTicket(ticket))!= null){
                if((existClient = searchClient(client))!= null){
                    client.addPurchase(purchaseData);
                    //czy jak ustawie dla bieltu klienta to 
                    //klasa klient widzi ten bilet???
                    if((existTicket = client.searchTicket(ticket)) != null){
                     existTicket.setClient(client);
                };
                   
                }
        }
        return client.toString();
          }
        return null;
    }
    
    
        public void changePurchaseStatus(String[] flightData, String[] clientData, String[] purchaseData){
         Factory f = new Factory();
         Client client = f.createClient(clientData),existClient;
         Purchase purchase = f.createPurchase(purchaseData),existPurchase;
         Flight flight = f.createFlight(flightData);
         Ticket create = f.createTicket(flight);
         if((existPurchase = client.searchPurchase(purchase))!= null){
             if(client.isClientPurchaseStatus() == true){
                 existPurchase.setPurchaseStatus(true);
             }else{
                 //zmien bilet klienta isAvailable na true
                Ticket change = client.searchTicket(create);
                 change.setIsAvailable(true);
                 //usuń zamowienie
                 client.getPurchases().remove(purchase);
             }
         }
        
    }
    
    
     public static void main(String[] args) {
        Facade facade = new Facade();
        //creating client
        String [] exampleClient = {"Monika","Reguła","monikaregula@gmail.com"};
        facade.addClientToList(exampleClient);
        System.out.println(facade.printClients());
        //creating flight
        String[] exampleFlight = {"2","4","2019","Frankfurt","144","5","19","45"};
        facade.addFlightToList(exampleFlight);
       
        System.out.println(facade.printFligths());;
        //printing all available tickets:
         facade.searchAvailableTicketsForFlight(exampleFlight);
         //nie pokazuje biletów!!!! dlaczego ich nie widzi fasada
         
        
     
        
     
    }
     
}
