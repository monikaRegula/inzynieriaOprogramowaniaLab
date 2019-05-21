
package subbusinesstier.entities;

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
public class TicketTest {

    static Data data;
    static Ticket ticket;

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }

    @Before
    public void setUp() {
        ticket = data.tickets[number1];
    }

    @Parameterized.Parameter
    public int number1;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{{0}, {1}};
        return Arrays.asList(data1);
    }

    /**
     * Test of equals method, of class Ticket.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        for (int j = number1; j < 1; j++) {
            if (number1 == j) {
                assertTrue(data.flights[number1].equals(data.flights[j]));
            } else {
                assertFalse(data.flights[number1].equals(data.flights[j]));
            }
        }
    }

    @Test
    public void testModifyNumberOfSeats() {
        System.out.println("modifyNumberOfSeats");
        //given
        Ticket instance = new Ticket(0, data.tickets[0]);
        Flight flight = data.flights[0];
        flight.setNumberOfSeats(10);
        flight.addTickets();
        //when
        flight.modifyNumberOfSeats();
        //then
        assertEquals(9, flight.getNumberOfSeats());
    }

}
