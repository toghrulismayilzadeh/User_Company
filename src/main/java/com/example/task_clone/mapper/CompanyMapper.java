package com.example.task_clone.mapper;

import com.example.task_clone.model.dto.CompanyDto;
import com.example.task_clone.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CompanyMapper {
    Company dtoToEntity(CompanyDto companyDto);
    CompanyDto entityToDto(Company company);
    @Mapping(target = "id",ignore = true)
    void updateCompay(@MappingTarget Company company,CompanyDto companyDto);
}
