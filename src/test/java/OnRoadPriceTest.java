import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.GetOnRoadPriceResultPage;
import pageobject.GopLeadsAdmin;
import pageobject.OnRoadPricePage;
import utils.Utils;

public class OnRoadPriceTest extends BaseTest {
    private OnRoadPricePage onRoadPricePage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        onRoadPricePage = new OnRoadPricePage();
        onRoadPricePage.navigate();
    }

    @Test
    public void submitGopForm() {
        String userName = Utils.getRandomStringWithoutNumbers(7);

        onRoadPricePage
                .selectBrand("Tata")
                .selectModel("Tiago")
                .fillInInputName(userName)
                .fillInInputPhone("9999999999")
                .fillInInputLocation("New Delhi")
                .selectPurchasePeriod("Planning to buy immediately")
                .clickBtnProceed()
                .verifyChosenModelTab("Tata Tiago");
        new GopLeadsAdmin()
                .navigate()
                .checkSavedLead(userName);

    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}
