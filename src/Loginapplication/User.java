package Loginapplication;

public class User {
    private String username;
    private String name;
    private String password;
    private String phoneNumber;
    private String email;

    public User(String username, String name, String password, String phoneNumber, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
