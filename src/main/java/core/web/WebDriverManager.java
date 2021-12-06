package core.web;

import core.shared.DriverManager;
import core.shared.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager implements DriverManager<WebDriverManager, WebDriver> {

    private static WebDriver driver;
    private static WebDriverManager webDriverManager;
    private static Wait wait;

    @Override
    public WebDriverManager init() {
        switch (WebParametersManager.getBrowser()) {
            case "chrome":
                driver = new ChromeBrowser().init();
                break;
        }
        WebDriverManager.webDriverManager = this;
        wait = new Wait(driver);
        return this;
    }

    @Override
    public WebDriver getDriver() {
        return WebDriverManager.driver;
    }

    public WebDriverManager clean() {
        WebDriverManager.driver.quit();
        return this;
    }

    @Override
    public WebDriverWait wait(Timeout timeout) {
        return wait.wait(timeout);
    }

    public static WebDriverManager getWebDriverManager() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }
}
