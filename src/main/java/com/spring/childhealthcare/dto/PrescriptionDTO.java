package com.spring.childhealthcare.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class PrescriptionDTO {
    private Long id;
    private String description;
    private String doctorId;
    private String patientId;
    private Long medicineId;
    private LocalDate date;
}
