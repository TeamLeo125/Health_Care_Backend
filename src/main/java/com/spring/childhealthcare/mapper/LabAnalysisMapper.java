package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.LabAnalysisDTO;
import com.spring.childhealthcare.entity.LabAnalysis;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LabAnalysisMapper {
    public LabAnalysis dtoToDomain(LabAnalysisDTO dto, LabAnalysis domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The LabAnalysisDTO should not be null");
        }
        domain.setId(dto.getId());
        domain.setTest(dto.getTest());
        domain.setResult(dto.getResult());
        domain.setReferenceRage(dto.getReferenceRage());
        return domain;
    }

    public LabAnalysisDTO domainToDto(LabAnalysis domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The LabAnalysis should not be null");
        }
        LabAnalysisDTO dto = new LabAnalysisDTO();
        dto.setId(domain.getId());
        dto.setTest(domain.getTest());
        dto.setResult(domain.getResult());
        dto.setReferenceRage(domain.getReferenceRage());
        return dto;
    }
}
