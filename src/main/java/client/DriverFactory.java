package client;

import environment.EnvironmentConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.LoggerUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class DriverFactory {

    private static DriverFactory instance = new DriverFactory();

    public static final int SCRIPT_TIME_OUT_WAIT_SECONDS = 3 * 60;
    public static final int PAGE_LOAD_TIME_WAIT_SECONDS = 10 * 60;
    protected static EnvironmentConfigurator environmentConfigurator = EnvironmentConfigurator.getInstance();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>() {

        @Override
        protected RemoteWebDriver initialValue() {
            RemoteWebDriver webDriver = null;
            try {
                ClientType clientType = ClientType.valueOf(EnvironmentConfigurator.getInstance().getTestClient().toUpperCase());
                switch (clientType) {
                    case FF:
                        webDriver = startFirefoxDriver();
                        break;
                    case GC:
                        webDriver = startChromeDriver();
                        break;
                }
            } catch (MalformedURLException e) {
                LoggerUtil.getInstance().error("", e);
            }
            if (environmentConfigurator.isGridUsed()) {
                webDriver.setFileDetector(new LocalFileDetector());
            }

            webDriver.manage().window().fullscreen();
            webDriver.manage().deleteAllCookies();
            webDriver.manage().timeouts().setScriptTimeout(SCRIPT_TIME_OUT_WAIT_SECONDS, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME_WAIT_SECONDS, TimeUnit.SECONDS);
            return webDriver;
        }

        public RemoteWebDriver startChromeDriver() throws MalformedURLException {
            RemoteWebDriver webDriver;
            if (environmentConfigurator.isGridUsed()) {
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                webDriver = (new RemoteWebDriver(new URL(environmentConfigurator.getSeleniumHub()), cap));
                System.setProperty("webdriver.chrome.logfile", System.getProperty("User.dir") + "/chromedriver.log");
            } else {
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    String chromedriverPath = currentThread().getContextClassLoader().getResource("chromedriver").getPath();
                    LoggerUtil.getInstance().warn("webdriver.chrome.driver is not set. will now try to use [" + chromedriverPath + "]");
                    System.setProperty("webdriver.chrome.driver", chromedriverPath);
                }
                webDriver = new ChromeDriver();
            }
            return webDriver;
        }

        public RemoteWebDriver startFirefoxDriver() {
            String geckoDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "geckodriver";
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
            System.setProperty("webdriver.gecko.driver", geckoDriverPath);
            return new FirefoxDriver();
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void closeWebDriver() {
        driver.get().quit();
        driver.remove();
    }
}
