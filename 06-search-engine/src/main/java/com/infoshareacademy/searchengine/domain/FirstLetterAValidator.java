package com.infoshareacademy.searchengine.domain;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FirstLetterAValidator implements ConstraintValidator<FirstLetterA, String> {

    @Override
    public void initialize(FirstLetterA constraintAnnotation) {
    }


    @Override
    public boolean isValid(String text, ConstraintValidatorContext constraintValidatorContext) {
        return text.startsWith("A");
    }
}
