import api.RestApiExecutor;
import buisnessobjects.Model;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
        modelPage.navigateToModelPage();
    }

    @Test(description = "Click on the Top Gop btn on the Model page, fill in GOP pup-up, verify if lead is created ")
    public void createLeadTopGopPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage
                .clickTopGopBtn()
                .fillInAndSubmit(userName, "9999999999", userLocation, "Just researching")
                .verifyChosenModelTab("Tata Tiago");
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Test(description = "Click on the Gop btn from the Price List, fill in GOP pup-up, verify if lead is created")
    public void createLeadPriceListGopPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage
                .clickPriceListGopBtn()
                .fillInAndSubmit(userName, "9999999999", userLocation, "Just researching")
                .verifyChosenModelTab("Tata Tiago");
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Test(description = "Click on the Top Booking btn, create booking lead")
    public void createLeadTopBookingPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage
                .clickTopBookingBtn()
                .fillInAndSubmitBookingPopup(userLocation, userName, "test@test.com", "9999999999");
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToBookingRequestTab()
                .checkSavedLead(userName);
    }

    @Test(description = "Get the Model title API and compare it to the title on UI")
    public void verifyModelTitle() {
        Model model = RestApiExecutor.getInstance().getModelArrayByIndex(0);
        String modelNameFromApi = model.getBrand_name() + " " + model.getComplect_name();
        String modelNameFromUi = modelPage.getModelName();
        Assert.assertEquals(modelNameFromApi, modelNameFromUi, "Titles from UI and API are equals");
    }

    @Test(description = "Get the Model URL from the API response and compare model titles")
    public void verifyModelData() {

        Model model = RestApiExecutor.getInstance().getModelArrayByIndex(0);
        String modelPageUrl = BASE_NEWCARS_PAGE + model.getBrand_path() + "/" + model.getComplect_path();
        modelPage.navigateTo(modelPageUrl);
        modelPage.verifyModel(model);
    }


    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}