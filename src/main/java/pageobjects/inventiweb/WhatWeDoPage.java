package pageobjects.inventiweb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import core.builder.WebObject;

import static core.shared.Timeout.MEDIUM;

public class WhatWeDoPage extends WebObject {

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Zastřešujeme projekty od business analýzy přes samotný vývoj, testing až po následnou správu. Jsme budoucnost vašeho IT.')]")
    private WebElement whatWeDoDiv;

    public WhatWeDoPage waitForWhatWeDoDiv() {
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(whatWeDoDiv));
        return this;
    }
}
