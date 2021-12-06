package core.mobile;

import core.shared.ParametersManager;

public class MobileParametersManager extends ParametersManager {

    private static String appPackage;
    private static String appActivity;
    private static String mobileCenterUrl;
    private static String mobileCenterUsername;
    private static String mobileCenterPassword;
    private static String deviceUdid;

    public static String getAppPackage() {
        return appPackage;
    }

    public static void setAppPackage(String appPackage) {
        MobileParametersManager.appPackage = appPackage;
    }

    public static String getAppActivity() {
        return appActivity;
    }

    public static void setAppActivity(String appActivity) {
        MobileParametersManager.appActivity = appActivity;
    }

    public static String getMobileCenterUrl() {
        return mobileCenterUrl;
    }

    public static void setMobileCenterUrl(String mobileCenterUrl) {
        MobileParametersManager.mobileCenterUrl = mobileCenterUrl;
    }

    public static String getMobileCenterUsername() {
        return mobileCenterUsername;
    }

    public static void setMobileCenterUsername(String mobileCenterUsername) {
        MobileParametersManager.mobileCenterUsername = mobileCenterUsername;
    }

    public static String getMobileCenterPassword() {
        return mobileCenterPassword;
    }

    public static void setMobileCenterPassword(String mobileCenterPassword) {
        MobileParametersManager.mobileCenterPassword = mobileCenterPassword;
    }

    public static String getDeviceUdid() {
        return deviceUdid;
    }

    public static void setDeviceUdid(String deviceUdid) {
        MobileParametersManager.deviceUdid = deviceUdid;
    }
}
