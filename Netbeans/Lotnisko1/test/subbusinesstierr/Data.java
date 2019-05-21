/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstierr;

import subbusinesstier.entities.Client;
import subbusinesstier.entities.Flight;
import subbusinesstier.entities.Purchase;
import subbusinesstier.entities.Ticket;


public class Data {

       //nowi klienci
 public String[] exampleClient1 = {"Monika", "Reguła", "monikaregula@gmail.com"};
 public String[] exampleClient2 = {"Katarzyna", "Jurkowska", "katarzynajurkowska@gmail.com"};
    //nowe loty
 String[] exampleFlight1 = {"2", "4", "2019", "Frankfurt", "144", "5", "19", "45"};
 String[] exampleFlight2 = {"8", "4", "2019", "Frankfurt", "144", "5", "19", "45"};
 
 //nowe zamówienia
 public String[] examplePurchase1 = {"144", "A1"};
 String[] examplePurchase2 = {"144", "A2"};
 String[] examplePurchase3 = {"144", "A3"};
 String[] examplePurchase4 = {"144", "A4"};
 String[] examplePurchase5 = {"144", "A5"};
 String[] examplePurchase6 = {"144", "A5"};
 
 //modyfikuj lot
 String[] exampleFlight3 = {"2", "4", "2019", "Frankfurt", "144", "5", "21", "30"};
 
 
 public String purchasesData[][] = {examplePurchase1,examplePurchase2,examplePurchase3,examplePurchase4,examplePurchase5,examplePurchase6};
 
 public String clientsData[][] = { exampleClient1,exampleClient2};

 public String flightsData[][] = { exampleFlight1,exampleFlight2};
 
public Client[] clients = {new Client(0, exampleClient1),new Client(1,exampleClient2)};

public Flight[] flights = {new Flight(0, exampleFlight1),
                           new Flight(1, exampleFlight2)};

public Ticket[] tickets= {new Ticket(0, flights[0]), new Ticket(1, flights[1])};

public Purchase[] purchases = {new Purchase(0, examplePurchase1),
                               new Purchase(1, examplePurchase2),
                               new Purchase(2, examplePurchase3),
                               new Purchase(3, examplePurchase4),
                               new Purchase(4, examplePurchase5),
                               new Purchase(5, examplePurchase6)};



}
