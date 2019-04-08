/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

/**
 *
 * @author asus
 */
public class Purchase {
    private String flighNumber;
    private boolean purchaseStatus;
    
    
    public Purchase() {
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

    
    public String toString(){
        return   "PURCHASE: Nr lotu: "+getFlighNumber() 
                + "Status zamówienia:"+   String.valueOf(isPurchaseStatus());
                }
}
