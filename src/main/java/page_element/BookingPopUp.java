package page_element;

import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_object.BaseElement;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.ArrayList;
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
        click(popupBookingVariant);
        click(popupBookingVariantOptions.get(5));
    }

    private void fillInInputName(String userName) {
        sendKeys(popupBookingInputName, userName);
    }

    private void fillInInputEmail(String userEmail) {
        sendKeys(popupBookingInputEmail, userEmail);
    }

    private void fillInInputPhone(String userPhone) {
        sendKeys(popupBookingInputPhone, userPhone);
    }

    private void selectDealer() {
        click(popupBookingDealer);
        click(popupBookingDealerOptions.get(1));
    }

    private void clickBtnProceed() {
        click(popupBookingBtnProceed);
    }

    public void fillInAndSubmitBookingPopup(String userLocation, String userName, String userEmail, String userPhone) {
        fillInInputLocation(userLocation);
        selectVariant();
        fillInInputName(userName);
        fillInInputEmail(userEmail);
        fillInInputPhone(userPhone);
        selectDealer();
        clickBtnProceed();
    }


}
