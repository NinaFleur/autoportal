package pageobjects;

import io.qameta.allure.Step;
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
        LOGGER.info("Navigate to the GOP Result page");
        webDriver.navigate().to(GOP_RESULT_PAGE);
    }

    @Step("Verify chosen Model tab on the GORP")
    public GetOnRoadPriceResultPage verifyChosenModelTab(String fullModelName) {
        LOGGER.info("Verify the Model tab title on the GORP");
        waitForVisibilityBy(tab);
        assertTrue(carModelTab.get(0).isDisplayed(), "The Model tab isn't displayed");
        assertTrue(carModelTab.get(0).getText().equals(fullModelName));
        return this;
    }
}
