package core.data.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.data.shared.ConfigData;

public class SecureConfigData extends ConfigData {

    @JsonProperty
    private String uftmUsername;

    @JsonProperty
    private String uftmPassword;

    public String getUftmUsername() {
        return (String) getConfigData(uftmUsername);
    }

    public String getUftmPassword() {
        return (String) getConfigData(uftmPassword);
    }
}
