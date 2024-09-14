package com.djungleacademy.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PassWordValidation implements ConstraintValidator<Password,String> {
    List<String>weakPsw;

    @Override
    public void initialize(Password constraintAnnotation) {
        weakPsw= Arrays.asList("123","abc");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (!weakPsw.contains(value));
    }

}
