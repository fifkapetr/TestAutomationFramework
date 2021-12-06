package core.web;

import core.shared.ParametersManager;

public class WebParametersManager extends ParametersManager {

    private static String browser;

    public static String getBrowser() {
        return browser;
    }

    public static void setBrowser(String browser) {
        WebParametersManager.browser = browser;
    }
}
