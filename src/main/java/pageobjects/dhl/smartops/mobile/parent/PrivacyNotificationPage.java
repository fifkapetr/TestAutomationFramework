package pageobjects.dhl.smartops.mobile.parent;

import core.builder.MobileObject;
import core.shared.Timeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.How.XPATH;

public class PrivacyNotificationPage extends MobileObject {

    public PrivacyNotificationPage() {
        super();
        wait(Timeout.LONG).until(ExpectedConditions.visibilityOf(agreeButton));
    }

    @FindBy(how = XPATH, using = "//android.view.ViewGroup[@content-desc='accept']")
    private WebElement agreeButton;

    public ParentMainPage clickAccept() {
        agreeButton.click();
        return new ParentMainPage();
    }
}
