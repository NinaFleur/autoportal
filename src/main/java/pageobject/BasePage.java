package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class BasePage {

    private WebDriver driver;

    public BasePage() {
        System.setProperty("webdriver.chrome.driver","/Users/mac/Automation/projects/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://autoportal.com/");
    }
}



