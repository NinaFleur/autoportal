package pageobjects;

import client.DriverFactory;
import environment.EnvironmentConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BaseElement extends HtmlElement {

    public static final String MY_SITE_URL = EnvironmentConfigurator.getInstance().getMySiteUrl();
//    public static final String MY_SITE_URL_WITH_BASE_AUTH = addBasicAuthToSiteUrl(EnvironmentConfigurator.getInstance().getMySiteUrl());

    protected static final Logger LOGGER = LoggerUtil.getInstance();
    protected WebDriver webDriver = DriverFactory.getInstance().getDriver();
    private WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
    public BaseElement() {
        HtmlElementLoader.populatePageObject(this, webDriver);
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
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException nse) {
            LOGGER.error("", nse);
        }
    }

    public void waitForInVisibilityBy(By locator) {
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

    public void scrollToWebElement(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement);
        actions.perform();
    }

    public void closeBannerAvp() {
        waitForVisibilityBy(By.cssSelector(".popup_avp .popup_close"));
        webDriver.findElement(By.cssSelector(".popup_avp .popup_close")).click();
    }

    public void closeCityDetectPopup() {
        waitForVisibilityBy(By.cssSelector(".close-btn"));
        webDriver.findElement(By.cssSelector(".close-btn")).click();
    }

//    public void  moveMouse() throws  AWTException {
//        Robot robot = new Robot();
//        robot.mouseMove(630, 420);
//        robot.delay(1500);
//    }
//
//    public void  pressMouseBtn() throws  AWTException {
//        Robot robot = new Robot();
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//    }


}



