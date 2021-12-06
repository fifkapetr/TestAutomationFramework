package core.builder;

import core.PageObjectsManager;

public abstract class StartPage extends WebObject {

    protected <T extends WebObject> T openApplication(T klass) {
        PageObjectsManager pageObjectsManager = new PageObjectsManager();
        pageObjectsManager.initApplication(klass.getClass());
        return klass;
    }
}
