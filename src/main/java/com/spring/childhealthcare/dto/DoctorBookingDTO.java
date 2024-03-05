package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoctorBookingDTO {
    private String doctorName;
    private String date;
    private String time;
}
