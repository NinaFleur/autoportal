package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class DealsPage extends BaseElement {

    @FindBy(css = ".m_b-10 .red_but")
    List<WebElement> btnRequestCallBack;

    public DealsPage checkBtnRequestCallBack() {
        LOGGER.info("check if the \"Request Call Back\" buttons are displayed");
        assertTrue(btnRequestCallBack.get(0).isDisplayed(), "Request CallBack buttons are not displayed");
        return this;
    }
}
