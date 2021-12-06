package unit.dhlweb;

import core.WebTestCase;
import org.testng.annotations.Test;
import pageobjects.dhl.smartops.usermanagement.UserManagementLoginPage;

public class DhlUserManagementTest extends WebTestCase {

    @Test
    public void initPageObject() {
        new UserManagementLoginPage(true)
                .fillUsername("abcd")
                .fillPassword("totojk");
    }
}
