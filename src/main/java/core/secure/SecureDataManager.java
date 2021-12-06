package core.secure;
//TODO: add security functionalities to hide psw
public class SecureDataManager {

    private static String uftmUsername;
    private static String uftmPassword;

    public static String getUftmUsername() {
        return uftmUsername;
    }

    public static void setUftmUsername(String uftmUsername) {
        SecureDataManager.uftmUsername = uftmUsername;
    }

    public static String getUftmPassword() {
        return uftmPassword;
    }

    public static void setUftmPassword(String uftmPassword) {
        SecureDataManager.uftmPassword = uftmPassword;
    }
}
