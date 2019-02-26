import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.storePageTitlesInFile;

public class WriteReadFileTest extends BaseTest {

    private HomePage homePage;
    private BrandPage brandPage;
    private BrochurePage brochurePage;
    private OnRoadPricePage onRoadPricePage;
    private ModelPage modelPage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        homePage = new HomePage();
        brandPage = new BrandPage();
        brochurePage = new BrochurePage();
        onRoadPricePage = new OnRoadPricePage();
        modelPage = new ModelPage();
    }

    @Test(description = "Get 5 page titles and save them to the file.txt")
    public void getPageTitles() {
        List<String> pageTitles = new ArrayList<>();
        homePage.navigate();
        pageTitles.add("Home Page title is: " + homePage.getPageTitle());
        brandPage.navigateTo("https://autoportal.com/newcars/honda/");
        pageTitles.add("Brand Page title is: " + brandPage.getPageTitle());
        brochurePage.navigate();
        pageTitles.add(("Brochure Page title is: " + brochurePage.getPageTitle()));
        onRoadPricePage.navigate();
        pageTitles.add(("OnroadPrice Page title is: " + onRoadPricePage.getPageTitle()));
        modelPage.navigateTo("https://autoportal.com/newcars/honda/wrv/");
        pageTitles.add("Model Page title is: " + modelPage.getPageTitle());
        storePageTitlesInFile(pageTitles.toString());
    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}