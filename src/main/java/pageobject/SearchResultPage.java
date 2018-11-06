package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchResultPage{

    @FindBy(css = ".search-result")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private int getSearchResults() {
        return searchResults.size();

    }

    public SearchResultPage verifyResults() {
        assertTrue( getSearchResults() != 0, "No results were found");
        return this;
    }
}



