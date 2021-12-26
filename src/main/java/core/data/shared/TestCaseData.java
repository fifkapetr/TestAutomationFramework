package core.data.shared;

import core.Log;
import core.shared.TestType;
import lombok.Getter;
import lombok.Setter;


public class TestCaseData {
    @Getter
    @Setter
    private static TestType testType;

    @Setter
    private static String runFolderPath;

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
