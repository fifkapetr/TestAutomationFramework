package core.data.app;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Applications {
    @JsonProperty
    private Map<String, Environments> applications;
}
