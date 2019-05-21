
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import subbusinesstier.entities.ClientTest;
import subbusinesstier.entities.FlightTest;
import subbusinesstier.entities.PurchaseTest;
import subbusinesstierr.FacadeTest;
import subbusinesstierr.FactoryTest;

@Categories.SuiteClasses({FactoryTest.class, PurchaseTest.class, FlightTest.class,ClientTest.class,
    FacadeTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(Test_Control.class)
public class Suite11 {
    
}
