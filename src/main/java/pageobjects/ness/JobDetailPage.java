package pageobjects.ness;

import core.builder.WebObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.shared.Timeout.MEDIUM;
import static org.openqa.selenium.support.How.XPATH;

public class JobDetailPage extends WebObject {

    @FindBy(how = XPATH, using = "//span[@id='MainContent_lblJobTitle']")
    private WebElement jobTitle;

    public JobDetailPage() {
        super();
        wait(MEDIUM).until(ExpectedConditions.visibilityOf(jobTitle));
    }
}
