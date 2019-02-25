package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static testdata.Urls.AVP_DETAIL_PAGE;

public class AvpDetailPage extends BaseElement {

    @FindBy(css = "h1.m_b-5")
    private WebElement modelTitle;

    @FindBy(css = ".color-list .item")
    private List<WebElement> colors;

    @FindBy(css = "[data-desktop-pricing] [data-show-price-break-up]")
    private WebElement btnViewPriceBreakup;

    @FindBy(css = ".viewbox-metadata .btn-change")
    private WebElement btnChangeCar;

    @FindBy(css = "[name='brand']")
    private WebElement selectBrand;

    @FindBy(css = "[name='brand'] option")
    private List<WebElement> brand;

    @FindBy(css = "[name='model']")
    private WebElement selectModel;

    @FindBy(css = "[name='model'] option")
    private List<WebElement> model;

    @FindBy(css = "[name='variant']")
    private WebElement selectVariant;

    @FindBy(css = "[name='variant'] option")
    private List<WebElement> variant;

    @FindBy(css = ".popup-select-car .red_but")
    private WebElement btnViewDeal;

    @FindBy(css = ".btn-grey.btn-block")
    private WebElement btnPrebook;

    @FindBy(css = ".circle[data-state-value='full_booking']")
    private WebElement fullPayment;

    @FindBy(css = "[name='name']")
    private WebElement inputName;

    @FindBy(css = "[name='email']")
    private WebElement inputEmail;

    @FindBy(css = "[name='phone']")
    private WebElement inputPhone;

    @FindBy(css = ".form-booking .btn-lg")
    private WebElement btnProceed;

    @FindBy(css = "[id='content']")
    private WebElement popupRazorPay;

    public AvpDetailPage navigate() {
        LOGGER.info("Navigate to the AVP Detail page");
        webDriver.navigate().to(AVP_DETAIL_PAGE);
        return this;
    }

    public AvpDetailPage selectColorByIndex(int index) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToTabByIndex(2);
        click(webDriver.findElements(By.cssSelector(".color-list .item")).get(index));
        return this;
    }

    public AvpDetailPage clickViewPriceBreakup() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToTabByIndex(2);
        click(btnViewPriceBreakup);
        return this;
    }

    public AvpDetailPage changeInsuranceType() {
        click(webDriver.findElement(By.cssSelector(".circle[data-state-value='1']")));
        return this;
    }

    public void clickBtnChangeCar() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToTabByIndex(2);
        btnChangeCar.click();
    }

    public void selectBrand(Integer index) {
        selectBrand.click();
        brand.get(index).click();
    }

    public void selectModel(Integer index) {
        selectModel.click();
        model.get(index).click();
    }

    public void selectVariant(Integer index) {
        selectVariant.click();
        variant.get(index).click();
    }

    public AvpDetailPage changeColorAndInsuranceType() {
        LOGGER.info("Select color by Index, click View Price BreakUp and change Insurance type");
        selectColorByIndex(3);
        clickViewPriceBreakup();
        changeInsuranceType();
        return new AvpDetailPage();
    }


    public AvpDetailPage changeAnotherCar() {
        clickBtnChangeCar();
        selectBrand(1);
        selectModel(1);
        selectVariant(1);
        btnViewDeal.click();
        return new AvpDetailPage();
    }

    public AvpDetailPage fillAndSubmitPrebooking(String userName, String userEmail, String userPhone) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnPrebook.click();
        fullPayment.click();
        inputName.sendKeys(userName);
        inputEmail.sendKeys(userEmail);
        inputPhone.sendKeys(userPhone);
        btnProceed.click();
        assertTrue(popupRazorPay.isDisplayed(), "Payment isn't active");
        return this;
    }

}
