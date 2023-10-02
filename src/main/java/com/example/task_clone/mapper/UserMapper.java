package com.example.task_clone.mapper;

import com.example.task_clone.model.dto.RegistrationDto;
import com.example.task_clone.model.dto.UserDto;
import com.example.task_clone.model.entity.User;
import com.example.task_clone.model.signup.UserSignup;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Mapper(imports = {UUID.class})
public abstract class UserMapper {

    @Autowired
    protected PasswordEncoder encoder;
    @Mapping(target = "company",ignore = true)
    @Mapping(target = "positionList", ignore = true)
//    @Mapping(target = "email",source = "email")
    public abstract User signupToEntity(UserSignup userSignup);
    @Mapping(target = "companyName",expression = "java(user.getCompany().getName())")
    @Mapping(target = "positionList",expression = "java(user.getPositionList().stream().map(s->s.getName()).toList())")
    public abstract UserDto entityToDto(User user);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(target = "company",ignore = true)
    @Mapping(target = "positionList",ignore = true)
    public abstract void updateEntityFromDto(@MappingTarget User user, UserDto userDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "birthdate", ignore = true)
    @Mapping(target = "positionList", ignore = true)
    @Mapping(target = "enabled", constant = "false")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "uuid", expression = "java(UUID.randomUUID())")
    @Mapping(target = "password",expression = "java(encoder.encode(registrationDto.getPassword()))")
    public abstract User registerToEntity(RegistrationDto registrationDto);
}
