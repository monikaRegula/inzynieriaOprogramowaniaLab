package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import subbusinesstierr.Data;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category({Test_Entity.class})
@RunWith(Parameterized.class)
public class FlightTest {

    static Data data;
    static Flight flight;

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }

    @Before
    public void setUp() {
        flight = data.flights[number1];
    }

    @Parameterized.Parameter
    public int number1;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{{0}, {1}};
        return Arrays.asList(data1);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        for (int j = number1; j < 2; j++) {
            if (number1 == j) {
                assertTrue(data.flights[number1].equals(data.flights[j]));
            } else {
                assertFalse(data.flights[number1].equals(data.flights[j]));
                j++;
            }
        }
    }

    @Test
    public void testAddPurchase() {
        System.out.println("addPurchase");
        int i = 0;
        number1 = 0;
        flight.addTickets();
        Client client = data.clients[0];
        for (Purchase purchase : data.purchases) {
            String result = flight.addPurchase(client, data.purchasesData[0]);
            String expected = client.toString();
            if(result.equals("Brak wolnego biletu")){
                // zamawiany jest ponownie  bilet, który już został kupiony
                assertNotEquals(expected, result);
            }else{
                assertEquals(result,expected);
            }
        }
    }

}
