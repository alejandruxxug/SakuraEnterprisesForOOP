package services;

import users.Sakura;
import users.User;

import java.util.ArrayList;

public class AuthService {
    private ArrayList<User> users = new ArrayList<>();

    public AuthService() {
        Sakura sakura = new Sakura("Sakura-San", "sakurapetals", "sakura@gmail.com", 1234567890);

        users.add(sakura);

    }
}
