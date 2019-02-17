import api.RestApiExecutor;
import buisnessobjects.Model;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LeadsAdmin;
import pageobjects.ModelPage;
import utils.Utils;

import static testdata.Urls.BASE_NEWCARS_PAGE;

public class ModelPageTest extends BaseTest {
    private ModelPage modelPage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        modelPage = new ModelPage();
    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }

    @DataProvider(name = "modelProvider")
    public static Object[][] modelProvider() {
        Model model = RestApiExecutor.getInstance().getModelByIndex(0);
        String modelPageUrl = BASE_NEWCARS_PAGE + model.getBrand_path() + "/" + model.getComplect_path();
        return new Object[][]{
                {modelPageUrl, model}
        };
    }

    @DataProvider(name = "modelUrlProvider")
    public static Object[][] modelUrlProvider() {
        Model model = RestApiExecutor.getInstance().getModelByIndex(0);
        String modelPageUrl = BASE_NEWCARS_PAGE + model.getBrand_path() + "/" + model.getComplect_path();
        return new Object[][]{
                {modelPageUrl}
        };
    }

    @Test(description = "Click on the Top Gop btn on the Model page, fill in GOP pup-up, verify if lead is created", dataProvider = "modelProvider")
    public void createLeadTopGopPopup(String modelPageUrl, Model model) {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage.navigateTo(modelPageUrl)
                .clickTopGopBtn()
                .fillInAndSubmit(userName, "9999999999", userLocation, "Just researching")
                .verifyChosenModelTab(model.getFullModelName());
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Test(description = "Click on the Gop btn from the Price List, fill in GOP pup-up, verify if lead is created", dataProvider = "modelProvider")
    public void createLeadPriceListGopPopup(String modelPageUrl, Model model) {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage.navigateTo(modelPageUrl)
                .clickPriceListGopBtn()
                .fillInAndSubmit(userName, "9999999999", userLocation, "Just researching")
                .verifyChosenModelTab(model.getFullModelName());
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Test(description = "Click on the Top Booking btn, create booking lead", dataProvider = "modelUrlProvider")
    public void createLeadTopBookingPopup(String modelPageUrl) {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage.navigateTo(modelPageUrl)
                .clickTopBookingBtn()
                .fillInAndSubmitBookingPopup(userLocation, userName, "test@test.com", "9999999999");
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToBookingRequestTab()
                .checkSavedLead(userName);
    }

    @Test(description = "Verify Model Data", dataProvider = "modelProvider")
    public void verifyModelData(String modelPageUrl, Model model) {
        modelPage.navigateTo(modelPageUrl);
        modelPage.verifyModel(model);
    }
}