package services;

import enums.AccessLevel;
import exceptions.DuplicateUserData;
import exceptions.InvalidLogin;
import exceptions.MatchingUsernameNotFound;
import users.*;

import java.util.ArrayList;

public class AuthService {
    private ArrayList<User> users = new ArrayList<>();

    public AuthService() throws DuplicateUserData {
        Sakura sakura = new Sakura("Sakura-San", "sakurapetals", "sakura@gmail.com", 1234567890);
        ProductDeveloper pd1 = new ProductDeveloper("mrdaniel", "daniel", "daniel@gmail.com", "MakeUp");
        UserAdmin ua = new UserAdmin("admin", "admin", "admin@gmail.com", AccessLevel.ADMIN);
        ContentAdmin ca= new ContentAdmin("cadmin", "cadmin", "cadmin@gmail.com", AccessLevel.ADMIN);

        users.add(sakura);
        users.add(pd1);
        users.add(ua);
        users.add(ca);

    }

    public void addUser(User user) throws DuplicateUserData {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new DuplicateUserData("Username is already in use, please pick another username");
            }
        }
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User login(String username, String password) throws InvalidLogin {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password) && u.isStateOfAccount() == true) {
                return u;
            }
        }
            throw new InvalidLogin("Invalid username, password or inactivated account");
    }

    public User searchUsername(String username) throws MatchingUsernameNotFound {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        throw new MatchingUsernameNotFound("Username not found, please try again");
    }
}