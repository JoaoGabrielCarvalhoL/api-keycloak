package br.com.carv.apikeycloak.model;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        user = new User();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder name(String name) {
        this.user.setName(name);
        return this;
    }

    public UserBuilder email(String email) {
        this.user.setEmail(email);
        return this;
    }

    public UserBuilder username(String username) {
        this.user.setUsername(username);
        return this;
    }

    public UserBuilder password(String password) {
        this.user.setPassword(password);
        return this;
    }

    public User build() {
        return this.user;
    }
}
