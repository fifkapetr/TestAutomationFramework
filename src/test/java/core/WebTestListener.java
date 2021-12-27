package core;

import core.data.shared.TestCaseData;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.DriverUtils;
import util.Utils;

public class WebTestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.fail("Test: " + iTestResult.getTestName() + "failed. Getting screenshot");
        DriverUtils.takeScreenshot(TestCaseData.getRunFolderPath() + "FailureScreenshot " + Utils.getCurrentTimestampWithFormat("yyyy-MM-dd HH:mm:ss") + ".png");
    }
}
