package unit.web;

import core.data.shared.TestCaseData;
import core.shared.ConfigManager;
import core.shared.ParametersManager;
import core.web.WebDriverManager;
import core.web.WebParametersManager;
import org.testng.annotations.Test;
import unit.web.mock.MockTestCase;
import util.DriverUtils;

public class WebDriverTests {

    @Test
    public void testChromeInitAndClean() {
        WebParametersManager.setBrowser("chrome");
        ParametersManager.setEnvironment("PROD");
        ConfigManager.init();
        new WebDriverManager().init()
                .clean();
    }

    @Test
    public void testCaseInit() {
        MockTestCase mockTestCase = new MockTestCase();
        mockTestCase.init("PROD", "chrome");
        mockTestCase.quit();
    }

    @Test
    public void testCaseQuit() {
        MockTestCase mockTestCase = new MockTestCase();
        mockTestCase.init("PROD", "chrome");
        mockTestCase.quit();
    }

    @Test
    public void testCaseQuitBrowserNull() {
        MockTestCase mockTestCase = new MockTestCase();
        mockTestCase.quit();
    }

    @Test
    public void getScreenshotTest() {
        MockTestCase mockTestCase = new MockTestCase();
        mockTestCase.init("PROD", "chrome");
        WebDriverManager.getWebDriverManager().getDriver().get("https://google.com");
        DriverUtils.takeScreenshot(TestCaseData.getRunFolderPath() + "screenshot.png");
        mockTestCase.quit();
    }

}
