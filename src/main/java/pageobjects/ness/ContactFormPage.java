package pageobjects.ness;

import core.builder.WebObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class ContactFormPage extends WebObject {

    @FindBy(how = XPATH, using = "//h1[contains(text(), 'Contact Us')]")
    private WebElement contactUsHeader;

    @FindBy(how = XPATH, using = "//select[@name='contact_reason']")
    private WebElement contactReasonSelect;

    @FindBy(how = XPATH, using = "//input[contains(@id, 'firstname')]")
    private WebElement firstNameInput;

    @FindBy(how = XPATH, using = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(how = XPATH, using = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(how = XPATH, using = "//input[@name='by_submitting_this_form_i_understand_that_my_data_will_be_processed_by_ness_digital_engineering_as_']")
    private WebElement termOfUseCheckbox;

    @FindBy(how = XPATH, using = "//input[@type='Submit']")
    private WebElement submitButton;

    @FindBy(how = XPATH, using = "//ul[contains(@class, 'hs-error-msgs')]")
    private WebElement errorUl;


    public ContactFormPage() {
        super();
        getDriver().switchTo().frame("hs-form-iframe-0");
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(firstNameInput));
    }

    public ContactFormPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public ContactFormPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public ContactFormPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public ContactFormPage approveTermOfUse() {
        termOfUseCheckbox.click();
        return this;
    }

    public ContactFormPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public ContactFormPage selectContactReason(String value) {
        Select contactReason = new Select(contactReasonSelect);
        contactReason.selectByValue(value);
        return this;
    }
}
