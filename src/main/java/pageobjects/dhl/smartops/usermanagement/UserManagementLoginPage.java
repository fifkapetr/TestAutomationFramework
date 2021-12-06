package pageobjects.dhl.smartops.usermanagement;

import core.builder.StartPage;
import core.annotations.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

@Application("dhl.smartops.user_management")
public class UserManagementLoginPage extends StartPage {


    @FindBy(how = XPATH, using = "//input[@id='username']")
    private WebElement username;

    @FindBy(how = XPATH, using = "//input[@id='password']")
    private WebElement password;

    @FindBy(how = XPATH, using = "//input[@id='OKButton']")
    private WebElement loginButton;

    public UserManagementLoginPage(boolean openApplication) {
        super();
        if(openApplication)
            openApplication(this);
        //FIXME LONG is not working
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(username));
    }

    public UserManagementLoginPage fillUsername(String usernameValue) {
        username.sendKeys(usernameValue);
        return this;
    }

    public UserManagementLoginPage fillPassword(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    public LoginDirection clickLogin() {
        loginButton.click();
        return new LoginDirection();
    }
}
