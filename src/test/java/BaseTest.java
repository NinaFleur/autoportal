import client.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodInit() {
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodStop() {
        DriverFactory.getInstance().closeWebDriver();
    }
}

