package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class AvpListingPage extends BaseElement {

    private AvpDetailPage avpDetailPage;

    @FindBy(css = ".m_b-10 .red_but")
    private List<WebElement> btnRequestCallBack;

    @FindBy(css = ".model-title")
    private List<WebElement> modelTitles;

    @FindBy(css = "[id='cities']")
    private WebElement dropdownCities;

    @FindBy(css = "[id='cities'] option")
    private List<WebElement> cities;

    @FindBy(css = "[data-trackevent-action='Car Types'] + .item-body .filters-list li")
    private List<WebElement> bodyType;

    @Step("Check if the \"Request Call Back\" buttons are displayed")
    public AvpListingPage checkBtnRequestCallBack() {
        LOGGER.info("check if the \"Request Call Back\" buttons are displayed");
        assertTrue(btnRequestCallBack.get(0).isDisplayed(), "Request CallBack buttons are not displayed");
        return this;
    }

    @Step("Select City by index from the \"Cities\" drop-down")
    public AvpListingPage selectCity(int index) {
        LOGGER.info("Select City from the Cities drop-down");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*
        waitForPageLoad(webDriver);
*/
        click(dropdownCities);
        cities.get(index).click();
//        пока могу только так
        assertTrue(webDriver.getCurrentUrl().contains("ghaziabad"), "City wasn't selected");
        return this;
    }

    @Step("Select body type by index from the \"Car Types\" drop-down")
    public AvpListingPage selectBodyType(int index) {
        LOGGER.info("Select body type by index from the \"Car Types\" drop-down");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*
        waitForPageLoad(webDriver);
*/
        click(bodyType.get(index));
        return this;
    }

    @Step("Click AVP model by index")
    public AvpDetailPage clickAvpModel(int index) {
        LOGGER.info("Click AVP model by index");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*
        waitForPageLoad(webDriver);
*/
        click(webDriver.findElements(By.cssSelector(".model-title a")).get(index));
        return new AvpDetailPage();
    }

    @Step("Select City,  body type, click AVP model and navigate to the AVP Detail Page")
    public AvpDetailPage chooseAvpModelWithFilter() {
        LOGGER.info("Select City,  body type, click AVP model and navigate to the AVP Detail Page");
        selectCity(2);
        selectBodyType(0);
        clickAvpModel(1);
        return new AvpDetailPage();
    }


}
