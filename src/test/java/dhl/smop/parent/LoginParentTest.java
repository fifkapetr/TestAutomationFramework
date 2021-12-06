package dhl.smop.parent;

import core.MobileTestCase;
import core.mobile.MobileDriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LoginParentTest extends MobileTestCase {

    @Test
    public void login() {
        AndroidDriver<?> wd = MobileDriverManager.getDriverManager().getDriver();
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")));
        wd.findElement(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")).sendKeys("testing testing");
        File srcFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("C:/users/pfifka/file.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
