package com.example.task_clone.mapper;

import com.example.task_clone.model.dto.PositionDto;
import com.example.task_clone.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface PositionMapper {
    Position dtoToEntity(PositionDto positionDto);
    PositionDto entityToDto(Position position);
    void updateCompay(@MappingTarget Position position,PositionDto positionDto);
}
