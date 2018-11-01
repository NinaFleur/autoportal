package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "ac_search")
    private WebElement searchInput;

    private void enterSearchQuery(String strSearchText) {
        searchInput.sendKeys(strSearchText);
    }

    private void clickEnterInSearchField() {
        searchInput.sendKeys(Keys.ENTER);
    }

    public SearchResultPage searchForQuery(String searchQuery) {
        enterSearchQuery(searchQuery);
        clickEnterInSearchField();
        return new SearchResultPage();
    }

}

