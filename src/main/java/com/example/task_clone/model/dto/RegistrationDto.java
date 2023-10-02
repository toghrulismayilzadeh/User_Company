package com.example.task_clone.model.dto;

import com.example.task_clone.annotation.MatchPassword;
import com.example.task_clone.annotation.UniqeEmail;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

@Setter
@Getter
@MatchPassword
@UniqeEmail
public class RegistrationDto {
        @NotBlank
        @Pattern(regexp = "[\\w.-]+@[\\w.-]+.\\w+$")
        private String username;
        @NotBlank
        private String password;
        @NotBlank
        private String confrimPassword;
}
