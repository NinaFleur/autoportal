package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class GetOnRoadPriceResultPage extends BasePage {

    @FindBy(css = ".view-tab")
    private List<WebElement> carModelTab;

    private static final By tab = By.cssSelector(".view-tab");

    public void navigateToGetOnRoadPricePageResult() {
        webDriver.navigate().to("https://autoportal.com/newcars/hyundai/santro/onroadprice-in-newdelhi.html");
    }

    public GetOnRoadPriceResultPage verifyChosenModelTab(String carModelName) {
        LOGGER.info("Verify the Model tab title");
        waitForVisibilityBy(tab);
        assertTrue(carModelTab.get(0).isDisplayed(), "The Model tab isn't displayed");
        assertTrue(carModelTab.get(0).getText().equals(carModelName));
        return this;
    }
}
