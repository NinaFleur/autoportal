package pageobject;

import client.ClientType;
import client.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BasePage {

    protected static final Logger LOGGER = LoggerUtil.getInstance();

    protected WebDriver webDriver = DriverFactory.getInstance().getDriver();

    private WebDriverWait webDriverWait = new WebDriverWait(webDriver, 60);

    public BasePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void sendKeys(WebElement webElement, String text) {
        waitForClickable(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public WebElement waitForVisibility(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (NoSuchElementException nse) {
            LOGGER.error("", nse);
            return null;
        }
        return webElement;
    }

    public void waitForVisibilityBy(By locator) {
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (NoSuchElementException nse) {
            LOGGER.error("", nse);
        }
    }

    public  WebElement waitForClickable(WebElement webElement) {
        waitForVisibility(webElement);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException nse) {
            LOGGER.error("", nse);
            return null;
        }
        return webElement;
    }

    public void pressEnter(final WebElement webElement) {
        waitForClickable(webElement);
        webElement.sendKeys(Keys.ENTER);
    }

    public void click(WebElement webElement) {
        waitForClickable(webElement);
        webElement.click();
    }


    public void switchToTabByIndex(int index) {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(index));
    }
}



