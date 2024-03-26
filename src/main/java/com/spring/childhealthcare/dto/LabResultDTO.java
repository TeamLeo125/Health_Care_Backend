package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class LabResultDTO {
    private Long id;
    private String patientId;
    private LocalDate date;
    private String details;
}
