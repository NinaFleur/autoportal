package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchResultPage extends BaseElement {

    @FindBy(css = ".search-result")
    private List<WebElement> searchResults;

    @Step("Check if the Search results are displaying on the \"Search Result\" page")
    private int getSearchResults() {
        LOGGER.info("Check if the Search results are displaying on the \"Search Result\" page");
        return searchResults.size();
    }

    @Step("Verify the Search results on the \"Search Result\" page")
    public SearchResultPage verifyResults() {
        LOGGER.info("Verify the Search results on the \"Search Result\" page");
        assertTrue(getSearchResults() != 0, "No results were found");
        return this;
    }
}



