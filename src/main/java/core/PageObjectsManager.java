package core;

import core.builder.WebObject;
import core.data.app.Environments;
import core.annotations.Application;
import core.shared.ConfigManager;
import core.shared.ParametersManager;
import core.web.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PageObjectsManager {

    //FIXME init is run when it should not to
    public <T extends WebObject> void initApplication(Class<T> klass) {
        WebDriver driver = WebDriverManager.getWebDriverManager().getDriver();
        Application application = klass.getAnnotation(Application.class);

        if (application == null) {
            Log.fail("@Application() is not set above class in your init PageObject");
        }
        String environment = ParametersManager.getEnvironment();
        String applicationName = application.value();

        Map<String, Environments> appMap = ConfigManager.getCoreConfig().getApplications();
        String url = appMap.entrySet()
                .stream()
                .filter(map -> applicationName.equals(map.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(e -> e.getEnvironments().entrySet().stream())
                .filter(map -> map.getKey().equals(environment))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("URL of application: " + applicationName + " with env: " + environment + " is not found in YAML. Please check config and definition of init class"));
        Log.debug("Opening application: " + application.value() + ", url: " + url);
        driver.get(url);
    }
}
