package core;

import core.data.shared.TestCaseData;
import core.shared.ParametersManager;
import core.shared.TestType;
import core.web.WebDriverManager;
import core.web.WebFrameworkManager;
import core.web.WebParametersManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class WebTestCase {

    @BeforeClass
    @Parameters({"environment", "browser"})
    public void init(@Optional("FAT") String environment,
                     @Optional("chrome") String browser) {
        WebParametersManager.setBrowser(browser);
        ParametersManager.setEnvironment(environment);
        TestCaseData.setTestType(TestType.WEB);
        new WebFrameworkManager().init();
    }

    @AfterClass
    public void quit() {
        Log.debug("TestCase.quit() called");
        if(WebDriverManager.getWebDriverManager() != null) {
            Log.debug("driverManager != null, calling driverManager.clean()");
            WebDriverManager.getWebDriverManager().clean();
        }
        else {
            Log.debug("driverManager = null, doing nothing");
        }
    }
}
