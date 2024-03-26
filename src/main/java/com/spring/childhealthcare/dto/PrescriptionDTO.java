package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PrescriptionDTO {
    private Long id;
    private String description;
    private String doctorId;
    private String patientId;
    private String medicineId;
    private LocalDate date;
}
