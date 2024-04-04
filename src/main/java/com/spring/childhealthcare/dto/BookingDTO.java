package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class BookingDTO {
    private Long id;
    private String patientId;
    private String roomId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String roomType;
    private String purpose;
    private String status;
    private Double amount;
}
