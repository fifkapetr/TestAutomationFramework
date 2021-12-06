package unit.configs;

import core.shared.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConfigTests {

    @BeforeClass
    public void loadConfigs() {
        ConfigManager.init();
    }

    @Test
    public void ChromePathTest() {
        Assert.assertNotNull(ConfigManager.getCoreConfig().getWebdrivers().getChrome());
    }

    @Test
    public void FirefoxPathTest() {
        Assert.assertNotNull(ConfigManager.getCoreConfig().getWebdrivers().getFirefox());
    }

    @Test
    public void SafariPathTest() {
        Assert.assertNotNull(ConfigManager.getCoreConfig().getWebdrivers().getSafari());
    }

    @Test
    public void EdgePathTest() {
        Assert.assertNotNull(ConfigManager.getCoreConfig().getWebdrivers().getEdge());
    }

    @Test
    public void coreConfigNotNull() {
        Assert.assertNotNull(ConfigManager.getCoreConfig());
    }

    @Test
    public void mobileConfigNotNull() {
        Assert.assertNotNull(ConfigManager.getMobileConfig());
    }

    @Test
    public void secureConfigNotNull() {
        Assert.assertNotNull(ConfigManager.getSecureConfig());
    }

    @Test
    public void devicesUdidConfigNotNull() {
        Assert.assertNotNull(ConfigManager.getDevicesUdidConfig());
    }
}
