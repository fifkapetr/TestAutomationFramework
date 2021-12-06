package unit.configs;

import core.shared.ConfigManager;
import core.shared.Timeout;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class TimeoutsTest {

    private Map<Timeout, Integer> timeouts;

    @BeforeClass
    public void loadTimeouts() {
        ConfigManager.init();
        timeouts = ConfigManager.getCoreConfig().getTimeouts();
    }

    @Test
    public void timeoutEnumNotNullTest() {
        Assert.assertNotNull(Timeout.values());
    }

    @Test
    public void configAndEnumConsistencyTest() {
        Assert.assertEquals(Timeout.values().length, timeouts.entrySet().size(), "core.shared.Timeout length is different than size of timeouts in coreConfig.yml");
    }

}
