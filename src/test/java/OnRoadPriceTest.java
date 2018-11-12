import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.OnRoadPricePage;

public class OnRoadPriceTest extends BaseTest{
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
        onRoadPricePage
                .selectBrand("Hyundai")
                .selectModel("Santro")
                .fillInInputName("Test One")
                .fillInInputPhone("9999999999")
                .fillInInputLocation("New Delhi")
                .selectPurchasePeriod("Planning to buy immediately")
                .clickBtnProceed();
    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}
