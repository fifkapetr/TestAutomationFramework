package core;

import core.data.shared.TestCaseData;
import core.shared.RunManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class RunManagerTests {

    String testType = "UnitTest";

    @Test
    public void generatedRunFolderNameNotNull() {
        RunManager runManager = new RunManager();
        String path = runManager.generateRunFolderName(testType);
        Assert.assertNotNull(path);
    }

    @Test
    public void getRunFolderPathNotNull() {
        RunManager runManager = new RunManager();
        runManager.createRunFolder(testType);
        Assert.assertNotNull(TestCaseData.getRunFolderPath());
    }

    @Test
    public void getRunFolderPathNotNullCreateNotCalled() {
        Assert.assertNotNull(TestCaseData.getRunFolderPath());
    }

    @Test
    public void generatedFolderExists() {
        RunManager runManager = new RunManager();
        runManager.createRunFolder(testType);
        Assert.assertTrue(new File(TestCaseData.getRunFolderPath()).exists());
    }

}
