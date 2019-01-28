import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.LeadsAdmin;
import page_object.OnRoadPricePage;
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

    @Test (description = "Fill GOP form, verify if lead is created")
    public void createGopLeadOnroadPriceForm() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        onRoadPricePage
                .selectBrand("Honda")
                .selectModel("Brio")
                .fillInInputName(userName)
                .fillInInputPhone("9999999999")
                .fillInInputLocation(userLocation)
                .selectPurchasePeriod("Planning to buy immediately")
                .clickBtnProceed()
                .verifyChosenModelTab("Honda Brio");
        new LeadsAdmin()
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
