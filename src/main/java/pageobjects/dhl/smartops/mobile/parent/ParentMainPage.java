package pageobjects.dhl.smartops.mobile.parent;

import core.builder.MobileObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.LONG;
import static org.openqa.selenium.support.How.XPATH;

public class ParentMainPage extends MobileObject {

    public ParentMainPage() {
        super();
        wait(LONG).until(ExpectedConditions.visibilityOf(appTitle));
    }

    @FindBy(how = XPATH, using = "//android.widget.TextView[@content-desc='app_title']")
    private WebElement appTitle;
}
