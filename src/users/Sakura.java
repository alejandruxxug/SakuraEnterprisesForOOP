package users;


import java.time.LocalDate;

public class Sakura extends User{
    //The world IS MINE!!!
    private long masterKey;
    private String crowningDate;

    public Sakura(String name, String password, String email, long masterKey) {
        super(name, password, email);
        this.masterKey = masterKey;
        this.crowningDate = LocalDate.now().toString();
    }
}
