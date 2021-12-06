package core.data.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.data.shared.ConfigData;

public class MobileConfigData extends ConfigData {

    @JsonProperty
    private String appPackage;

    @JsonProperty
    private String appActivity;

    @JsonProperty
    private String mobileCenterUrl;

    @JsonProperty
    private String mobileCenterOauthId;

    @JsonProperty
    private String mobileCenterOauthSecret;

    @JsonProperty
    private String mobileCenterTenantId;

    public String getMobileCenterOauthId() {
        return mobileCenterOauthId;
    }

    public String getMobileCenterOauthSecret() {
        return mobileCenterOauthSecret;
    }

    public String getMobileCenterTenantId() {
        return mobileCenterTenantId;
    }

    public String getAppPackage() {
        return (String) getConfigData(appPackage);
    }

    public String getAppActivity() {
        return (String) getConfigData(appActivity);
    }

    public String getMobileCenterUrl() {
        return (String) getConfigData(mobileCenterUrl);
    }
}
