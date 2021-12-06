package core.shared;

public abstract class ParametersManager {

    private static String environment;

    public static String getEnvironment() {
        return environment;
    }

    public static void setEnvironment(String environment) {
        ParametersManager.environment = environment;
    }

}
