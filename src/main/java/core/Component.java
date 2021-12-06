package core;

import core.builder.WebObject;

public class Component <T extends WebObject> extends WebObject {
    private T klass;

    public Component(T klass) {
        this.klass = klass;
    }

    public T leaveComponent() {
        return klass;
    }

    //TODO add wrapper path
}
