package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static testdata.Urls.GOP_RESULT_PAGE;


public class GetOnRoadPriceResultPage extends BaseElement {

    @FindBy(css = ".view-tab")
    private List<WebElement> carModelTab;

    private static final By tab = By.cssSelector(".view-tab");

    public void navigateToGetOnRoadPricePageResult() {
        webDriver.navigate().to(GOP_RESULT_PAGE);
    }

    public GetOnRoadPriceResultPage verifyChosenModelTab(String carModelName) {
        LOGGER.info("Verify the Model tab title");
        waitForVisibilityBy(tab);
        assertTrue(carModelTab.get(0).isDisplayed(), "The Model tab isn't displayed");
        assertTrue(carModelTab.get(0).getText().equals(carModelName));
        return this;
    }
}
