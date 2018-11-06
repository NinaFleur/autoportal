
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class HomePageTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/mac/Automation/projects/autoportal/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://autoportal.com/");
    }

    @Test
    public void searchTest(){
        new HomePage(driver)
                .searchForQuery("Tata");
        new SearchResultPage(driver)
                .verifyResults();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }


}

