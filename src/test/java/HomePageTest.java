import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.HomePage;
import pageobject.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class HomePageTest {

    WebDriver driver = new ChromeDriver();
    private HomePage homePage;
    private SearchResultPage searchResults;


    @Before
    public void setUp() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/nina/Automation/projects/autoportal/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://autoportal.com/");
    }

    @Test
    public void searchTest() {
        homePage = new HomePage();
        homePage
                .searchForQuery("Tata");

        searchResults = new SearchResultPage();
        searchResults.getSearchResults();
        Assert.assertTrue("No results were found", searchResults.getSearchResults() != 0);

    }

    @After
    public void closeDriver() {
        driver.quit();
    }


}

