import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

import java.util.Arrays;
import java.util.List;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        homePage = new HomePage();
        homePage.navigate();
    }

    @Test(description = "Verify if header links' text on the HomePage is correct")
    public void verifyHeaderLinks() {
        List<String> correctHeaderLinks = Arrays.asList("New Cars", "New Bikes", "Used Cars", "News & Articles", "More");

        homePage
                .verifyHeaderLinks(correctHeaderLinks);
    }

    @Test(description = "Click on the View Deals btn, verify if Request Call Back buttons are displayed on the page")
    public void verifyRequestCallBackButtonOnTheDealsPage() {
        homePage
                .clickButtonViewDeals()
                .checkBtnRequestCallBack();

    }

    @Test(description = "Verify the title in the Find Car form")
    public void verifyCarFormTitle() {
        String correctTitleFindCarForm = "Find Your Dream Car!";

        homePage
                .verifyTitle(correctTitleFindCarForm);
    }

    @Test(description = "Fill in Search query input, verify the results")
    public void verifySearchResults() {
        homePage
                .searchForQuery("Tata");
        new SearchResultPage()
                .verifyResults();
    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}

