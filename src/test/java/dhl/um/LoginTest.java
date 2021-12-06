package dhl.um;

import core.WebTestCase;
import org.testng.annotations.Test;
import pageobjects.dhl.smartops.usermanagement.UserManagementLoginPage;

public class LoginTest extends WebTestCase {

    @Test
    public void initPageObject() {
        new UserManagementLoginPage(true)
                .fillUsername("pftest1")
                .fillPassword("121212")
                .clickLogin();
    }
}
