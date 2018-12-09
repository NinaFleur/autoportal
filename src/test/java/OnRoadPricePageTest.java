import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.GopLeadsAdmin;
import pageobject.OnRoadPricePage;
import utils.Utils;

public class OnRoadPricePageTest extends BaseTest {
    private OnRoadPricePage onRoadPricePage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        onRoadPricePage = new OnRoadPricePage();
        onRoadPricePage.navigate();
    }

    @Test
    public void createGopLeadOnroadPriceForm() {
        String userName = Utils.getRandomStringWithoutNumbers(7);

        onRoadPricePage
                .selectBrand("Honda")
                .selectModel("Brio")
                .fillInInputName(userName)
                .fillInInputPhone("9999999999")
                .fillInInputLocation("New Delhi")
                .selectPurchasePeriod("Planning to buy immediately")
                .clickBtnProceed()
                .verifyChosenModelTab("Honda Brio");
        new GopLeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}
