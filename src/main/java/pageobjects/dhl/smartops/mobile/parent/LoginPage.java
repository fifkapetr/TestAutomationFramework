package pageobjects.dhl.smartops.mobile.parent;

import core.builder.MobileObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class LoginPage extends MobileObject {

    public LoginPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(usernameInput));
    }

    @FindBy(how = XPATH, using = "//android.widget.EditText[@content-desc='login_input1']")
    private WebElement usernameInput;

    @FindBy(how = XPATH, using = "//android.widget.EditText[@content-desc='login_input2']")
    private WebElement passwordInput;

    @FindBy(how = XPATH, using = "//android.view.ViewGroup[@content-desc='login_button']")
    private WebElement loginButton;

    public LoginPage fillUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginDirection clickLogin() {
        loginButton.click();
        return new LoginDirection();
    }
}
