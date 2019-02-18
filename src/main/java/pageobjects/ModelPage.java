package pageobjects;

import buisnessobjects.Model;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageelements.BookingPopUp;
import pageelements.GopPopUp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ModelPage extends BaseElement {

    private GopPopUp gopPopUp;

    private BookingPopUp bookingPopUp;

    @FindBy(css = "[data-status]")
    private WebElement modelTitle;

    @FindBy(css = "[data-gtm-product-price-min]")
    private WebElement priceMin;

    @FindBy(css = "[data-gtm-product-price-max]")
    private WebElement priceMax;

    @FindBy(css = ".btn-lg")
    private WebElement btnTopGop;

    @FindBy(css = "#attached_item .gray_but")
    private WebElement priceListFirstVariant;

    @FindBy(css = ".premium-book-testdrive-resume .green_but")
    private WebElement btnTopBooking;

    @FindBy(css = ".gallery-photos .first img")
    private WebElement mainImg;

    public ModelPage navigateTo(String url) {
        LOGGER.info("Navigate to the Model page");
        webDriver.navigate().to(url);
        return this;
    }

    public String getModelName() {
        LOGGER.info("Get the Model title from UI");
        return modelTitle.getText();
    }

    @Step("Verify Model Data")
    public void verifyModel(Model model) {
        LOGGER.info("Compare Model titles from UI and API, compare main image URLs");
        assertEquals(model.getBrand_name() + " " + model.getComplect_name(), modelTitle.getText(), "Model Title is not expected");
        assertTrue(getMainModelImageUrl().contains(model.getImage()), "Image url is not correct");
    }

    public GopPopUp clickTopGopBtn() {
        LOGGER.info("Click Top GOP button");
        click(btnTopGop);
        return gopPopUp;
    }

    public GopPopUp clickPriceListGopBtn() {
        LOGGER.info("Click first GOP btn in the Price List block");
        click(priceListFirstVariant);
        return gopPopUp;
    }

    public BookingPopUp clickTopBookingBtn() {
        LOGGER.info("Click Top Booking btn");
        click(btnTopBooking);
        return bookingPopUp;
    }

    public String getPriceMin() {
        LOGGER.info("Get the min model price");
        return priceMin.getText();
    }

    public String getPriceMax() {
        LOGGER.info("Get the max model price");
        return priceMax.getText();
    }

    public String getMainModelImageUrl() {
        LOGGER.info("Get the main image URL");
        return mainImg.getAttribute("src");
    }

}
