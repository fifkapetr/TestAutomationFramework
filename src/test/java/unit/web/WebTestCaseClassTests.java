package unit.web;

import core.WebTestCase;
import core.web.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTestCaseClassTests extends WebTestCase {

    @Test
    public void openGoogle() {
        WebDriver driver = WebDriverManager.getWebDriverManager().getDriver();
        String googleUrl = "https://www.google.com/";
        driver.get(googleUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Google']")));
        Assert.assertEquals(driver.getCurrentUrl(), googleUrl);
    }
}
