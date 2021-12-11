package pageobjects.ness;

import core.builder.WebObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class TalentRecruitSearchPage extends WebObject {

    @FindBy(how = XPATH, using = "//input[@name='ctl00$MainContent$txtKeyword']")
    private WebElement searchInput;

    @FindBy(how = XPATH, using = "//div[@class='apply-btn-div'][1]")
    private WebElement firstApplyDiv;

    public TalentRecruitSearchPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(searchInput));
    }

    public JobDetailPage clickFirstApply() {
        firstApplyDiv.click();
        return new JobDetailPage();
    }
}
