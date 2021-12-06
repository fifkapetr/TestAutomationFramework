package unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestDataUtil;

public class UtilsTests {

    @Test
    public void generatePinTest() {
        Assert.assertNotNull(TestDataUtil.generatePin());
    }

    @Test
    public void generateUsernameTest() {
        Assert.assertNotNull(TestDataUtil.generateUsername());
    }

    @Test
    public void generatePasswordTest() {
        Assert.assertNotNull(TestDataUtil.generatePassword());
    }
}
