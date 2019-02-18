package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static testdata.Urls.INDEX;

public class HomePage extends BaseElement {

    @FindBy(css = ".master-menu ul li.item>a, .master-menu ul li.item>span")
    private List<WebElement> headerLinks;

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;

    @FindBy(css = ".frm_srch-in p")
    private WebElement titleFindCarForm;

    @FindBy(css = "[name='brand']")
    private WebElement selectBrandDropDown;

    @FindBy(css = "[name='brand'] option")
    private List<WebElement> brands;

    @FindBy(css = "[name='model']")
    private WebElement selectModelDropDown;

    @FindBy(css = "[name='model'] option")
    private List<WebElement> models;

    @FindBy(css = "[value='Find new cars']")
    private WebElement btnFindNewCars;

    @FindBy(css = "a.red_but")
    private WebElement btnViewDeals;

    public void navigate() {
        webDriver.navigate().to(INDEX);
    }

    private String getCarFormTitle() {
        LOGGER.info("Get the \"Find Car\" form title");
        return titleFindCarForm.getText();
    }

    public HomePage verifyTitle(String correctTitleFindCarForm) {
        LOGGER.info("Verify the \"Find Car\" form title");
        assertEquals(getCarFormTitle(), correctTitleFindCarForm, "The title in the Car Find form isn't correct");
        return this;
    }

    public DealsPage clickButtonViewDeals() {
        LOGGER.info("click the \"View Deals\" button in the AVP banner");
        click(btnViewDeals);
        switchToTabByIndex(1);
        return new DealsPage();
    }

    private List<String> getHeaderLinks() {
        LOGGER.info("Get all links' names in the Header");
        List<String> headerLinksText = new ArrayList<>();
        for (WebElement linkText : headerLinks) {
            headerLinksText.add(linkText.getText());
        }
        return headerLinksText;
    }

    public HomePage verifyHeaderLinks(List<String> correctHeaderLinks) {
        LOGGER.info("Verify Header links' names");
        assertEquals(getHeaderLinks(), correctHeaderLinks, "Header Links are incorrect");
        return this;
    }

    public void searchForQuery(String searchQuery) {
        LOGGER.info("Search for: " + searchQuery);
        sendKeys(searchInput, searchQuery);
        pressEnter(searchInput);
    }

    public ModelPage selectBrandModelFromDropDown(String brandName, String modelName) {
        LOGGER.info("Select Brand/Model in the \" Find Car\" form");
        click(selectBrandDropDown);
        for (WebElement brand : brands) {
            if (brand.getText().equals(brandName)) {
                click(brand);
                break;
            }
        }

        click(selectModelDropDown);
        for (WebElement model : models) {
            if (model.getText().equals(modelName)) {
                click(model);
                break;
            }
        }

        click(btnFindNewCars);
        return new ModelPage();
    }
}

