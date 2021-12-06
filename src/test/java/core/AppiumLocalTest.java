package core;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//FIXME: delete after finishing FW
@Deprecated
public class AppiumLocalTest extends MobileTestCase {
    @Test
    public void appiumTest() {
        AndroidDriver<?> wd = null;
        try {
            //Capabilities:
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //Device capabilities—use one or more capabilities
            // User and Password in Mobile Center
            capabilities.setCapability("userName", "pfifka");
            capabilities.setCapability("password", "");
            capabilities.setCapability("platformName", "Android");
            //use any android device
            capabilities.setCapability("platformVersion", ">5.0.1");
            //use version 5.0.1 or above
            capabilities.setCapability("udid", "19025522504414");
            capabilities.setCapability("appPackage", "com.msw_parent");
            capabilities.setCapability("appActivity", "com.dhl.smartops.parent.MainActivity");
            wd = new AndroidDriver<>(new URL("https://mobilecenter.dhl.com/wd/hub"), capabilities);
            //wd = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            System.out.println();

            try {
                WebDriverWait wait = new WebDriverWait(wd, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")));
                wd.findElement(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")).sendKeys("testing testing");
                File srcFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File("C:/users/pfifka/file.jpg"));
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                wd.quit();
            }
        } catch (Exception e) {
            if (wd != null) {
                File srcFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(srcFile, new File("C:/users/pfifka/error.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }
}