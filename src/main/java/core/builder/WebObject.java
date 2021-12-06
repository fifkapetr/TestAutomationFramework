package core.builder;

import core.web.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebObject extends WebDriverManager implements PageObject<WebDriver, WebObject> {

    public WebObject() {
        super();
        initElements();
    }

    @Override
    public WebObject initElements() {
        PageFactory.initElements(getDriver(), this); //TODO remove this after PageBuilder is finish
//        PageBuilder<?> pageBuilder = new PageBuilder(this);
//        pageBuilder.initElements();
//        PageFactory.initElements(getDriver(), this);
        return this;
    }
}
