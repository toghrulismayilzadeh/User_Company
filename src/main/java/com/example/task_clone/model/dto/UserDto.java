package com.example.task_clone.model.dto;

import com.example.task_clone.model.entity.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
public class UserDto {
    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String lastName;
    @Past
    private LocalDate birthdate;
    @NotBlank
    private String companyName;
    @NotBlank
    private String email;
    @NotBlank
    private List<String> positionList;

//    package com.example.task_clone.model.dto;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//        @Setter
//        @Getter
//        @NoArgsConstructor
//        @AllArgsConstructor
//        @Entity(name = "registration_user")
//        public class RegistrationDto implements UserDetails {
//            @Id
//            @Column(name = "id")
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long id;
//            @NotBlank()
//            @Column(name = "email")
//            private String username;
//            @NotBlank
//            @Column(name = "password")
//            private String password;
//            @NotBlank
//            private String confrimPassword;
//            private boolean accountNonExpired;
//            private boolean accountNonLocked;
//            private boolean credentialsNonExpired;
//            private boolean enabled;
//
//            @Override
//            public Collection<? extends GrantedAuthority> getAuthorities() {
//                return Collections.emptyList();
//            }
//        }

    }
