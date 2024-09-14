package com.djungleacademy.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = FieldMatchValidation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMatch {
    String message() default "Values not matched";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldOne();
    String fieldTwo();

    /*container of the second element,
    it's for holding multiple annotations of the same type on a single element.
    cause the annotation can be used only once for each element*/
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldMatch[] value();
    }

}

