package core.web;

import core.shared.ConfigManager;
import core.shared.FrameworkManager;
import core.shared.RunManager;

public class WebFrameworkManager implements FrameworkManager {

    @Override
    public void init() {
        ConfigManager.init();
        WebDriverManager.getWebDriverManager().init();
    }
}
