package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static testdata.Urls.BROCHURE_PAGE;

public class BrochurePage extends BaseElement {

    @FindBy(css = ".fa-download")
    private WebElement downloadBrochureElement;

    @Step("Navigate to the Brochure page")
    public void navigate() {
        LOGGER.info("Navigate to the Brochure page");
        webDriver.navigate().to(BROCHURE_PAGE);
    }

    @Step("Click the Download brochure button")
    public BrochurePdfPage clickDownloadBrochure() {
        LOGGER.info("Click the Download brochure btn");
        click(downloadBrochureElement);
        return new BrochurePdfPage();
    }
}
