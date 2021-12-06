package core.builder;

import core.mobile.MobileDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class MobileObject extends MobileDriverManager implements PageObject<WebDriver, MobileObject> {

    public MobileObject() {
        super();
        initElements();
    }

    @Override
    public MobileObject initElements() {
        PageFactory.initElements(getDriver(), this); //TODO remove this after PageBuilder is finish
        return this;
    }
}
