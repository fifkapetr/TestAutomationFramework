package pageobjects.dhl.smartops.usermanagement;

public class PasswordChangeDirection {

    public SetYourPasswordPage onSetYourPasswordPage() {
        return new SetYourPasswordPage();
    }

    public UserManagementLoginPage onUserManagementLoginPage() {
        return new UserManagementLoginPage(false);
    }
}
