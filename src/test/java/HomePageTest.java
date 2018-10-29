import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageTest {

    @Test
    public void searchTest() {

        System.setProperty("webdriver.chrome.driver", "/Users/mac/Automation/projects/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        System.out.println("driver object is created and initialized");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        System.out.println("wait object is created and initialized");
        driver.manage().window().fullscreen();
        System.out.println("switching fullscreen mode");
        driver.get("https://www.autoportal.com");
        System.out.println("get Autoportal.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-autocomplete-input")));
        System.out.println("waiting the search element visibility");
        WebElement searchInput = driver.findElement(By.cssSelector(".ui-autocomplete-input"));
        System.out.println("create searchInput object");
        searchInput.sendKeys("Tata");
        System.out.println("enter Tata into the input");
        searchInput.sendKeys(Keys.ENTER);
        System.out.println("press the Enter button");
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".search-result"));
        System.out.println("create list of search results");
        int size = searchResults.size();
        System.out.println("gettin size of search result list");
        Assert.assertTrue("No results were found", size != 0);
        System.out.println("verifying that search result list doesn't equal to zero");
        driver.quit();
        System.out.println("closing Chrome");
    }

    @Test
    public void justGreenTest() {
        Assert.assertTrue("Oops, it's false", false);
    }

}

