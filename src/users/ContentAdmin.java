package users;

public class ContentAdmin extends User {
    private int editPermissions;

    public ContentAdmin(String name, String password, String email, int editPermissions) {
        super(name, password, email);
        this.editPermissions = editPermissions;
    }
}
