package core.shared;

import core.Log;
import core.data.shared.TestCaseData;
import util.Utils;

import java.io.File;

public class RunManager {

    public String generateRunFolderName(String testType) {
        String dirName = testType + " " + Utils.getCurrentTimestampWithFormat("yyyy-MM-dd HH:mm:ss,SSS");
        Log.debug("Run folder name was generated: " + dirName);
        return dirName;
    }

    public void createRunFolder(String testType) {
        TestCaseData.setRunFolderPath("target/test-results/" + generateRunFolderName(testType) + "/");
        new File(TestCaseData.getRunFolderPath()).mkdirs();
    }


}
