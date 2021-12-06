package pageobjects.dhl.smartops.usermanagement;

import core.builder.WebObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class SetYourPasswordPage extends WebObject {

    public SetYourPasswordPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(currentPasswordInput));
    }

    @FindBy(how = XPATH, using = "//input[@id='currentPassword']")
    private WebElement currentPasswordInput;

    @FindBy(how = XPATH, using = "//input[@id='newPassword']")
    private WebElement newPasswordInput;

    @FindBy(how = XPATH, using = "//input[@id='retypePassword']")
    private WebElement retypePasswordInput;

    @FindBy(how = XPATH, using = "//button[@type='submit']")
    private WebElement submitButton;

    public SetYourPasswordPage fillCurrentPassword(String currentPassword) {
        currentPasswordInput.sendKeys(currentPassword);
        return this;
    }

    public SetYourPasswordPage fillNewPassword(String newPassword) {
        newPasswordInput.sendKeys(newPassword);
        retypePasswordInput.sendKeys(newPassword);
        return this;
    }

    public PasswordChangeDirection clickSubmit() {
        submitButton.click();
        return new PasswordChangeDirection();
    }
}
