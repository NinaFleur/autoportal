package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static testdata.Urls.*;

public class LeadsAdmin extends BaseElement {

    @FindBy(css = ".field#username")
    private WebElement login;

    @FindBy(css = ".field#password")
    private WebElement password;

    @FindBy(css = ".red_but")
    private WebElement btnLogin;

    @FindBy(css = "tbody tr")
    private List<WebElement> leads;

    @Step("Navigate to Admin page")
    public LeadsAdmin navigateToAdmin() {
        LOGGER.info("Navigate to Admin page");
        webDriver.navigate().to(BASE_ADMIN_URL);
        return this;
    }

    @Step("Login Admin page")
    public LeadsAdmin loginAdmin() {
        LOGGER.info("Login Admin page");
        sendKeys(login, "Behat");
        sendKeys(password, "123456");
        click(btnLogin);
        return this;
    }

    @Step("Navigate to the GOP Request tab")
    public LeadsAdmin navigateToGopRequestTab() {
        LOGGER.info("Navigate to the GOP Request tab");
        webDriver.navigate().to(ADMIN_GOP_LEADS);
        return this;
    }

    @Step("Navigate to the Booking Request tab")
    public LeadsAdmin navigateToBookingRequestTab() {
        LOGGER.info("Navigate to the Booking Request tab");
        webDriver.navigate().to(ADMIN_BOOKING_LEADS);
        return this;
    }

    @Step("Check if Lead is created")
    public LeadsAdmin checkSavedLead(String userName) {
        LOGGER.info("Check if Lead is created");
        leads.stream().filter(lead -> lead.getText().contains(userName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Lead isn't created"));
        return this;
    }
}
