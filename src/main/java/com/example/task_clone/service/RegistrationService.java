package com.example.task_clone.service;


import com.example.task_clone.mapper.UserMapper;
import com.example.task_clone.model.dto.RegistrationDto;
import com.example.task_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService implements UserDetailsService {
    private final PasswordEncoder encoder;
    private final UserRepository repository;
    private final UserMapper mapper;
    private final JavaMailSender mailSender;

    private String baseUrl="http://127.0.0.1:8080/";


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("totu",encoder.encode("13.5.45.8.62"), Collections.emptyList());
    }

    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void register(RegistrationDto registrationDto) {
        com.example.task_clone.model.entity.User user = mapper.registerToEntity(registrationDto);
        com.example.task_clone.model.entity.User save = repository.save(user);
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("togrul.isamyilzada.2003@gmail.com");
        mailMessage.setTo(registrationDto.getUsername());
        mailMessage.setSubject("Registration Confirmation");
        mailMessage.setText(baseUrl+"registration/confirmation/"+save.getUuid());

        mailSender.send(mailMessage);
    }

    public void enableUpdate(UUID uuid) {
        com.example.task_clone.model.entity.User byUuid = repository.findByUuid(uuid);
        byUuid.setEnabled(true);
        repository.save(byUuid);
    }
}
