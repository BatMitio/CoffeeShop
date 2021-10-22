package com.dkv.CoffeShop.model.binding.annotations.validators;

import com.dkv.CoffeShop.model.binding.annotations.UniqueEmail;
import com.dkv.CoffeShop.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null)
            return true;
        return this.userService.emailIsFree(value);
    }
}
