package core.data.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.data.app.Environments;
import core.data.web.WebDrivers;
import core.shared.Timeout;

import java.util.Map;

public class CoreConfigData extends ConfigData {

    @JsonProperty
    private WebDrivers webdrivers;

    @JsonProperty
    private Map<String, Environments> applications;

    @JsonProperty
    private Map<Timeout, Integer> timeouts;

    public WebDrivers getWebdrivers() {
        return webdrivers;
    }

    public Map<String, Environments> getApplications() {
        return applications;
    }

    public Map<Timeout, Integer> getTimeouts() {
        return timeouts;
    }

}
