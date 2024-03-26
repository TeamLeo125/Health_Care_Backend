package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private String patientId;
    private String doctorId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endDate;
    private String appointmentType;
    private String  status;
    private Double amount;
}
