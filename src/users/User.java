package users;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class User {
    private static long counter = 0;
    private long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private String registeredDate;
    private boolean stateOfAccount;

    //Constructors

    public User(String name, String password, String email) {
        this.id = counter++;
        this.username = name;
        this.password = password;
        this.email = email;
        this.role = getClass().getSimpleName();
        this.registeredDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.stateOfAccount = true;
    }

    public User() {
    }

}
