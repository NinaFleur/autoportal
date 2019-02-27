package pageobjects;

import io.qameta.allure.Step;
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

    @Step("Navigate to the AVP Detail page")
    public AvpDetailPage navigate() {
        LOGGER.info("Navigate to the AVP Detail page");
        webDriver.navigate().to(AVP_DETAIL_PAGE);
        return this;
    }

    @Step("Select color by index")
    public AvpDetailPage selectColorByIndex(int index) {
        LOGGER.info("Select color by index");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToTabByIndex(2);
/*
        waitForPageLoad(webDriver);
*/
        click(webDriver.findElements(By.cssSelector(".color-list .item")).get(index));
        return this;
    }

    @Step("Click on the \"View Price Breakup\" button")
    public AvpDetailPage clickViewPriceBreakup() {
        LOGGER.info("Click View Price Breakup button");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*
        waitForPageLoad(webDriver);
*/
        switchToTabByIndex(2);
        click(btnViewPriceBreakup);
        return this;
    }

    @Step("Change insurance type")
    public AvpDetailPage changeInsuranceType() {
        LOGGER.info("Change insurance type");
        click(webDriver.findElement(By.cssSelector(".circle[data-state-value='1']")));
        return this;
    }

    @Step("Click on the \"Change Car\" button")
    public void clickBtnChangeCar() {
        LOGGER.info("Click on the \"Change Car\" button");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToTabByIndex(2);
        btnChangeCar.click();
    }

    @Step("Select AVP brand")
    public void selectBrand(Integer index) {
        LOGGER.info("Select AVP brand");
        selectBrand.click();
        brand.get(index).click();
    }

    @Step("Select AVP model")
    public void selectModel(Integer index) {
        LOGGER.info("Select AVP model");
        selectModel.click();
        model.get(index).click();
    }

    @Step("Select AVP variant")
    public void selectVariant(Integer index) {
        LOGGER.info("Select AVP variant");
        selectVariant.click();
        variant.get(index).click();
    }

    @Step("Select color by index, click the \"View Price Breakup\" button and change Insurance type")
    public AvpDetailPage changeColorAndInsuranceType() {
        LOGGER.info("Select color by Index, click View Price BreakUp and change Insurance type");
        selectColorByIndex(3);
        clickViewPriceBreakup();
        changeInsuranceType();
        return new AvpDetailPage();
    }


    @Step("Change AVP model by clicking the \"Change Car\" button and submitting the form")
    public AvpDetailPage changeAnotherCar() {
        LOGGER.info("Change AVP model by clicking the \"Change Car\" button and submitting the form");
        clickBtnChangeCar();
        selectBrand(1);
        selectModel(1);
        selectVariant(1);
        btnViewDeal.click();
        return new AvpDetailPage();
    }

    @Step("Open the Pre-booking pop-up, fill in the form, submit it")
    public AvpDetailPage fillAndSubmitPrebooking(String userName, String userEmail, String userPhone) {
        LOGGER.info("Open Pre-booking pop-up, fill in the form, submit it");
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
