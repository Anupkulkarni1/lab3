package com.example.demo.validation;

import com.example.demo.model.user;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        user user = (user) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
