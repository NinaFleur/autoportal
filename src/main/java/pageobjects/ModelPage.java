package pageobjects;

import buisnessobjects.Model;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageelements.BookingPopUp;
import pageelements.GopPopUp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testdata.Urls.MODEL_PAGE;

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
        webDriver.navigate().to(url);
        return this;
    }

    public String getModelName() {
        return modelTitle.getText();
    }

    @Step("Verify Model Data")
    public void verifyModel(Model model) {
        assertEquals(model.getBrand_name() + " " + model.getComplect_name(), modelTitle.getText(), "Model Title is not expected");
        assertTrue(getMainModelImageUrl().contains(model.getImage()), "Image url is not correct");
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

    public String getPriceMin() {
        return priceMin.getText();
    }

    public String getPriceMax() {
        return priceMax.getText();
    }

    public String getMainModelImageUrl() {
        return mainImg.getAttribute("src");
    }

}
