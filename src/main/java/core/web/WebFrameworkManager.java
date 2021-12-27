package core.web;

import core.data.shared.TestCaseData;
import core.shared.ConfigManager;
import core.shared.FrameworkManager;
import core.shared.RunManager;

import static core.shared.TestType.WEB;

public class WebFrameworkManager implements FrameworkManager {

    @Override
    public void init() {
        new RunManager().createRunFolder("WebTest");
        TestCaseData.setTestType(WEB);
        ConfigManager.init();
        WebDriverManager.getWebDriverManager().init();
    }
}
