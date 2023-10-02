package com.example.task_clone.model.signup;

import com.example.task_clone.model.entity.Company;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserSignup {
    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String lastName;
    @NotBlank
    private String password;
    @Past
    private LocalDate birthdate;
    @NotBlank
    private Long companyId;
    @NotBlank
    private List<Long> positionList;
    @NotBlank
    @Pattern(regexp = "[\\w.-]+@[\\w.-]+.\\w+$")
    private String email;
}
