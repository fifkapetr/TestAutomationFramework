package dhl.smartplan.smartplan;

import core.WebTestCase;
import org.testng.annotations.Test;
import pageobjects.dhl.smartplan.smartplan.SmartPlanLoginPage;

public class DemoTest extends WebTestCase {

    @Test
    public void demoTest() {
        new SmartPlanLoginPage(true)
                .fillUsername("automation")
                .fillPassword("Password1122Password1122")
                .clickLogin();
        System.out.println();
        System.out.println();
    }
}
