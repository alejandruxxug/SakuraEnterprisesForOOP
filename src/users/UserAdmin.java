package users;

import enums.AccessLevel;

public class UserAdmin extends User{
    private AccessLevel accessLevel;

    public UserAdmin(String name, String password, String email, AccessLevel accessLevel) {
        super(name, password, email);
        this.accessLevel = accessLevel;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
