package subbusinesstier.entities;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import subbusinesstierr.Data;
import subbusinesstierr.Factory;

@Category({Test_Entity.class})
@RunWith(Parameterized.class)
public class PurchaseTest {

    static Data data;

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }

    @Parameterized.Parameter
    public int number1;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{{0}, {1}, {2}, {3}};
        return Arrays.asList(data1);
    }

  
    @Test
    public void testEquals() {
        System.out.println("equals");
        int j = 0;
        for (Purchase pur : data.purchases) {
            if (number1 == j) {
                assertTrue(pur.equals(data.purchases[number1])); //równe zamówienia
            } else 
            {
             //  assertFalse(pur.equals(data.purchases[number1]));//różne zamówienia
               j++;
            }
             
        }
    }
    
    
    


}
