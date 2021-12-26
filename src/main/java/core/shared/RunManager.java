package core.shared;

import core.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunManager {

    private static String runFolderPath;

    public String generateRunFolderName(String testType) {
        Long time = new Date().getTime();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(time);
        String dirName = testType + " " + timestamp;
        Log.debug("Run folder name was generated: " + dirName);
        return dirName;
    }

    public void createRunFolder(String testType) {
        RunManager.runFolderPath = "target/test-results/" + generateRunFolderName(testType);
        new File(getRunFolderPath()).mkdirs();
    }

    public static String getRunFolderPath() {
        String path;
        if (runFolderPath != null) {
            path = runFolderPath;
        } else {
            Log.warn("runFolderPath is null. Probably not set.");
            path = "";
        }
        return path;
    }
}
