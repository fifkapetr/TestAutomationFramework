package core.data.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Workspaces {

    @JsonProperty
    private Map<String, String> device;

    public Map<String, String> getDevices() {
        return device;
    }
}
