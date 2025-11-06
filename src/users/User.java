package users;

import exceptions.InvalidRegistrationData;

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


    public User(String username, String password, String email) throws InvalidRegistrationData {
        this.id = counter++;
        this.role = getClass().getSimpleName();
        this.registeredDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.stateOfAccount = true;

        if (username.equals("") || username.length() > 25) {
            throw new InvalidRegistrationData("Username has to have more than 1 character and no more than 25 characters");
        }

        if (password.length() < 4) {
            throw new InvalidRegistrationData("Password length must be at least 4 characters");
        }

        if (!email.contains("@")) {
            throw new InvalidRegistrationData("Invalid Email, it has to be a valid email address");
        }

        this.username = username.toLowerCase();
        this.password = password;
        this.email = email;


    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)  throws InvalidRegistrationData {
        if (password.length() < 4) {
            throw new InvalidRegistrationData("Password length must be at least 4 characters");
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public boolean isStateOfAccount() {
        return stateOfAccount;
    }

    public void setStateOfAccount(boolean stateOfAccount) {
        this.stateOfAccount = stateOfAccount;
    }
}
