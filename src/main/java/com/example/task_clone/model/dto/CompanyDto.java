package com.example.task_clone.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private String name;
    private LocalDate createDate;

}
