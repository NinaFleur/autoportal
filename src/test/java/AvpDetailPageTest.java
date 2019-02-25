import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AvpDetailPage;
import pageobjects.HomePage;
import utils.Utils;

public class AvpDetailPageTest extends BaseTest {

    private HomePage homePage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        homePage = new HomePage();
        homePage.navigate();
    }

    @Test(description = "Get AVP Detail Page, choose city, body type, color, check price, change another car")
    public void getAvpDetailPage() {
        homePage
                .clickButtonViewDeals()
                .chooseAvpModelWithFilter()
                .changeColorAndInsuranceType();
    }

    @Test(description = "Get AVP Detail page, change car and make pre-booking")
    public void changeCarAndMakePrebooking() {
        String userName = Utils.getRandomStringWithoutNumbers(7);

        homePage
                .clickButtonViewDeals()
                .chooseAvpModelWithFilter()
                .changeAnotherCar()
                .fillAndSubmitPrebooking(userName, "test@test.com", "9999999999");
    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }

}
