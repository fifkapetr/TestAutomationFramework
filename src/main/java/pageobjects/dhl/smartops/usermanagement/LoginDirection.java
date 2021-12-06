package pageobjects.dhl.smartops.usermanagement;

public class LoginDirection {

    public MainPage onMainPage() {
        return new MainPage();
    }

    public SetYourPasswordPage onSetYourPasswordPage() {
        return new SetYourPasswordPage();
    }

    public UserManagementLoginPage onUserManagementLoginPage() {
        return new UserManagementLoginPage(false);
    }

    public UsersListPage onUsersListPage() {
        return new UsersListPage();
    }
}
