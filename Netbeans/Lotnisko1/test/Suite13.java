
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import subbusinesstier.entities.ClientTest;
import subbusinesstier.entities.FlightTest;
import subbusinesstier.entities.PurchaseTest;
import subbusinesstierr.FacadeTest;
import subbusinesstierr.FactoryTest;




@Categories.SuiteClasses({FactoryTest.class, PurchaseTest.class, FlightTest.class,ClientTest.class,
    FacadeTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(Test_Control.class)
@Categories.ExcludeCategory(Test_Purchase_1.class)
public class Suite13 {
    
}
