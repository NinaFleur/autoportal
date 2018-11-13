package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GopLeadsAdmin extends BasePage {

    @FindBy(css = ".field#username")
    private WebElement login;

    @FindBy(css = ".field#password")
    private WebElement password;

    @FindBy(css = ".red_but")
    private WebElement btnLogin;

    @FindBy(css = "tbody tr")
    private List<WebElement> leadsGop;

    public GopLeadsAdmin navigateToAdmin() {
        webDriver.navigate().to("https://autoportal.com/admin/leads");
        return this;
    }

    public GopLeadsAdmin loginAdmin() {
        sendKeys(login, "Nina");
        sendKeys(password, "N1na199i");
        click(btnLogin);
        return this;
    }

    public GopLeadsAdmin navigateToGopRequestTab() {
        webDriver.navigate().to("https://autoportal.com/admin/leads/request/newcars/");
        return this;
    }

    public GopLeadsAdmin checkSavedLead(String userName) {
        leadsGop.stream().filter(lead -> lead.getText().contains(userName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Lead isn't created"));
        return this;
    }
}
