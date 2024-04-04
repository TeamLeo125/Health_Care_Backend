package com.spring.childhealthcare.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@RequiredArgsConstructor
public class AppointmentDTO {
    private Long id;
    private String patientId;
    private String doctorId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String appointmentType;
    private String  status;
    private Double amount;
}
