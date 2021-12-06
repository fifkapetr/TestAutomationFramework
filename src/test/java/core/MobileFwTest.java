package core;

import org.testng.annotations.Test;
import pageobjects.dhl.smartops.mobile.parent.LoginPage;

public class MobileFwTest extends MobileTestCase {

    @Test
    public void openParent() {
        new LoginPage().fillUsername("fifkat1")
                .fillPassword("909090")
                .clickLogin()
                .onPrivacyNotificationPage()
                .clickAccept();
        System.out.println();
    }
}
