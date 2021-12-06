package dhl.um;

import core.WebTestCase;
import org.testng.annotations.Test;
import pageobjects.dhl.smartops.usermanagement.UserManagementLoginPage;
import testdata.UserData;
import util.TestDataUtil;

public class CreateNewUserTest extends WebTestCase {

    @Test
    public void createUser() {
        UserData userData = new UserData();
        userData.username(TestDataUtil.generateUsername())
                .password(TestDataUtil.generatePassword())
                .firstName("Sam")
                .lastName("Fisher");

        new UserManagementLoginPage(true)
                .fillUsername("pftestadmin")
                .fillPassword("Testing2021#####")
                .clickLogin()
                .onMainPage()
                .clickNewUserAnchor()
                .fillFirstName(userData.firstName())
                .fillLastName(userData.lastName())
                .fillCountry("United Kingdom")
                .fillLanguage("English")
                .clickLocalSource()
                .selectBasicAuthentication()
                .uncheckGeneratePasswordCheckbox()
                .fillPassword(userData.password())
                .fillUsername(userData.username())
                .fillEmail("petr.fifka@dhl.com")
                .selectGroup("TestAutomationCustomerOperator")
                .saveUser()
                .closePopup()
                .logout()
                .fillUsername(userData.username())
                .fillPassword(userData.password())
                .clickLogin()
                .onSetYourPasswordPage()
                .fillCurrentPassword(userData.password())
                .fillNewPassword(userData.password(TestDataUtil.generatePassword()).password())
                .clickSubmit()
                .onUserManagementLoginPage()
                .fillUsername(userData.username())
                .fillPassword(userData.password())
                .clickLogin()
                .onUsersListPage()
                .assertName(userData.firstName() + " " + userData.lastName())
                .logout();
    }
}
