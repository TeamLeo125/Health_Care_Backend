package com.spring.childhealthcare.dto;

import com.spring.childhealthcare.entity.LabAnalysis;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class LabResultDTO {
    private Long id;
    private String patientId;
    private LocalDate date;
    private String details;
    private String testName;
    private String labNo;
    private String referredBy;
    private List<LabAnalysisDTO> labAnalysisDTOS;
}
