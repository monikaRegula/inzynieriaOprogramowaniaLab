/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.util.ArrayList;
import java.util.Objects;
import subbusinesstierr.Factory;


/**
 *
 * @author asus
 */
public class Client {
    private String name;
    private String lastName;
    private String mail;
    private int flightNumber;
    private boolean registrationStatus;
    private boolean clientPurchaseStatus;
    private ArrayList<Purchase> purchases;
    private ArrayList<Ticket> tickets;
  
    
    public Client() {
        purchases = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public boolean isClientPurchaseStatus() {
        return clientPurchaseStatus;
    }

    public void setClientPurchaseStatus(boolean clientPurchaseStatus) {
        this.clientPurchaseStatus = clientPurchaseStatus;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
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
    final Client other = (Client) obj;
    if (!Objects.equals(this.name, other.name)) {
    return false;
    }
    if (!Objects.equals(this.lastName, other.lastName)) {
    return false;
    }
    if (!Objects.equals(this.mail, other.mail)) {
    return false;
    }
     return true;
    }
    
     @Override
   public String toString(){
       return  "CLIENT: " + getName() + " "+ getLastName()+
               " mail: " + getMail()+" Nr lotu: "+ getFlightNumber()+
               " Status rejestracji:"+showRegistrationStatus(registrationStatus)+
               " Status Zamówienia:"+ showPurchaseStatus(clientPurchaseStatus)
               + "\nCLIENTS PURCHASES: " + purchases.toString()+"\n";
   }
    
   
   public String[] toString_() {
        String[] clientData = new String[5];
        clientData[0] = String.valueOf(getName());
        clientData[1] = String.valueOf(getLastName());
        clientData[2] = String.valueOf(getMail());
        clientData[3] = String.valueOf(getFlightNumber());
        clientData[4] = String.valueOf(isRegistrationStatus());
        clientData[5] = String.valueOf(isClientPurchaseStatus());
        return clientData;
    }
    
     public String showPurchaseStatus(boolean status){
         if(status){
                    return "OPŁACONY";
                }else{
                    return "NIEOPŁACONY";
                }
    }
     
      public String showRegistrationStatus(boolean status){
         if(status){
                    return "ZAREJESTROWANY";
                }else{
                    return "NIEZAREJESTROWANY";
                }
    }
      
      public String showClientsPurchase(Purchase purchase){
          return "Nr lotu: "+purchase.getFlighNumber() +
                  "\nStatus zamówienia:"+showPurchaseStatus(clientPurchaseStatus);
      }
      
      public String addPurchase(Ticket ticket, String[] purchaseData) {
        Factory factory = new Factory();
        ticket.setIsAvailable(false);
        Purchase purchase = factory.createPurchase(purchaseData);
        purchase.setTicket(ticket);
        if ((searchPurchase(purchase)) == null) {
        setClientPurchaseStatus(true);
        purchase.setPurchaseStatus(clientPurchaseStatus);
        purchases.add(purchase);
        ticket.modifyNumberOfSeats();
        tickets.add(ticket);
        return toString(); }
        return "Nie dodano sprzedazy"; }
      
      
//      public String addPurchase(String[] purchaseData){
//          Factory factory = new Factory();
//          Purchase purchase = factory.createPurchase(purchaseData);
//          if((purchase = searchPurchase(purchase)) != null){
//              setClientPurchaseStatus(true);
//              this.purchases.add(purchase);
//              //dodoaj bilet do klienta
//              
//          }
//            return null;
//      }
//      
//   
    public Purchase searchPurchase(Purchase purchase) {
        int idx;
        if ((idx = purchases.indexOf(purchase)) != -1) {
            purchase = purchases.get(idx);
            return purchase ;
        }
        return null;
    }
   
    
    public Ticket searchTicket(Ticket ticket ){
        int idx;
        if ((idx = tickets.indexOf(ticket)) != -1) {
            ticket =tickets.get(idx);
            return ticket;
        }
      return null;
    }

   
    
    }
    

