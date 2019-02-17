import api.RestApiExecutor;
import buisnessobjects.Model;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.BrandPage;
import pageobjects.LeadsAdmin;
import utils.Utils;

import static testdata.Urls.BASE_NEWCARS_PAGE;

public class BrandPageTest extends BaseTest {

    private BrandPage brandPage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        brandPage = new BrandPage();
        brandPage.navigateToBrandPage();
    }

    @DataProvider(name = "modelProvider")
    public static Object[][] modelProvider() {
        Model model = RestApiExecutor.getInstance().getModelByIndex(0);
        return new Object[][]{
                {model}
        };
    }

    @Test (description = "Fill in GOP pop-up on the Brand page, submit it and create GOP Lead")
    public void createGopLeadBrandPagePopup(Model model) {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        brandPage
                .clickBrandGopBtn(model.getBrand_name())
                .fillInAndSubmit(userName, "9999999999", userLocation,
                        "Planning to buy in 2 weeks")
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
