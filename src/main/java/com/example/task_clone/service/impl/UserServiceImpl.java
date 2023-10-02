package com.example.task_clone.service.impl;

import com.example.task_clone.exception.NotFoundException;
import com.example.task_clone.mapper.UserMapper;
import com.example.task_clone.model.dto.UserDto;
import com.example.task_clone.model.entity.Company;
import com.example.task_clone.model.entity.Position;
import com.example.task_clone.model.entity.User;
import com.example.task_clone.model.signup.UserSignup;
import com.example.task_clone.repository.CompanyRepository;
import com.example.task_clone.repository.PositionRepository;
import com.example.task_clone.repository.UserRepository;
import com.example.task_clone.service.UserSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserSerivce {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final UserMapper mapper;
    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void save(UserSignup signupUser) {
        User user = mapper.signupToEntity(signupUser);
        Company company = companyRepository.findById(signupUser.getCompanyId()).orElseThrow(() -> new NotFoundException("Bu id -ilə Company tapılmadı: " + signupUser.getCompanyId()));
        List<Position> positions = signupUser.getPositionList().stream().map(s -> positionRepository.findById(s).orElseThrow(() -> new NotFoundException("Bu id -ilə Position tapılmadı: " + s))).toList();
        user.setPositionList(positions);
        user.setCompany(company);
        try {
            userRepository.save(user);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Save zamanı xəta baş verdi", ex);
        }
    }
    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void updateByIdDto(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Bele id-li Bir User tapılmadı: " + id));
        mapper.updateEntityFromDto(user,userDto);
        Company company = companyRepository.findByName(userDto.getCompanyName());
        user.setCompany(company);
        List<Position> positions = userDto.getPositionList().stream().map(s -> positionRepository.findByName(s)).toList();
        user.setPositionList(positions);
        try {
            userRepository.save(user);

        } catch (RuntimeException ex) {
            throw new RuntimeException("Update zamanı xəta baş verdi", ex);
        }
    }
    @Override

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .toList();


    }
    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void deleteById(Long id) {

        if(userRepository.existsById(id)){
            try {
                userRepository.deleteById(id);
            }catch (RuntimeException ex){

                throw  new RuntimeException("Silinme zamanı xəta baş verdi" , ex);
            }
        }else throw new NotFoundException("Bu idli User tapılmadı");

    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("Bele id-li User tapılmadı"));
        UserDto userDto = mapper.entityToDto(user);
        return userDto;
    }

}
