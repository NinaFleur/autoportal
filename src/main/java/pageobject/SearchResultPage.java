package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".search-result")
    private List<WebElement> searchResults;

    public int getSearchResults() {
        return searchResults.size();
    }

    public void checkSearchResults() {
        Assert.assertTrue("No results were found", searchResults.getSearchResults() != 0);

    }
}



