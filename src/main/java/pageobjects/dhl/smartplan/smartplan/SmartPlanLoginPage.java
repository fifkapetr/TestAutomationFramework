package pageobjects.dhl.smartplan.smartplan;

import core.annotations.Application;
import core.builder.StartPage;
import core.shared.Timeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.openqa.selenium.support.How.XPATH;

@Application("dhl.smartplan.smartplan")
public class SmartPlanLoginPage extends StartPage {

    public SmartPlanLoginPage(boolean openApplication) {
        super();
        if(openApplication)
            openApplication(this);
        wait(Timeout.MEDIUM).until(ExpectedConditions.visibilityOf(userNameInput));
    }

    @FindBy(how = XPATH, using = "//input[@name='username']")
    private WebElement userNameInput;

    @FindBy(how = XPATH, using = "//input[@name='password']")
    private WebElement passwordInput;

    //FIXME add id after dev fix
    @FindBy(how = XPATH, using = "//div[@value='Submit']//span[text()='Login']")
    private WebElement loginButton;

    public SmartPlanLoginPage fillUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    public SmartPlanLoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public MainPage clickLogin() {
        loginButton.click();
        return new MainPage();
    }

}
