package client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static DriverFactory instance = new DriverFactory();

    public static final int SCRIPT_TIME_OUT_WAIT_SECONDS = 3 * 60;
    public static final int PAGE_LOAD_TIME_WAIT_SECONDS = 10 * 60;

    public static DriverFactory getInstance(){
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {

        @Override
        protected WebDriver initialValue() {
            WebDriver webDriver = null;
            ClientType clientType = ClientType.GC;
            switch (clientType) {
                case GC:
                    webDriver = startChromeDriver();
                    break;
            }

            webDriver.manage().window().fullscreen();
            webDriver.manage().deleteAllCookies();
            webDriver.manage().timeouts().setScriptTimeout(SCRIPT_TIME_OUT_WAIT_SECONDS, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME_WAIT_SECONDS, TimeUnit.SECONDS);
            return webDriver;
        }

        public WebDriver startChromeDriver() {
            String chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            return new ChromeDriver();
        }
    };

    public WebDriver getDriver(){
        return driver.get();
    }

    public void closeWebDriver(){
        driver.get().quit();
        driver.remove();
    }
}
