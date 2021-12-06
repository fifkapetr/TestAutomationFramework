package core.shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @param <T> use current className
 * @param <R> Use WebDriver/AndroidDriver depended on type of manager which you are using
 */
public interface DriverManager<T, R extends WebDriver> {

    public R getDriver();
    public T init();
    public T clean();
    public WebDriverWait wait(Timeout timeout);

}
