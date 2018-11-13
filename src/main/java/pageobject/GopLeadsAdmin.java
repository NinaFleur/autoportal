package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GopLeadsAdmin extends BasePage {

    @FindBy(css = "tbody tr")
    private List<WebElement> leadsGop;

    public GopLeadsAdmin navigate() {
        webDriver.navigate().to("https://Nina:N1na199i@autoportal.com/admin/leads/request/newcars/");
        return this;
    }

    public GopLeadsAdmin checkSavedLead(String userName) {
        leadsGop.stream().filter(lead->lead.getText().contains(userName))
                .findFirst()
                .orElseThrow(()-> new AssertionError("Lead isn't created"));
        return  this;
    }
}
