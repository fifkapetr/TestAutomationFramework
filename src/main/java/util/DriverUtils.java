package util;

import core.Log;
import core.data.shared.TestCaseData;
import core.mobile.MobileDriverManager;
import core.shared.TestType;
import core.web.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class DriverUtils {

    public static void takeScreenshot(String filePath) {
        TestType testType = TestCaseData.getTestType();
        if(testType == null) {
            Log.fail("TestCaseData.getTestType() is null. Set this value in testcase init");
        }
        assert testType != null;
        WebDriver driver = getDriver(testType);
        TakesScreenshot scr = (TakesScreenshot) driver;
        File scrFile = scr.getScreenshotAs(OutputType.FILE);
        File destScrFile = new File(filePath);
        try {
            FileUtils.copyFile(scrFile, destScrFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static WebDriver getDriver(TestType testType) {
        WebDriver driver = null;
        switch (testType) {
            case MOBILE:
                driver = MobileDriverManager.getDriverManager().getDriver();
                break;
            case WEB:
                driver = WebDriverManager.getWebDriverManager().getDriver();
                break;
            default:
                Log.fail("TestType in getDriver not found.");
        }
        return driver;
    }
}
