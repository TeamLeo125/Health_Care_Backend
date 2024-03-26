package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BodyMassIndexDTO {
    private Long id;
    private Double weight;
    private Double height;
    private Double result;
    private String patientId;
}
