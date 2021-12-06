package pageobjects.dhl.smartops.usermanagement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class UsersListPage extends UmHeader {

    public UsersListPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(usersTableDiv));
    }

    //FIXME: add id
    @FindBy(how = XPATH, using = "//div[@class='users__table']")
    private WebElement usersTableDiv;

    //FIXME: add id
    @FindBy(how = XPATH, using = "//button[@title='Hide']")
    private WebElement closePopup;

    public UsersListPage closePopup() {
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(closePopup));
        closePopup.click();
        return this;
    }

    public UsersListPage assertName(String name) {
        super.assertName(name);
        return this;
    }
}
