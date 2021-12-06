package pageobjects.unit;

import core.annotations.ParentXpath;
import core.builder.PageBuilder;
import core.builder.WebObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.XPATH;

//TODO Implement parent xpath
@ParentXpath("//test")
public class ParentXPathObject extends WebObject {

    public ParentXPathObject() {
        PageBuilder<ParentXPathObject> pageBuilder = new PageBuilder<ParentXPathObject>(this);
        pageBuilder.initElements();
    }

    @FindBy(how = XPATH, using = "//input[@id='username']")
    private WebElement username;

    @FindBy(how = XPATH, using = "//div[contains(text(), 'Co děláme')]")
    private WebElement whatWeDoDiv;

    private String notAnnotated;


}
