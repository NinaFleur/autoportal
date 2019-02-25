package pageobjects;

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

    public AvpListingPage checkBtnRequestCallBack() {
        LOGGER.info("check if the \"Request Call Back\" buttons are displayed");
        assertTrue(btnRequestCallBack.get(0).isDisplayed(), "Request CallBack buttons are not displayed");
        return this;
    }

    public AvpListingPage selectCity(int index) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(dropdownCities);
        cities.get(index).click();
//        пока могу только так
        assertTrue(webDriver.getCurrentUrl().contains("ghaziabad"), "City wasn't selected");
        return this;
    }

    public AvpListingPage selectBodyType(int index) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(bodyType.get(index));
        return this;
    }

    public AvpDetailPage clickAvpModel(int index) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(webDriver.findElements(By.cssSelector(".model-title a")).get(index));
        return new AvpDetailPage();
    }

    public AvpDetailPage chooseAvpModelWithFilter() {
        LOGGER.info("Select City,  body type, click AVP model and navigate to the AVP Detail Page");
        selectCity(2);
        selectBodyType(0);
        clickAvpModel(1);
        return new AvpDetailPage();
    }


}
