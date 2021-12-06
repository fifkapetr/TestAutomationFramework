package unit;

import core.Assert;
import org.testng.annotations.Test;

public class AssertsTest {

    @Test
    public void assertEqualsPositive() {
        Assert.assertEquals("positive", "positive");
    }

    @Test
    public void assertEqualsNegative() {
        org.testng.Assert.assertThrows(RuntimeException.class, () -> Assert.assertEquals("positive", "negative"));
    }

    @Test
    public void assertEqualsPositiveWithMessage() {
        org.testng.Assert.assertThrows(RuntimeException.class, () -> Assert.assertEquals("negative", "positive", "test message"));
    }

    @Test
    public void assertNotNullPositiveTest() {
        Assert.assertNotNull("Test not null");
    }

    @Test
    public void assertNotNullNegativeTest() {
        org.testng.Assert.assertThrows(RuntimeException.class, () -> Assert.assertNotNull(null));
    }

    @Test
    public void assertNotNullWithMessagePositiveTest() {
        Assert.assertNotNull("Test not null", "Message test");
    }

    @Test
    public void assertNotNullWithMessageNegativeTest() {
        org.testng.Assert.assertThrows(RuntimeException.class, () -> Assert.assertNotNull(null, "Message test"));
    }

}
