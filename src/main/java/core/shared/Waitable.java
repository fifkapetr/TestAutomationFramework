package core.shared;

import org.openqa.selenium.support.ui.WebDriverWait;

public interface Waitable {

    public WebDriverWait wait(Timeout timeout);
}
