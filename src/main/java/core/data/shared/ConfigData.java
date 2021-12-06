package core.data.shared;

import core.Log;

public abstract class ConfigData {

    protected Object getConfigData(Object obj) {
        if(obj == null) {
            //FIXME: null project does not have class, fix it
            Log.critical("ConfigData object: " + obj.getClass().getName() + "is not set! Check configuration file.");
        }
        return obj;
    }
}
