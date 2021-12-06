package core.web;

import core.shared.ConfigManager;
import core.shared.Timeout;
import core.shared.Waitable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Wait implements Waitable {

    private WebDriver driver;
    public Map<Timeout, WebDriverWait> waits;
    public Map<Timeout, Integer> timeouts;

    public Wait(WebDriver driver) {
        this.driver = driver;
        waits = new HashMap<>();
        timeouts = ConfigManager.getCoreConfig().getTimeouts();
        Stream.of(Timeout.values())
                .forEach(v -> waits.put(v, new WebDriverWait(driver, timeouts.get(v))));
    }

    @Override
    public WebDriverWait wait(Timeout timeout) {
        return waits.get(timeout);
    }

}
