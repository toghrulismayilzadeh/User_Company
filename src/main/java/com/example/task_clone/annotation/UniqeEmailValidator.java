package com.example.task_clone.annotation;

import com.example.task_clone.model.dto.RegistrationDto;
import com.example.task_clone.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqeEmailValidator implements ConstraintValidator<UniqeEmail,RegistrationDto> {
    private final UserRepository userRepository;
    @Override
    public boolean isValid(RegistrationDto registrationDto, ConstraintValidatorContext constraintValidatorContext) {
        return registrationDto==null || !userRepository.existsByUsername(registrationDto.getUsername());
    }
}
