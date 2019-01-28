package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_element.BookingPopUp;
import page_element.GopPopUp;

import static test_data.Urls.MODEL_PAGE;

public class ModelPage extends BaseElement {

    private GopPopUp gopPopUp;

    private BookingPopUp bookingPopUp;

    @FindBy(css = ".btn-lg")
    private WebElement btnTopGop;

    @FindBy(css = "#attached_item .gray_but")
    private WebElement priceListFirstVariant;

    @FindBy(css = ".premium-book-testdrive-resume .green_but")
    private WebElement btnTopBooking;

    public void navigateToModelPage() {
        webDriver.navigate().to(MODEL_PAGE);
    }

    public GopPopUp clickTopGopBtn () {
        click(btnTopGop);
        return gopPopUp;
    }

    public GopPopUp clickPriceListGopBtn () {
        click(priceListFirstVariant);
        return gopPopUp;
    }

    public BookingPopUp clickTopBookingBtn () {
        click(btnTopBooking);
        return bookingPopUp;
    }
}
