package com.dkv.CoffeShop.model.binding;

import com.dkv.CoffeShop.model.binding.annotations.UniqueEmail;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RegisterUserBindingModel {
    @NotBlank
    @Length(min = 5, max = 20)
    private String username;
    private String firstName;
    @NotBlank
    @Length(min = 5, max = 20)
    private String lastName;
    @NotBlank
    @UniqueEmail
    @Pattern(regexp = "\\w+@\\w.+")
    private String email;
    @NotBlank
    @Length(min = 3)
    private String password;
    @NotBlank
    @Length(min = 3)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterUserBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterUserBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterUserBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterUserBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
