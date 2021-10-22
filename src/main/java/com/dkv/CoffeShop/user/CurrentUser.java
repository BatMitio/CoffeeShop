package com.dkv.CoffeShop.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component(value = "currentUser")
@SessionScope
public class CurrentUser {
    private boolean loggedIn;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public CurrentUser() {
        loggedIn = false;
    }

    public boolean isloggedIn() {
        return loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CurrentUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public void clear() {
        this.loggedIn = false;
        this.username = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
    }
}
