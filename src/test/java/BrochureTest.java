import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BrochurePage;
import pageobjects.BrochurePdfPage;

public class BrochureTest extends BaseTest {


    private BrochurePage brochurePage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        brochurePage = new BrochurePage();
        brochurePage.navigateToBrochurePage();
    }

    @Test(description = "Download PDF Brochure")
    public void downloadPdfBrochure() {
        brochurePage
                .clickDownloadBrochure();
        new BrochurePdfPage()
                .savePdfFile();
    }


    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}
