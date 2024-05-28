package Loginapplication;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userDatabase;

    public UserRepository() {
        this.userDatabase = new HashMap<>();
    }

    public User findUserByUsername(String username) {
        return userDatabase.get(username);
    }

    public User findUserByEmail(String email) {
        for (User user : userDatabase.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        userDatabase.put(user.getUsername(), user);
    }
}
