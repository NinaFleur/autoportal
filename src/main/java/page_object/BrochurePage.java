package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static test_data.Urls.BROCHURE_PAGE;

public class BrochurePage extends BaseElement {

    @FindBy(css = ".fa-download")
    private WebElement downloadBrochureElement;

    public void navigateToBrochurePage() {
        webDriver.navigate().to(BROCHURE_PAGE);
    }

    public BrochurePdfPage clickDownloadBrochure() {
        click(downloadBrochureElement);
        return new BrochurePdfPage();
    }
}
