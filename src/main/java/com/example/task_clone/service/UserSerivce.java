package com.example.task_clone.service;

import com.example.task_clone.model.dto.UserDto;
import com.example.task_clone.model.signup.UserSignup;

import java.util.List;

public interface UserSerivce {
    void save(UserSignup signup);
    UserDto findById(Long id);
    List<UserDto> findAll();
    void updateByIdDto(Long id, UserDto dto);
    void deleteById(Long id);
}
