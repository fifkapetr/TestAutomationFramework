package testdata;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class UserData {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private String language;
    private String email;
    private String groupName;
}
