package com.dkv.CoffeShop.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class LoginUserBindingModel {
    @Length(min = 5, max = 20)
    @NotBlank
    private String username;
    @Length(min = 3)
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginUserBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUserBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
