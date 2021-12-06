package unit.web;

import core.web.WebDriverManager;
import core.shared.ParametersManager;
import core.web.WebParametersManager;
import org.testng.annotations.Test;
import unit.web.mock.MockTestCase;

public class WebDriverTests {

    @Test
    public void testChromeInitAndClean() {
        WebParametersManager.setBrowser("chrome");
        new WebDriverManager().init()
                .clean();
    }

    @Test
    public void testCaseInit() {
        MockTestCase mockTestCase = new MockTestCase();
        mockTestCase.init("PROD", "chrome");
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


}
