package pageobjects.dhl.smartops.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class UserDetailPage extends UmHeader {

    @FindBy(how = XPATH, using = "//input[@id='userDetail.firstName']")
    private WebElement firstNameInput;

    @FindBy(how = XPATH, using = "//input[@id='userDetail.lastName']")
    private WebElement lastNameInput;

    @FindBy(how = XPATH, using = "//input[@id='userDetail.language.id']")
    private WebElement languageInput;

    @FindBy(how = XPATH, using = "//input[@id='userDetail.country.id']")
    private WebElement countryInput;

    @FindBy(how = XPATH, using = "//input[@id='login']")
    private WebElement usernameInput;

    @FindBy(how = XPATH, using = "//input[@id='newPassword']")
    private WebElement passwordInput;

    @FindBy(how = XPATH, using = "//input[@id='retypePassword']")
    private WebElement confirmPasswordInput;

    //FIXME: replace with ID
    @FindBy(how = XPATH, using = "//button[text()='Local']")
    private WebElement localSourceButton;

    //FIXME: replace with ID
    @FindBy(how = XPATH, using = "//div[@class='userGroupSelect']//input")
    private WebElement groupSearchInput;

    //FIXME: replace with ID
    @FindBy(how = XPATH, using = "//div[text()='Save User']")
    private WebElement saveUserButton;

    //FIXME: replace with ID
    @FindBy(how = XPATH, using = "//li[@data-value='BASIC']")
    private WebElement basicPasswordSelectLi;

    //FIXME: replace with ID
    @FindBy(how = XPATH, using = "//input[@id='authenticationType']/../div[@role='button']")
    private WebElement authSelectorInput;

    //FIXME: replace with ID
    @FindBy(how = XPATH, using = "//span[text()='Generate Email to Change Password']")
    private WebElement generateEmailToChangePasswordCheckbox;

    @FindBy(how = XPATH, using = "//input[@id='userDetail.email']")
    private WebElement emailInput;


    public UserDetailPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(firstNameInput));
    }

    public UserDetailPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public UserDetailPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public UserDetailPage fillLanguage(String language) {
        languageInput.sendKeys(language);
        languageInput.sendKeys(Keys.ENTER);
        return this;
    }

    public UserDetailPage fillCountry(String country) {
        countryInput.sendKeys(country);
        countryInput.sendKeys(Keys.ENTER);
        return this;
    }

    public UserDetailPage fillUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public UserDetailPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public UserDetailPage clickLocalSource() {
        localSourceButton.click();
        return this;
    }

    public UserDetailPage selectGroup(String groupName) {
        groupSearchInput.sendKeys(groupName);
        //FIXME: add to pageobjects elements
        By byXpath = By.xpath("//div[@class='Select-menu-outer']//div[contains(text(), '" + groupName + "')]");
        wait(MEDIUM).until(ExpectedConditions.visibilityOfElementLocated(byXpath));
        getDriver().findElement(byXpath).click();
        countryInput.sendKeys(Keys.ENTER);
        return this;
    }

    public UsersListPage saveUser() {
        saveUserButton.click();
        return new UsersListPage();
    }

    public UserDetailPage selectBasicAuthentication() {
        authSelectorInput.click();
        basicPasswordSelectLi.click();
        return this;
    }

    public UserDetailPage uncheckGeneratePasswordCheckbox() {
        generateEmailToChangePasswordCheckbox.click();
        return this;
    }

    public UserDetailPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }
}
