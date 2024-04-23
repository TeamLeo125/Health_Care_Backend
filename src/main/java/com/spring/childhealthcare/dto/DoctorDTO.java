package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long id;
    private String doctorId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String specialization;
    private String medicalSchool;
    private Integer yearOfExperience;
    private String status;
}
