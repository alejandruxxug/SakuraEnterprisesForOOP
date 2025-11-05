package users;

import enums.AccessLevel;

public class ContentAdmin extends User {
    private AccessLevel editPermissions;

    public ContentAdmin(String name, String password, String email, AccessLevel editPermissions) {
        super(name, password, email);
        this.editPermissions = editPermissions; // 1 for access to shadow comitee 0 for no access
    }

    public AccessLevel getEditPermissions() {
        return editPermissions;
    }

    public void setEditPermissions(AccessLevel editPermissions) {
        this.editPermissions = editPermissions;
    }
}
