package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnRoadPricePage extends BasePage {

    public void navigate() {
        webDriver.navigate().to("https://autoportal.com/onroadprice.html");
    }

    @FindBy(css = ".form-lead [name='brand']")
    private WebElement selectBrandDropDown;

    @FindBy(css = ".form-lead [name='brand'] option")
    private List<WebElement> brands;

    @FindBy(css = ".form-lead [name='model']")
    private WebElement selectModelDropDown;

    @FindBy(css = ".form-lead [name='model'] option")
    private List<WebElement> models;

    @FindBy(css = ".form-lead [name='name']")
    private WebElement inputName;

    @FindBy(css = ".form-lead [name='phone']")
    private WebElement inputPhone;

    @FindBy(css = ".form-lead [name='gop_type_address']")
    private WebElement inputLocation;

    @FindBy(css = ".form-lead [name='purchaseDate']")
    private WebElement purchasePeriodDropDown;

    @FindBy(css = ".form-lead [name='purchaseDate'] option")
    private List<WebElement> purchaseDates;

    @FindBy(css = ".form-lead .red_but.cell-sm")
    private WebElement btnProceed;

    public OnRoadPricePage selectBrand(String brandName) {
        click(selectBrandDropDown);
        for (WebElement brand : brands) {
            if (brand.getText().equals(brandName)) {
                click(brand);
                break;
            }
        }
        return this;
    }

    public OnRoadPricePage selectModel(String modelName) {
        click(selectModelDropDown);
        for (WebElement model : models) {
            if (model.getText().equals(modelName)) {
                click(model);
                break;
            }
        }
        return this;
    }

    public OnRoadPricePage fillInInputName(String userName) {
        sendKeys(inputName, userName);
        return this;
    }

    public OnRoadPricePage fillInInputPhone(String userPhone) {
        sendKeys(inputPhone, userPhone);
        return this;
    }

    public OnRoadPricePage fillInInputLocation(String userLocation) {
        sendKeys(inputLocation, userLocation);
        waitForVisibilityBy(By.cssSelector(".ui-state-highlight"));
        webDriver.findElements(By.cssSelector(".ui-state-highlight")).get(0).click();
        return this;
    }

    public OnRoadPricePage selectPurchasePeriod(String purchaseDate) {
        click(purchasePeriodDropDown);
        for (WebElement date : purchaseDates) {
            if (date.getText().equals(purchaseDate)) {
                click(date);
                break;
            }
        }
        return this;
    }

    public GetOnRoadPriceResultPage clickBtnProceed() {
        click(btnProceed);
        return  new GetOnRoadPriceResultPage();
    }

}
