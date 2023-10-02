package com.example.task_clone.service.impl;

import com.example.task_clone.exception.NotFoundException;
import com.example.task_clone.mapper.CompanyMapper;
import com.example.task_clone.model.dto.CompanyDto;
import com.example.task_clone.model.entity.Company;
import com.example.task_clone.repository.CompanyRepository;
import com.example.task_clone.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper mapper;
    private final CompanyRepository repository;
    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void save(CompanyDto companyDto) {
        Company company = mapper.dtoToEntity(companyDto);
        try{
            repository.save(company);
        }catch (RuntimeException ex){
            throw new RuntimeException("Save zamani xeta bas verdi");}

    }

    @Override
    public List<CompanyDto> findAll() {
        return repository.findAll().stream()
                .map(mapper :: entityToDto)
                .toList();
    }

    @Override
    public CompanyDto findById(Long id) {
        Company company = repository.findById(id).orElseThrow(() -> new NotFoundException("Belə id-li Company yoxdur: " + id));
        CompanyDto companyDto = mapper.entityToDto(company);
        return companyDto;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void updateById(Long id, CompanyDto companyDto) {
        Company company = repository.findById(id).orElseThrow(() -> new NotFoundException("Belə id-li bir Company yoxdur: " + id));
        mapper.updateCompay(company,companyDto);
        try{
            repository.save(company);
        }catch (RuntimeException ex){
            throw new RuntimeException("Update zamanı xəta baş verdi");}
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void deleteById(Long id) {
        if (repository.existsById(id)){
            try {
                repository.deleteById(id);
            }catch (RuntimeException ex){
                throw new RuntimeException("Silinmə zamanı xəta baş verdi");
            }
        }else throw new NotFoundException("Bu id-li Company taplımadı");
    }
}
