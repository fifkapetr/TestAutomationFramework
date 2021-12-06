package core.shared;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import core.Log;
import core.data.mobile.MobileConfigData;
import core.data.mobile.MobileDevicesUdidConfigData;
import core.data.shared.ConfigData;
import core.data.shared.CoreConfigData;
import core.data.shared.SecureConfigData;

public class ConfigManager {

    private static final String[] configPaths = {"coreConfig.yml", "mobileConfig.yml", "mobileDevicesUdids.yml", "Secureconfig.yml"};
    private static final ConfigData[] configData = {new CoreConfigData(), new MobileConfigData(), new MobileDevicesUdidConfigData(), new SecureConfigData()};

    public static void init() {
        Log.debug("Starting ConfigManager() init()");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        for(int i = 0; i < configPaths.length; i++) {
            try {
                Log.debug("Loading YAML configuration from file:" + configPaths[i]);
                getConfigData(mapper, i, configPaths[i]);
                Log.debug("YAML file loaded, content: " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(configData[i]));
            } catch (IOException e) {
                Log.fail("Not possible to read from yml file. Check if " + configPaths[i] + " file is created in resources", e);
            }
        }

    }

    private static void getConfigData(ObjectMapper mapper, int order, String configPath) throws IOException {
        ClassLoader classLoader = ConfigManager.class.getClassLoader();
        configData[order] = mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream(configPath), configData[order].getClass());
    }

    public static CoreConfigData getCoreConfig() {
        return (CoreConfigData) configData[0];
    }

    public static MobileConfigData getMobileConfig() {
        return (MobileConfigData) configData[1];
    }

    public static MobileDevicesUdidConfigData getDevicesUdidConfig() {
        return (MobileDevicesUdidConfigData) configData[2];
    }

    public static SecureConfigData getSecureConfig() {
        return (SecureConfigData) configData[3];
    }
}
