import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FuckYouRobotTest {

    @Test
    public void Fileupload() throws AWTException, InterruptedException{

        System.setProperty("webdriver.chrome.driver", "/Users/mac/Automation/chromedriver/");
        WebDriver driver = new ChromeDriver();

        // Specify the file location with extension
        StringSelection sel = new StringSelection("/Users/mac/Automation/projects/example");

        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
        System.out.println("selection" +sel);


// Open Monster.com
        driver.get("http://my.monsterindia.com/create_account.html");
        Thread.sleep(2000);

        // This will scroll down the page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0,350)");

// This will click on Browse button
        driver.findElement(By.id("wordresume")).click();

        System.out.println("Browse button clicked");

        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);

// Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

// Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);

//        Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

}

