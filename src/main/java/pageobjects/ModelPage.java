package pageobjects;

import buisnessobjects.Model;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageelements.BookingPopUp;
import pageelements.GopPopUp;

import static org.testng.Assert.assertEquals;
import static testdata.Urls.MODEL_PAGE;

public class ModelPage extends BaseElement {

    private GopPopUp gopPopUp;

    private BookingPopUp bookingPopUp;

    @FindBy(css = "[data-status]")
    private WebElement modelTitle;

    @FindBy(css = ".btn-lg")
    private WebElement btnTopGop;

    @FindBy(css = "#attached_item .gray_but")
    private WebElement priceListFirstVariant;

    @FindBy(css = ".premium-book-testdrive-resume .green_but")
    private WebElement btnTopBooking;

    public void navigateToModelPage() {
        webDriver.navigate().to(MODEL_PAGE);
    }

    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }


    public String getModelName() {
        System.out.println("This is " + modelTitle.getText());
        return modelTitle.getText();
    }

    public void verifyModel(Model model) {
        assertEquals(model.getBrand_name() + " " + model.getComplect_name(), modelTitle.getText(), "The titles on UI an in API are equal");
    }

    public GopPopUp clickTopGopBtn() {
        click(btnTopGop);
        return gopPopUp;
    }

    public GopPopUp clickPriceListGopBtn() {
        click(priceListFirstVariant);
        return gopPopUp;
    }

    public BookingPopUp clickTopBookingBtn() {
        click(btnTopBooking);
        return bookingPopUp;
    }
}
