package core.mobile;

import core.shared.ConfigManager;
import core.shared.FrameworkManager;

public class MobileFrameworkManager {

    public void init(String workspaceName, String deviceName) {
        ConfigManager.init();
        MobileParametersManager.setDeviceUdid(ConfigManager.getDevicesUdidConfig().getWorkspaces().get(workspaceName).getDevices().get(deviceName));
        MobileDriverManager.getDriverManager().init();
    }
}
