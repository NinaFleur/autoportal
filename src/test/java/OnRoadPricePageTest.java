import api.RestApiExecutor;
import buisnessobjects.Model;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LeadsAdmin;
import pageobjects.OnRoadPricePage;
import utils.Utils;

import static testdata.Urls.BASE_NEWCARS_PAGE;

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
        Model model = RestApiExecutor.getInstance().getModelByIndex(0);

        onRoadPricePage
                .selectBrand(model.getBrand_name())
                .selectModel(model.getComplect_name())
                .fillInInputName(userName)
                .fillInInputPhone("9999999999")
                .fillInInputLocation(userLocation)
                .selectPurchasePeriod("Planning to buy immediately")
                .clickBtnProceed()
                .verifyChosenModelTab(model.getFullModelName());
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
