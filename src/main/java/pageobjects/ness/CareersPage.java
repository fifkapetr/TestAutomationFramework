package pageobjects.ness;

import core.builder.WebObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class CareersPage extends WebObject {

    @FindBy(how = XPATH, using = "//h1[contains(text(), 'Careers')]")
    private WebElement contactUsHeader;

    @FindBy(how = XPATH, using = "//a[@href='https://ness.eu.talentrecruit.com/Search/' and text()='Slovakia']")
    private WebElement slovakiaJobsAnchor;

    public CareersPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(contactUsHeader));
    }

    public TalentRecruitSearchPage clickSlovakiaAnchor() {
        slovakiaJobsAnchor.click();
        return new TalentRecruitSearchPage();
    }
}
