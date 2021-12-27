package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String getCurrentTimestampWithFormat(String format) {
        Long time = new Date().getTime();
        return new SimpleDateFormat(format).format(time);
    }
}
