import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.DealsPage;
import pageobject.HomePage;
import pageobject.SearchResultPage;

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

    @Test
    public void verifyHeaderLinks() {
        List<String> correctHeaderLinks = Arrays.asList("New Cars", "New Bikes", "Used Cars", "News & Articles", "More");

        homePage
                .verifyHeaderLinks(correctHeaderLinks);
    }

    @Test
    public void openViewDealsTab() {
        homePage
                .clickButtonViewDeals()
                .checkBtnRequestCallBack();
    }

    @Test
    public void verifyCarFormTitle() {
        String correctTitleFindCarForm = "Find Your Dream Car!";

        homePage
                .verifyTitle(correctTitleFindCarForm);
    }

    @Test
    public void searchTest() {
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

