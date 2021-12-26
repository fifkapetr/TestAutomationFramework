package core.shared;

import core.Log;
import core.data.shared.TestCaseData;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunManager {

    public String generateRunFolderName(String testType) {
        Long time = new Date().getTime();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(time);
        String dirName = testType + " " + timestamp;
        Log.debug("Run folder name was generated: " + dirName);
        return dirName;
    }

    public void createRunFolder(String testType) {
        TestCaseData.setRunFolderPath("target/test-results/" + generateRunFolderName(testType));
        new File(TestCaseData.getRunFolderPath()).mkdirs();
    }


}
