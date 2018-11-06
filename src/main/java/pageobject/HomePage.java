package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private void enterSearchQuery(String strSearchText) {
        searchInput.sendKeys(strSearchText);
    }

    private void clickEnterInSearchField() {
        searchInput.sendKeys(Keys.ENTER);
    }

    public void searchForQuery(String searchQuery) {
        enterSearchQuery(searchQuery);
        clickEnterInSearchField();
    }

}

