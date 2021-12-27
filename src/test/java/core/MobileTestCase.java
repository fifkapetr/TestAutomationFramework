package core;

import core.data.mobile.MobileTestData;
import core.data.shared.SecureConfigData;
import core.data.shared.TestCaseData;
import core.mobile.MobileDriverManager;
import core.mobile.MobileFrameworkManager;
import core.mobile.MobileParametersManager;
import core.shared.ConfigManager;
import core.shared.RunManager;
import core.shared.TestType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;

public abstract class MobileTestCase {

    private static MobileDriverManager driverManager;
    private static AppiumDriverLocalService service;

    @BeforeClass
    @Parameters({"environment","deviceName", "workspaceName"})
    public void init(@Optional("QA") String environment, @Optional("L10AW") String deviceName, @Optional("qa") String workspaceName) {
        new RunManager().createRunFolder("MobileTest");
        TestCaseData.setTestType(TestType.MOBILE);
        new MobileFrameworkManager().init(workspaceName, deviceName);
    }

    @AfterClass
    public void quit() {
        MobileDriverManager.getDriverManager().clean();
    }

    @BeforeSuite
    public void globalSetup() throws IOException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @AfterSuite
    public void globalTearDown() {
        if (service != null) {
            service.stop();
        }
    }

    public URL getServiceUrl() {
        return service.getUrl();
    }
}
