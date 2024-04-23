package com.spring.childhealthcare.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LabAnalysisDTO {
    private Long id;
    private String test;
    private String result;
    private String referenceRage;
}
