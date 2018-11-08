package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class HomePage {


    @FindBy(css = ".master-menu ul li.item>a, .master-menu ul li.item>span")
    private List<WebElement> headerLinks;

    private List<String> correctHeaderLinks = Arrays.asList("New Cars", "New Bikes", "Used Cars", "News & Articles", "More");

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;

    @FindBy(css = ".frm_srch-in p")
    private WebElement titleFindCarForm;

    public String correctTitleFindCarForm = "Find Your Dream Car!";

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private String getCarFormTitle() {
        return titleFindCarForm.getText();
    }

    public HomePage verifyTitle() {
        assertEquals(getCarFormTitle(), correctTitleFindCarForm, "The title in the Car Find form isn't correct");
        return this;
    }


    private List<String> getHeaderLinks() {
        List<String> headerLinksText = new ArrayList<>();
        for (int i = 0; i < headerLinks.size(); i++) {
            String text = headerLinks.get(i).getText();
            headerLinksText.add(text);
        }

//            for (WebElement linkText : headerLinks) {
//            headerLinksText.add(linkText.getText());
//        }
//
        return headerLinksText;

    }

    public HomePage compareHeaderLinks() {
        assertEquals(correctHeaderLinks, getHeaderLinks(), "Header Links are incorrect");
        return this;
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

