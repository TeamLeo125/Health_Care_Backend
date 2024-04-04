package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.LabResultDTO;
import com.spring.childhealthcare.entity.LabResult;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class LabResultMapper {
    private final PatientRepository patientRepository;
    public LabResult dtoToDomain(LabResultDTO dto, LabResult domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The LabResultDTO should not be null");
        }
        domain.setId(dto.getId());
        Patient patient = patientRepository.findPatientByPatientId(dto.getPatientId()).orElse(new Patient());
        domain.setPatient(patient);
        domain.setDate(dto.getDate());
        domain.setDetails(dto.getDetails());
        return domain;
    }

    public LabResultDTO domainToDto(LabResult domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The LabResult should not be null");
        }
        LabResultDTO dto = new LabResultDTO();
        dto.setId(domain.getId());
        dto.setPatientId(domain.getPatient().getPatientId());
        dto.setDate(domain.getDate());
        dto.setDetails(domain.getDetails());
        return dto;
    }

}
