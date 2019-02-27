package listeners;

import client.DriverFactory;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LoggerUtil;

import java.io.IOException;

public class TestListener implements ITestListener {
    protected static final Logger LOGGER = LoggerUtil.getInstance();


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] takeScreenShot() throws IOException {
        LOGGER.info(String.format("Taking screenshot due to fail"));
        return ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
