package com.djungleacademy.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = PassWordValidation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Set a valid password pls";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
