package pageobjects.dhl.smartops.mobile.parent;

import core.mobile.MobileDriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HomePage {

    //TODO: delete after development
    @Deprecated
    public void parentTest() {
        AndroidDriver<?> driver = MobileDriverManager.getDriverManager().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")));
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"login_input1\"]")).sendKeys("testing testing");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(srcFile, new File("C:/users/pfifka/file.jpg"));
    }
}
