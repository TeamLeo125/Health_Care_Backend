package com.spring.childhealthcare.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class LabResultDTO {
    private Long id;
    private String patientId;
    private LocalDate date;
    private String details;
}
