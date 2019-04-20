/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstierr;

import java.time.LocalTime;
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
    
      
    public String addFlightToList(String[] data) {
        Factory factory = new Factory();
        Flight flight = factory.createFlight(data);
        if (searchFlight(flight) == null) {
        this.flights.add(flight);
        flight.addTickets();
        return flight.toString();
        }
        return "Nie wstawiono lotu";
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
    
    public String searchAvailableTicketsForFlight(String[] data) {
        Factory factory = new Factory();
        Flight help = factory.createFlight(data), existflight;
        if ((existflight = searchFlight(help)) != null) {
        return existflight.modelTickets(); }
        return "Brak lotu";
    }

    
    public String addPurchase(String[] flightData, String[] clientData, String[] purchaseData) {
        Factory factory = new Factory();
        Flight flight = factory.createFlight(flightData), existFlight;
        Client client = factory.createClient(clientData), existClient;
        if ((existClient = searchClient(client)) != null) {
        if ((existFlight = searchFlight(flight)) != null) {
        return existFlight.addPurchase(existClient, purchaseData);
        }
        return "No such flight";
        }
        return "No such client";
        }

    //Modyfikować można liczbę dostępnych miejsc ale wtedy problem przy addTickets bo to w pętli 
    //generuje bilety i zapomina o tych starych biletach przed modyfikacją
      public String modifyFlight(String[] oldFlight, String[] newFlight) {
        Factory factory = new Factory();
        Flight toChange = factory.createFlight(oldFlight), exist;
        if (!this.flights.remove(toChange)) // szuka i usuwa, jesli znajdzie!!!
        {
        return "Brak modfyfikowanego lotu";
        }
        return this.addFlightToList(newFlight); //dodaje nowy lot, czyli sprawdza, czy to nowy lot i
        // dodaje, jesli jest nowy po zmianach
        }
       
      
       
        public String changePurchaseStatus(String[] flightData, String[] clientData, String[] purchaseData){
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
         return client.toString();
        
    }
 

    public String registerClient(String[] data) {
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        if (searchClient(client) == null) {
        this.clients.add(client);
        return client.toString();
        } else {
        return "Klient już istnieje w bazie!!!";
        }
    }
    

     public static void main(String[] args) {
       Facade facade = new Facade();

 String[] exampleClient1 = {"Monika", "Reguła", "monikaregula@gmail.com"};
 String[] exampleClient2 = {"Katarzyna", "Jurkowska", "katarzynajurkowska@gmail.com"};
 System.out.println("Creating new client .....");
 System.out.println(facade.registerClient(exampleClient1));
 System.out.println("Creating new client .....");
 System.out.println(facade.registerClient(exampleClient2));
 System.out.println("Creating existing client .....");
 System.out.println(facade.registerClient(exampleClient1));
 System.out.println("\nKlienci .....");
 System.out.println(facade.printClients());

 //nowe loty
 String[] exampleFlight1 = {"2", "4", "2019", "Frankfurt", "144", "5", "19", "45"};
 String[] exampleFlight2 = {"8", "4", "2019", "Frankfurt", "144", "5", "19", "45"};
 System.out.println("Creating new flight .....");
 System.out.println(facade.addFlightToList(exampleFlight1));
 System.out.println("Creating new flight .....");
 System.out.println(facade.addFlightToList(exampleFlight2));
 System.out.println("Creating existing flight .....");
 System.out.println(facade.addFlightToList(exampleFlight1));
 //pokazuj wszytskie dostępne loty:
 System.out.println("\nLoty .....");
 System.out.println(facade.printFligths());
 
 
 //wyszukiwanie dostępnych biletów dla konkretnego lotu
 System.out.println("\n Available Tickets for flight1.....");
 System.out.println(facade.searchAvailableTicketsForFlight(exampleFlight1));
 System.out.println("\n Available Tickets for flight2.....");
 System.out.println(facade.searchAvailableTicketsForFlight(exampleFlight2));
 
 String[] examplePurchase1 = {"144", "A1"};
 String[] examplePurchase2 = {"144", "A2"};
 String[] examplePurchase3 = {"144", "A3"};
 String[] examplePurchase4 = {"144", "A4"};
 String[] examplePurchase5 = {"144", "A5"};
 String[] examplePurchase6 = {"144", "A5"};
 //dodaje zamówienie klienta:
 System.out.println("dodaj zamówienie: " + facade.addPurchase(exampleFlight1, exampleClient1, examplePurchase1));
 System.out.println("dodaj zamówienie: " + facade.addPurchase(exampleFlight1, exampleClient1, examplePurchase2));
 System.out.println("dodaj zamówienie: " + facade.addPurchase(exampleFlight1, exampleClient1, examplePurchase3));
 System.out.println("dodaj zamówienie: " + facade.addPurchase(exampleFlight1, exampleClient1, examplePurchase4));
 System.out.println("dodaj zamówienie: " + facade.addPurchase(exampleFlight1, exampleClient1, examplePurchase5));
 System.out.println("dodaj zamówienie: " + facade.addPurchase(exampleFlight1, exampleClient1, examplePurchase6));

 System.out.println("\n No available Tickets for flight1.....");
 System.out.println(facade.searchAvailableTicketsForFlight(exampleFlight1));
 System.out.println("\n Available Tickets for flight2.....");
 System.out.println(facade.searchAvailableTicketsForFlight(exampleFlight2));
 System.out.println("\n State of flights.....");
 System.out.println(facade.printFligths()); 
 System.out.println("\n State of flights.....");
 System.out.println(facade.printFligths());
 
System.out.println("\n State of flights.....");
System.out.println(facade.printFligths());
 //modyfikuj lot
 String[] exampleFlight3 = {"2", "4", "2019", "Frankfurt", "144", "5", "21", "30"};
 System.out.println("\n State of flights after modification.....");
 facade.modifyFlight(exampleFlight1, exampleFlight1);
 System.out.println(facade.printFligths());
 System.out.println(facade.searchAvailableTicketsForFlight(exampleFlight1));

    } 
}
