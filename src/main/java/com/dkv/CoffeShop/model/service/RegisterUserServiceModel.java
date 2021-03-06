package com.dkv.CoffeShop.model.service;

public class RegisterUserServiceModel {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterUserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterUserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterUserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterUserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserServiceModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
