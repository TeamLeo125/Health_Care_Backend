package com.spring.childhealthcare.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class ReportDTO {
    private Long id;
    private String title;
    private String description;
    private String doctorId;
    private String patientId;
    private LocalDate date;
}
