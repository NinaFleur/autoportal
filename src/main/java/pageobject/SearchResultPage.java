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
}



