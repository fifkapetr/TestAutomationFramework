package core.mobile;

import core.Log;
import core.data.mobile.MobileConfigData;
import core.data.shared.SecureConfigData;
import core.secure.SecureDataManager;
import core.shared.ConfigManager;
import core.shared.DriverManager;
import core.shared.Timeout;
import core.web.Wait;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverManager implements DriverManager<MobileDriverManager, AndroidDriver<?>> {
    private static MobileDriverManager driverManager;
    private DesiredCapabilities capabilities;
    private MobileConfigData mobileConfig;
    private SecureConfigData secureConfig;
    private static AndroidDriver<?> driver;
    private static Wait wait;

    @Override
    public AndroidDriver<?> getDriver() {
        return MobileDriverManager.driver;
    }

    @Override
    public MobileDriverManager init() {
        MobileDriverManager.driverManager = this;
        this.setConfigs()
                .setParameters()
                .setCapabilities();
        try {
            MobileDriverManager.driver = new AndroidDriver<>(new URL(MobileParametersManager.getMobileCenterUrl()), capabilities);
        } catch (MalformedURLException e) {
            Log.critical("MalformedURLException in MobileDriverManager init()", e);
        }
        wait = new Wait(driver);
        return this;
    }

    private MobileDriverManager setCapabilities() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("oauthClientId", ConfigManager.getMobileConfig().getMobileCenterOauthId());
        capabilities.setCapability("oauthClientSecret", ConfigManager.getMobileConfig().getMobileCenterOauthSecret());
        capabilities.setCapability("tenantId", ConfigManager.getMobileConfig().getMobileCenterTenantId());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", MobileParametersManager.getDeviceUdid());
        capabilities.setCapability("appPackage", MobileParametersManager.getAppPackage());
        capabilities.setCapability("appActivity", MobileParametersManager.getAppActivity());
        return this;
    }

    private MobileDriverManager setParameters() {
        MobileParametersManager.setAppActivity(mobileConfig.getAppActivity());
        MobileParametersManager.setAppPackage(mobileConfig.getAppPackage());
        MobileParametersManager.setMobileCenterUrl(mobileConfig.getMobileCenterUrl());
        SecureDataManager.setUftmUsername(secureConfig.getUftmUsername());
        SecureDataManager.setUftmUsername(secureConfig.getUftmPassword());
        return this;
    }

    @Override
    public MobileDriverManager clean() {
        if(driver != null) {
            driver.quit();
        }
        return this;
    }

    public MobileDriverManager setConfigs() {
        mobileConfig = ConfigManager.getMobileConfig();
        secureConfig = ConfigManager.getSecureConfig();
        return this;
    }

    public static MobileDriverManager getDriverManager() {
        if (driverManager == null) {
            return new MobileDriverManager();
        }
        return driverManager;
    }

    @Override
    public WebDriverWait wait(Timeout timeout) {
        return wait.wait(timeout);
    }
}
