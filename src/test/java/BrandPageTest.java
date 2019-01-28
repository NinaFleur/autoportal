import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.BrandPage;
import page_object.LeadsAdmin;
import utils.Utils;

public class BrandPageTest extends BaseTest {

    private BrandPage brandPage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        brandPage = new BrandPage();
        brandPage.navigateToBrandPage();
    }

    @Test (description = "Fill in GOP pop-up on the Brand page, submit it and create GOP Lead")
    public void createGopLeadBrandPagePopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        brandPage
                .clickBrandGopBtn("Honda CR-V")
                .fillInAndSubmit(userName, "9999999999", userLocation,
                        "Planning to buy in 2 weeks")
                .verifyChosenModelTab("Honda CR-V");
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
