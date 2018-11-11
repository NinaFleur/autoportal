package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".search-result")
    private List<WebElement> searchResults;

    private int getSearchResults() {
        LOGGER.info("Check the Search results displaying on the \"Search Result\" page");
        return searchResults.size();
    }

    public SearchResultPage verifyResults() {
        LOGGER.info("Verify Search results on the \"Search Result\" page");
        assertTrue(getSearchResults() != 0, "No results were found");
        return this;
    }
}



