package com.example.task_clone.controller;

import com.example.task_clone.model.dto.CompanyDto;
import com.example.task_clone.model.dto.PositionDto;
import com.example.task_clone.service.CompanyService;
import com.example.task_clone.service.PositionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("(/api/v1/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService service;

    @GetMapping()
    public ResponseEntity<List<PositionDto>> findall(){return ResponseEntity.ok(service.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<PositionDto> findById(@PathVariable Long id){return ResponseEntity.ok(service.findById(id));}

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody PositionDto positionDto){
        service.save(positionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable Long id, @Valid @RequestBody PositionDto positionDto){
        service.updateById(id,positionDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
