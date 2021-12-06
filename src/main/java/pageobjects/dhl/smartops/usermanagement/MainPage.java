package pageobjects.dhl.smartops.usermanagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class MainPage extends UmHeader {

    public MainPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(addNewUserAnchor));
    }

    @FindBy(how = XPATH, using = "//a[@href='#/users/add-user']")
    private WebElement addNewUserAnchor;

    public UserDetailPage clickNewUserAnchor() {
        addNewUserAnchor.click();
        return new UserDetailPage();
    }

    public MainPage assertName(String name) {
        super.assertName(name);
        return this;
    }
}
