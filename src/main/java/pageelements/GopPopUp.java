package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BaseElement;
import pageobjects.GetOnRoadPriceResultPage;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

@Name("GopPopUp")
@Block(@FindBy(css = ".gop-popup__wrap"))

public class GopPopUp extends BaseElement {

    private static final By popupGoplocationBox = By.cssSelector(".ui-state-highlight");

    @FindBy(css = ".form-lead-gop input[name='name']")
    private WebElement popupGopInputName;

    @FindBy(css = ".form-lead-gop input[placeholder='Mobile No.*']")
    private WebElement popupGopInputPhone;

    @FindBy(css = "#gop_type_address")
    private WebElement popupGopInputLocation;

    @FindBy(css = ".autocomplete-box .ui-menu-item")
    private List<WebElement> popupGopAutocompleteOptions;

    @FindBy(css = ".form-lead [name='purchaseDate']")
    private WebElement popupGopPurchasePeriodDropDown;

    @FindBy(css = ".form-lead [name='purchaseDate'] option")
    private List<WebElement> popupGopPurchaseDates;

    @FindBy(css = ".form-lead .red_but.cell-sm")
    private WebElement popupGopBtnProceed;

    private void fillInInputName(String userName) {
        LOGGER.info("Fill the User name in the GOP pop-up");
        sendKeys(popupGopInputName, userName);
    }

    private void fillInInputPhone(String userPhone) {
        LOGGER.info("Fill the User phone in the GOP pop-up");
        sendKeys(popupGopInputPhone, userPhone);
    }

    private void fillInInputLocation(String userLocation) {
        LOGGER.info("Select the User location in the GOP pop-up");
        sendKeys(popupGopInputLocation, userLocation);
        waitForVisibilityBy(popupGoplocationBox);
        for (WebElement location : popupGopAutocompleteOptions) {
            if (location.getText().contains(userLocation)) {
                click(location);
                break;
            }
        }
    }

    private void selectPurchasePeriod(String purchaseDate) {
        LOGGER.info("Select the Purchase period in the GOP pop-up");
        click(popupGopPurchasePeriodDropDown);
        for (WebElement date : popupGopPurchaseDates) {
            if (date.getText().equals(purchaseDate)) {
                click(date);
                break;
            }
        }
    }

    private void clickBtnProceed() {
        LOGGER.info("Click the Proceed btn in the GOP pop-up");
        click(popupGopBtnProceed);
    }

    public GetOnRoadPriceResultPage fillInAndSubmit(String userName, String userPhone, String userLocation, String purchaseDate) {
        LOGGER.info("Fill in the GOP pop-upp with the User data, click the Proceed btn");
        fillInInputName(userName);
        fillInInputPhone(userPhone);
        fillInInputLocation(userLocation);
        selectPurchasePeriod(purchaseDate);
        clickBtnProceed();
        return new GetOnRoadPriceResultPage();
    }

}
