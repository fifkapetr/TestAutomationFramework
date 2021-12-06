package pageobjects.inventiweb;

import core.Component;
import core.Log;
import core.builder.WebObject;

public class SomeComponent<T extends WebObject> extends Component<T> {

    public SomeComponent(T klass) {
        super(klass);
    }

    public SomeComponent<T> doSomethingInComponent() {
        Log.info("DO SOMETHING!");
        return this;
    }
}
