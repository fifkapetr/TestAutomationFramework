package pageobjects.ness;

import core.annotations.Application;
import core.builder.StartPage;
import core.shared.Timeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Application("ness")
public class NessMainPage extends StartPage {

    @FindBy(how = How.XPATH, using = "//div[@class='cta-talk blue-btn']//a[@href='/contact-us/']")
    private WebElement letsTalkButton;

    @FindBy(how = How.XPATH, using = "//li[contains(@id, 'menu-item')]//a[@href='/contact-us/']")
    private WebElement contactAnchor;

    @FindBy(how = How.XPATH, using = "//a[@href='https://www.ness.com/careers/' and @class='mega-menu-link']")
    private WebElement careersAnchor;

    public NessMainPage(boolean openApplication) {
        super();
        if (openApplication)
            openApplication(this);
        //FIXME LONG is not working
        wait(Timeout.MEDIUM).until(ExpectedConditions.visibilityOf(letsTalkButton));
    }

    public ContactFormPage clickLetsTalkButton() {
        letsTalkButton.click();
        return new ContactFormPage();
    }

    public ContactFormPage clickContactAnchor() {
        contactAnchor.click();
        return new ContactFormPage();
    }

    public CareersPage clickCareersAnchor() {
        careersAnchor.click();
        return new CareersPage();
    }
}
