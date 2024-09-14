package com.djungleacademy.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidation implements ConstraintValidator<FieldMatch,Object> {

    String fieldOne;
    String fieldTwo;

    @Override
    public void initialize(FieldMatch fieldMatch) {
        this.fieldOne = fieldMatch.fieldOne();
        this.fieldTwo = fieldMatch.fieldTwo();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapperImpl wrapper = new BeanWrapperImpl(value);
        Object valueOne=wrapper.getPropertyValue(fieldOne);
        Object valueTwo=wrapper.getPropertyValue(fieldTwo);
        return (valueOne == null && valueTwo == null) || (valueOne != null && valueOne.equals(valueTwo));
    }
}
