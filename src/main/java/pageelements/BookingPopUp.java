package pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BaseElement;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

@Name("BookingPopUp")
@Block(@FindBy(css = "[data-popup-container='data-model-booking-popup']"))


public class BookingPopUp extends BaseElement {

    private static final By popupBookinglocationBox = By.cssSelector(".ui-state-highlight");

    @FindBy(css = "#bookingModelCity")
    private WebElement popupBookingInputLocation;

    @FindBy(css = "[data-popup-container='data-model-booking-popup'] .ui-front")
    private List<WebElement> popupBookingAutocompleteOptions;

    @FindBy(css = "[data-booking='modelVariant']")
    private WebElement popupBookingVariant;

    @FindBy(css = "[data-booking='modelVariant'] option")
    private List<WebElement> popupBookingVariantOptions;

    @FindBy(css = "[data-popup-container='data-model-booking-popup'] [name='name']")
    private WebElement popupBookingInputName;

    @FindBy(css = "[data-popup-container='data-model-booking-popup'] [name='email']")
    private WebElement popupBookingInputEmail;

    @FindBy(css = "[data-popup-container='data-model-booking-popup'] [placeholder='Enter Your Phone*']")
    private WebElement popupBookingInputPhone;

    @FindBy(css = "[data-popup-container='data-model-booking-popup'] [name='showroom']")
    private WebElement popupBookingDealer;

    @FindBy(css = "[data-popup-container='data-model-booking-popup'] [name='showroom'] option")
    private List<WebElement> popupBookingDealerOptions;

    @FindBy(css = "[data-popup-container='data-model-booking-popup'] [type='submit']")
    private WebElement popupBookingBtnProceed;

    private void fillInInputLocation(String userLocation) {
        LOGGER.info("Select the User location in the Booking pop-up");
        sendKeys(popupBookingInputLocation, userLocation);
        waitForVisibilityBy(popupBookinglocationBox);
        for (WebElement location : popupBookingAutocompleteOptions) {
            if (location.getText().contains(userLocation)) {
                click(location);
                break;
            }
        }
    }

    private void selectVariant() {
        LOGGER.info("Select the Model Variant in the Booking pop-up");
        click(popupBookingVariant);
        click(popupBookingVariantOptions.get(5));
    }

    private void fillInInputName(String userName) {
        LOGGER.info("Fill the User name in the Booking pop-up");
        sendKeys(popupBookingInputName, userName);
    }

    private void fillInInputEmail(String userEmail) {
        LOGGER.info("Fill the User email in the Booking pop-up");
        sendKeys(popupBookingInputEmail, userEmail);
    }

    private void fillInInputPhone(String userPhone) {
        LOGGER.info("Fill the User phone in the Booking pop-up");
        sendKeys(popupBookingInputPhone, userPhone);
    }

    private void selectDealer() {
        LOGGER.info("Select the Dealer in the Booking pop-up");
        click(popupBookingDealer);
        click(popupBookingDealerOptions.get(1));
    }

    private void clickBtnProceed() {
        LOGGER.info("Click the Proceed btn in the Booking pop-up");
        click(popupBookingBtnProceed);
    }

    public void fillInAndSubmitBookingPopup(String userLocation, String userName, String userEmail, String userPhone) {
        LOGGER.info("Fill in the Booking pop-up with the User data, click the Proceed btn ");
        fillInInputLocation(userLocation);
        selectVariant();
        fillInInputName(userName);
        fillInInputEmail(userEmail);
        fillInInputPhone(userPhone);
        selectDealer();
        clickBtnProceed();
    }


}
