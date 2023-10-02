package com.example.task_clone.controller;

import com.example.task_clone.annotation.UniqeEmail;
import com.example.task_clone.model.dto.RegistrationDto;
import com.example.task_clone.service.RegistrationService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
@UniqeEmail
public class RegistrationController {
    private final RegistrationService service;

    @PermitAll
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegistrationDto dto){service.register(dto);}

    @GetMapping("confirmation/{uuid}")
    public void confitmation(@PathVariable UUID uuid){
    service.enableUpdate(uuid);
    }
}
