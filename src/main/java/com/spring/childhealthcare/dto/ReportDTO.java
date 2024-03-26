package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReportDTO {
    private Long id;
    private String title;
    private String description;
    private String doctorId;
    private String patientId;
    private LocalDate date;
}
