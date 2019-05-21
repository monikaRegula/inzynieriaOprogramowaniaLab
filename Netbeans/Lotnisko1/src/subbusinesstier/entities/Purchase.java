
package subbusinesstier.entities;

import java.util.Objects;


public class Purchase {
    private String flighNumber;
    private boolean purchaseStatus;
    private Ticket ticket;
    private int numberTest;
    
    public Purchase() {
    }


    public Purchase(int numberTest,String[] dataPurchase) {
        this.numberTest = numberTest;
        this.purchaseStatus=(Boolean.getBoolean(dataPurchase[1]));
       
    }

    
    public String getFlighNumber() {
        return flighNumber;
    }

    public void setFlighNumber(String flighNumber) {
        this.flighNumber = flighNumber;
    }

    public boolean isPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(boolean purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
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
        final Purchase other = (Purchase) obj;
        if (this.purchaseStatus != other.purchaseStatus) {
        return false;
        }
        if (!Objects.equals(this.ticket, other.ticket)) {
        return false;
        }
        return true;
        }
 
 
 public String toString() {
 return "PURCHASE: Nr lotu: " + getTicket() + " Status zamówienia:" + String.valueOf(isPurchaseStatus());
 }
   
}
