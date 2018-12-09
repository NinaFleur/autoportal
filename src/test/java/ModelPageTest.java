import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.GopLeadsAdmin;
import pageobject.ModelPage;
import utils.Utils;

public class ModelPageTest extends BaseTest {
    private ModelPage modelPage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        modelPage = new ModelPage();
        modelPage.navigateToModelPage();
    }

    @Test
    public void createLeadTopGopPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);

        modelPage
                .fillInAndSubmitGopPopUpThroughTopGop(userName, "9999999999", "Pune",
                        "Just researching")
                .verifyChosenModelTab("Tata Tiago");
        new GopLeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Test
    public void createLeadPriceListGopPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);

        modelPage
                .fillInAndSubmitGopPopUpThroughPriceList(userName, "9999999999",
                        "Goa", "Just researching")
                .verifyChosenModelTab("Tata Tiago");
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
