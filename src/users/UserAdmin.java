package users;

public class UserAdmin extends User{
    private String accessLevel;

    public UserAdmin(String name, String password, String email, String accessLevel) {
        super(name, password, email);
        this.accessLevel = accessLevel;
    }

}
