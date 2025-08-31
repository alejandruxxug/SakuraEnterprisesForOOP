package users;

public class User {
    private static long counter = 0;
    private long id;
    private String name;
    private String passwordHash;
    private String email;
    private String role;
    private String registeredDate;
    private String stateOfAccount;

    //Constructors

    public User(String name, String passwordHash, String email, String role, String registeredDate, String stateOfAccount) {
        this.id = counter++;
        this.name = name;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
        this.registeredDate = registeredDate;
        this.stateOfAccount = stateOfAccount;
    }

    public User() {
    }

}
