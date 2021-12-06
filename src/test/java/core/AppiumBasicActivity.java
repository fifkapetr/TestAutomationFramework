package core;


import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasicActivity extends MobileTestCase {
    @Test
    public void appiumTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("deviceName", "MC33");
        capabilities.setCapability("udid", "19205523021049");
        capabilities.setCapability("userName", "pfifka");
        capabilities.setCapability("password", "PeluskovaPraha6105#");
        capabilities.setCapability("appPackage", "com.msw_parent");
        capabilities.setCapability("appActivity", "com.dhl.smartops.parent.MainActivity");
        //AndroidDriver<?> driver = new AndroidDriver<>(new URL("https://mobilecenter.dhl.com:8080/wd/hub"), capabilities);
        AndroidDriver<?> wd = new AndroidDriver<>(new URL("https://mobilecenter.dhl.com/wd/hub"), capabilities);
        try {
            WebDriverWait wait = new WebDriverWait(wd, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")));
            wd.findElement(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")).sendKeys("testing testing");
            File srcFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("file.jpg"));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            wd.quit();
        }
    }
}