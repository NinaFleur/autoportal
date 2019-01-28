import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class RobotTest extends BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
//    private static String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "example";


    @BeforeMethod
    public void setup() {
        String chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        File file = new File("/Users/mac/Automation/projects/example");
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static void uploadFile(String file) {
        try {
            //Setting clipboard with file location
            setClipboardData(file);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
//    public void robotTest() throws InterruptedException {
//        //Click Image Upload
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.fileinput-button")));
//        driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
//        uploadFileWithRobot(file);
//        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.cssSelector(".name"))).getText().equals("example"));
//        //I added sleep to see the result with my eyes. If you want you can remove below line.
//        Thread.sleep(2000);
//    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    //File upload by Robot Class
//    public void uploadFileWithRobot(String imagePath) {
//        StringSelection stringSelection = new StringSelection(imagePath);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, null);
//
//        Robot robot = null;
//
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//
//        robot.delay(250);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.delay(150);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//    }
}