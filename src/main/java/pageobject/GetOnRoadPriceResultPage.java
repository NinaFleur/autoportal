package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class GetOnRoadPriceResultPage extends BasePage {

    public void navigateToGetOnRoadPricePageResult() {
        webDriver.navigate().to("https://autoportal.com/newcars/hyundai/santro/onroadprice-in-newdelhi.html");
    }

    @FindBy(css = ".view-tab")
    private List<WebElement> carModelTab;

    public GetOnRoadPriceResultPage checkChosenModelTab(String carModelName) {
        LOGGER.info("Check if Model tab is displayed");
        for (WebElement tab : carModelTab) {
            tab.getText().equals(carModelName);
        }
        return this;
    }

    public GetOnRoadPriceResultPage verifyChosenModelTab() {
        LOGGER.info("Verify the Model tab title");
        assertTrue(carModelTab.get(0).isDisplayed(), "The Model tab isn't displayed");
        return this;
    }
}
