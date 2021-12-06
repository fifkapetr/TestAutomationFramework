package core.builder;

import org.openqa.selenium.WebDriver;

public interface PageObject<R extends WebDriver, T> {

    public R getDriver();
    public T initElements();
}
