package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static testdata.Urls.ADMIN_BOOKING_LEADS;
import static testdata.Urls.ADMIN_GOP_LEADS;
import static testdata.Urls.BASE_ADMIN_URL;

public class LeadsAdmin extends BaseElement {

    @FindBy(css = ".field#username")
    private WebElement login;

    @FindBy(css = ".field#password")
    private WebElement password;

    @FindBy(css = ".red_but")
    private WebElement btnLogin;

    @FindBy(css = "tbody tr")
    private List<WebElement> leads;

    public LeadsAdmin navigateToAdmin() {
        webDriver.navigate().to(BASE_ADMIN_URL);
        return this;
    }

    public LeadsAdmin loginAdmin() {
        sendKeys(login, "Behat");
        sendKeys(password, "123456");
        click(btnLogin);
        return this;
    }

    public LeadsAdmin navigateToGopRequestTab() {
        webDriver.navigate().to(ADMIN_GOP_LEADS);
        return this;
    }

    public LeadsAdmin navigateToBookingRequestTab() {
        webDriver.navigate().to(ADMIN_BOOKING_LEADS);
        return this;
    }

    public LeadsAdmin checkSavedLead(String userName) {
        leads.stream().filter(lead -> lead.getText().contains(userName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Lead isn't created"));
        return this;
    }
}
