package Loginapplication;

import java.util.regex.Pattern;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) throws Exception {
        validateUsername(user.getUsername());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
        userRepository.saveUser(user);
    }

    public User authenticateUser(String identifier, String password) throws Exception {
        User user = userRepository.findUserByUsername(identifier);
        if (user == null) {
            user = userRepository.findUserByEmail(identifier);
        }
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("Invalid username/email or password.");
        }
        return user;
    }

    private void validateUsername(String username) throws Exception {
        if (userRepository.findUserByUsername(username) != null) {
            throw new Exception("Username already exists.");
        }
    }

    private void validateEmail(String email) throws Exception {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new Exception("Invalid email format.");
        }
    }

    private void validatePassword(String password) throws Exception {
        if (password.length() < 8 || password.length() > 16) {
            throw new Exception("Password must be between 8 and 16 characters.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new Exception("Password must contain at least one uppercase letter.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new Exception("Password must contain at least one lowercase letter.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new Exception("Password must contain at least one number.");
        }
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new Exception("Password must contain at least one special character.");
        }
    }
}

