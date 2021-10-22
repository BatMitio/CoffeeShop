package com.dkv.CoffeShop.model.binding.annotations;

import com.dkv.CoffeShop.model.binding.annotations.validators.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "Email is not free!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
