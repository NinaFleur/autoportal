package pageobject;

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
    private WebElement fillInNameInput;

    @FindBy(css = ".form-lead [name='phone']")
    private WebElement fillInPhoneInput;

    @FindBy(css = ".form-lead [name='gop_type_address']")
    private WebElement fillInLocationInput;

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
            }
            break;
        }
        return this;
    }
}
