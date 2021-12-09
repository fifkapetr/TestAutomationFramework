package pageobjects.ness;

import core.builder.WebObject;
import core.shared.Timeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class TalentRecruitSearchPage extends WebObject {

    @FindBy(how = XPATH, using = "//input[@name='ctl00$MainContent$txtKeyword']")
    private WebElement searchInput;

    public TalentRecruitSearchPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(searchInput));
    }
}
