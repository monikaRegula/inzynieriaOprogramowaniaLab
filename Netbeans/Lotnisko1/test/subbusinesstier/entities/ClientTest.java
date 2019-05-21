/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import static subbusinesstier.entities.FlightTest.data;
import subbusinesstierr.Data;

/**
 *
 * @author asus
 */
@Category({Test_Entity.class})
public class ClientTest {

    static Data data;

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }

    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                if (i == j) {
                    assertTrue(data.clients[i].equals(data.clients[j]));
                } else {
                    assertFalse(data.clients[i].equals(data.clients[j]));
                    j++;
                }
            }
        }
    }

    @Test
    public void testShowPurchaseStatus() {
        System.out.println("showPurchaseStatus");
        boolean status = false;
        Client expected = data.clients[0];
        Ticket ticket = data.tickets[0];
        expected.addPurchase(ticket, data.purchasesData[0]);
        String result = expected.showPurchaseStatus(status);
        assertEquals("NIEOPŁACONY", result);
    }

    /**
     * Test of showRegistrationStatus method, of class Client.
     */
    @Test
    public void testShowRegistrationStatus() {
        System.out.println("showRegistrationStatus");
        boolean status = true;
        Client instance = data.clients[0];
        String expResult = "ZAREJESTROWANY";
        String result = instance.showRegistrationStatus(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of showClientsPurchase method, of class Client.
     */
    @Test
    public void testShowClientsPurchase() {
        System.out.println("showClientsPurchase");
        Purchase purchase = data.purchases[0];
        Client instance = data.clients[0];
        String expResult = "Nr lotu: null\n"
                + "Status zamówienia:OPŁACONY";//nr lotu null ponieważ metoda jest wywoływana
        //z poziomu klienta a nie lotu
        String result = instance.showClientsPurchase(purchase);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPurchase method, of class Client.
     */
    @Test
    public void testAddPurchase() {
        System.out.println("addPurchase");
        Client client = data.clients[0];
        Ticket expected = data.tickets[0];
        client.addPurchase(expected, data.purchasesData[0]);
        assertSame(expected.getSeat(), data.tickets[0].getSeat());
    }

    /**
     * Test of searchPurchase method, of class Client.
     */
    @Test
    public void testSearchPurchase() {
        System.out.println("searchPurchase");
        Client instance = data.clients[0];
        Ticket ticket = data.tickets[0];
        Purchase toFind = data.purchases[0];
        String result = instance.addPurchase(ticket, data.purchasesData[0]);
        String expResult = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchTicket method, of class Client.
     */
    @Test
    public void testSearchTicket() {
        System.out.println("searchTicket");
        Ticket ticket = data.tickets[0];
        Client instance = data.clients[0];
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        Ticket expResult = ticket;
        Ticket result = instance.searchTicket(ticket);
        assertEquals(expResult, result);
    }

    /**
     * Test of removePurchase method, of class Client.
     */
    @Test
    public void testRemovePurchase() {
        System.out.println("removePurchase");
        Purchase toRemove = data.purchases[0];
        Ticket ticket = data.tickets[0];
        Client instance = data.clients[0];
        instance.addPurchase(ticket, data.purchasesData[0]);
        String result = instance.removePurchase(toRemove);
        assertEquals("REMOVED: " +toRemove.toString(), result);
    }
}
