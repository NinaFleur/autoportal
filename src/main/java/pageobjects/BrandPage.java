package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageelements.GopPopUp;

import java.util.ArrayList;
import java.util.List;

import static testdata.Urls.BRAND_PAGE;

public class BrandPage extends BaseElement {

    private GopPopUp gopPopUp;

    @FindBy(xpath = "//*[@class='model-list__title']")
    private List<WebElement> modelNames;

    @FindBy(xpath = ".//*[@id='content']//a[@class='btn-border-red btn-block model-list__btn']")
    private List<WebElement> btnBrandGop;

    public void navigateToBrandPage() {
        webDriver.navigate().to(BRAND_PAGE);
    }

    private List<String> getModelTitles() {
        List<String> modelNameTitles = new ArrayList<>();
        for (WebElement model : modelNames) {
            modelNameTitles.add(model.getText());
        }
        return modelNameTitles;
    }

    public GopPopUp clickBrandGopBtn(String modelName) {
        List<String> titles = getModelTitles();
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).equals(modelName)) {
                click(btnBrandGop.get(i));
                break;
            }
        }
        return gopPopUp;
    }






}
