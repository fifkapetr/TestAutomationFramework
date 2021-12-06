package core;

public class Assert {

    public static void assertEquals(String actual, String expected) {
        assertEquals(actual, expected, null);
    }

    public static void assertEquals(String actual, String expected, String message) {
        logAssert(actual, expected, message);
        if (!actual.equals(expected))
            fail(actual, expected, message);
    }

    public static void assertNotNull(Object object) {
        assertNotNull(object, null);
    }

    public static void assertNotNull(Object object, String message) {
        logAssert(object == null ? "null" : object.toString(), "not null", message);
        if (object == null)
            fail("null", "not null", message);
    }

    private static void fail(String actual, String expected, String message) {
        message = message == null ? "" : message + " - ";
        Log.fail(message + getMethodName(2) + " failed. Actual: '" + actual + "' not equals expected: '" + expected + "'");
    }

    private static String getMethodName(int order) {
        order += 1;
        return Thread.currentThread().getStackTrace()[order].getMethodName();
    }

    private static void logAssert(String actual, String expected, String message) {
        Log.debug(getMethodName(2) + ": actual = " + actual + "; expected = " + expected + "; message: " + message);
    }
}
