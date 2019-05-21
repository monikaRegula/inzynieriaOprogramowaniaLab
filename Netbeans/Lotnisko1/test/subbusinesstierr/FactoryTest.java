/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstierr;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.Flight;
import subbusinesstier.entities.Purchase;
import subbusinesstier.entities.Ticket;

/**
 *
 * @author asus
 */
public class FactoryTest {

    static Data data;

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }

    /**
     * Test of createFlight method, of class Factory.
     */
    @Test
    public void testCreateFlight() {
        System.out.println("createFlight");
        //given
        Factory instance = new Factory();
        Flight expResult = data.flights[0];
        //when
        Flight result = instance.createFlight(data.flightsData[0]);
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of createClient method, of class Factory.
     */
    @Test
    public void testCreateClient() {
        System.out.println("createClient");
        //given
        Factory instance = new Factory();
        Client expResult = data.clients[1];
        //when
        Client result = instance.createClient(data.clientsData[1]);
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of createTicket method, of class Factory.
     */
    @Test
    public void testCreateTicket() {
        System.out.println("createTicket");
        Flight flight = data.flights[0];
        Factory instance = new Factory();
        Ticket expResult = data.tickets[0];
        Ticket result = instance.createTicket(flight);
        assertEquals(expResult, result);
    }

    /**
     * Test of createPurchase method, of class Factory.
     */
    @Test
    public void testCreatePurchase() {
        System.out.println("createPurchase");
        Factory instance = new Factory();
        for (int i = 0; i < 4; i++) {
            Purchase expResult = data.purchases[i] ;
            Purchase result = instance.createPurchase(data.purchasesData[i]);
            assertEquals(expResult, result);
        }
    }

}
