package com.example.task_clone.annotation;

import com.example.task_clone.model.dto.RegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, RegistrationDto> {
    @Override
    public boolean isValid(RegistrationDto value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || Objects.equals(value.getPassword(),value.getConfrimPassword());
    }
}
