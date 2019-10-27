import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    models.AllTest.class,
    controllers.AllTest.class,
})

public class AllTest{

    public AllTest(){}

}