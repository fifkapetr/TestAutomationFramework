package pageobjects.inventiweb;

import core.annotations.ParentXpath;
import core.builder.StartPage;
import core.annotations.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

@Application("inventiweb")
@ParentXpath("something")
public class HomePage extends StartPage {

    @FindBy(how = XPATH, using = "//input[@id='username']")
    private WebElement username;

    @FindBy(how = XPATH, using = "//div[contains(text(), 'Co děláme')]")
    private WebElement whatWeDoDiv;

    private SomeComponent<HomePage> component;

    public HomePage openInventiWeb() {
        openApplication(this);
        return this;
    }

    public HomePage waitForElements() {
//        wait.until(ExpectedConditions.visibilityOf(wrapperDiv));
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(whatWeDoDiv));
        return this;
    }

    public WhatWeDoPage clickWhatWeDo() {
        whatWeDoDiv.click();
        return new WhatWeDoPage();
    }

    public SomeComponent<HomePage> doSomething() {
        return new SomeComponent(this);
    }

}
