package unit;

import core.shared.ParametersManager;
import core.web.WebParametersManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import unit.mock.MockTestCase;

public class ParametersManagerTests {

    MockTestCase mockTestCase;

    @BeforeTest
    public void initMock() {
        mockTestCase = new MockTestCase();
        mockTestCase.init("PROD", "chrome");
    }

    @AfterTest
    public void quitMock() {
        mockTestCase.quit();
    }

    @Test
    public void environment() {
        String environment = "env";
        ParametersManager.setEnvironment(environment);
        Assert.assertEquals(ParametersManager.getEnvironment(), environment);
        ParametersManager.setEnvironment(null);
    }

    @Test
    public void browser() {
        String browser = "browser";
        WebParametersManager.setBrowser(browser);
        Assert.assertEquals(WebParametersManager.getBrowser(), browser);
        WebParametersManager.setBrowser(null);
    }
}
