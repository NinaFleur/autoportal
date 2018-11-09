
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.SearchResultPage;
import pageobject.DealsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nina/Automation/projects/autoportal/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://autoportal.com/");
    }

    @Test
    public void verifyHeaderLinks() {
        new HomePage(driver)
                .compareHeaderLinks();
        List links = driver.findElements(By.tagName("li"));
        System.out.println(links.size());

    }

    @Test
    public void openViewDealsTab(){
        new HomePage(driver)
                .clickButtonViewDeals();
        String urlDealPage = driver.getCurrentUrl();
        System.out.println(urlDealPage);
//       ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//       driver.switchTo().window(tabs.get(0));
    }


    @Test
    public void verifyCarFormTitle(){
        new HomePage(driver)
                .verifyTitle();
        String title = driver.getTitle();
        System.out.println(title);
    }


    @Test
    public void searchTest() {
        new HomePage(driver)
                .searchForQuery("Tata");
        new SearchResultPage(driver)
                .verifyResults();
        String pagesource = driver.getPageSource();
        System.out.println(pagesource);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }


}

