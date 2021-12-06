package core.web;

import core.Log;
import core.shared.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements Browsers {

    @Override
    public WebDriver init() {
        String path = ConfigManager.getCoreConfig()
                .getWebdrivers()
                .getChrome()
                .getPath();

        System.setProperty("webdriver.chrome.driver", path);
        Log.debug("Starting webdriver, path to webdriver: " + path);
        return new ChromeDriver(getOptions());
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        return options;
    }
}
