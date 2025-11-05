package users;

import enums.AccessLevel;
import java.time.LocalDate;

public class Sakura extends User{
    //The world IS MINE!!!
    private long masterKey;
    private String crowningDate;
    private AccessLevel accessLevel = AccessLevel.ADMIN;

    public Sakura(String username, String password, String email, long masterKey) {
        super(username, password, email);
        this.masterKey = masterKey;
        this.crowningDate = LocalDate.now().toString();
    }
}
