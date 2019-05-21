package subbusinesstierr;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.Flight;

/**
 *
 * @author asus
 */
@Category({Test_Control.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FacadeTest {

    static Data data;
    static Facade instance;

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
        instance = new Facade();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testSearchFlight() {
        System.out.println("searchFlight");
        Flight toFind = data.flights[0];
        instance.addFlightToList(data.exampleFlight1);
        Flight result = instance.searchFlight(toFind);
        assertEquals(toFind, result);
    }

    /**
     * Test of printClients method, of class Facade.
     */
    @Test
    public void testPrintClients() {
        System.out.println("printClients");
        Facade instance = new Facade();
        Client toAdd = data.clients[0];
        instance.registerClient(data.exampleClient1);
        String expResult = toAdd.toString();
        String result = instance.printClients();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchClient method, of class Facade.
     */
    @Test
    public void testSearchClient() {
        System.out.println("searchClient");
        Client toFind = data.clients[1];
        Facade instance = new Facade();
        instance.registerClient(data.clientsData[1]);
        Client result = instance.searchClient(toFind);
        assertEquals(toFind, result);
    }

    /**
     * Test of addPurchase method, of class Facade.
     */
    @Test
    @Category({Test_Purchase.class})
    public void testAddPurchase() {
        System.out.println("addPurchase");
        String[] flightData = data.flightsData[0];
        String[] clientData = data.clientsData[0];
        String[] purchaseData = data.purchasesData[0];
        instance.registerClient(clientData);
        instance.addFlightToList(flightData);
        //2 poprzednie kroki muszą być żeby można było złożyć zamówienie!!!
        Client toFind = data.clients[0];
        Client founded = instance.searchClient(toFind);
        String result = instance.addPurchase(flightData, clientData, purchaseData);
        String expResult = founded.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerClient method, of class Facade.
     */
    @Test
    public void testRegisterClient() {
        System.out.println("registerClient");
        Facade instance = new Facade();
        Client client = data.clients[0];
        String expResult = client.toString();
        String result = instance.registerClient(data.clientsData[0]);
        assertEquals(expResult, result);
    }

}
