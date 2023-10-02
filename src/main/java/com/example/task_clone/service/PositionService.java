package com.example.task_clone.service;

import com.example.task_clone.model.dto.PositionDto;

import java.util.List;

public interface PositionService {
    List<PositionDto> findAll();

    PositionDto findById(Long id);

    void save(PositionDto companyDto);

    void updateById(Long id, PositionDto positionDto);

    void deleteById(Long id);
}
