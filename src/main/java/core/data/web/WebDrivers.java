package core.data.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebDrivers {

    @JsonProperty
    private ChromeDriver chrome;

    @JsonProperty
    private FirefoxDriver firefox;

    @JsonProperty
    private EdgeDriver edge;

    @JsonProperty
    private SafariDriver safari;

    public ChromeDriver getChrome() {
        return chrome;
    }

    public FirefoxDriver getFirefox() {
        return firefox;
    }

    public EdgeDriver getEdge() {
        return edge;
    }

    public SafariDriver getSafari() {
        return safari;
    }


}
