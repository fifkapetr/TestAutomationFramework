package core.data.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.data.shared.ConfigData;

import java.util.Map;

public class MobileDevicesUdidConfigData extends ConfigData {

    @JsonProperty
    private Map<String, Workspaces> workspace;

    public Map<String, Workspaces> getWorkspaces() {
            return workspace;
    }
}
