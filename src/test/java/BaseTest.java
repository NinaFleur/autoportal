import client.DriverFactory;
import listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodInit() {
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodStop() {
        DriverFactory.getInstance().closeWebDriver();
    }
}

