package com.example.task_clone.service;

import com.example.task_clone.model.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    void save(CompanyDto companyDto);

    List<CompanyDto> findAll();

    CompanyDto findById(Long id);

    void updateById(Long id, CompanyDto companyDto);

    void deleteById(Long id);
}
