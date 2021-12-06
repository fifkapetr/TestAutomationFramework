package pageobjects.dhl.smartops.usermanagement;

import core.Assert;
import core.builder.WebObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.XPATH;

public class UmHeader extends WebObject {

    public UmHeader() {
        super();
    }

    //FIXME: add id
    @FindBy(how = XPATH, using = "//a[@class='logo']")
    private WebElement logoAnchor;

    //FIXME: replace with id
    @FindBy(how = XPATH, using = "//button[@title='Logout']")
    private WebElement logout;

    //FIXME: replace with id
    @FindBy(how = XPATH, using = "//div[@class='profile__name']")
    private WebElement profileNameDiv;

    public UserManagementLoginPage logout() {
        logout.click();
        return new UserManagementLoginPage(true);
    }

    public UmHeader assertName(String name) {
        Assert.assertEquals(name, profileNameDiv.getText());
        return this;
    }

}
