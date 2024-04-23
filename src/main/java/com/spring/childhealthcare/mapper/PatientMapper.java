package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.PatientDTO;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class PatientMapper {
    public Patient dtoToDomain(PatientDTO dto, Patient domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The PatientDTO should not be null");
        }
        domain.setPatientId(dto.getPatientId());
        domain.setFirstName(dto.getFirstName());
        domain.setLastName(dto.getLastName());
        domain.setDateOfBirth(dto.getDateOfBirth());
        domain.setAddress(dto.getAddress());
        return domain;
    }

    public PatientDTO domainToDto(Patient domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Patient should not be null");
        }
        PatientDTO dto = new PatientDTO();
        dto.setId(domain.getId());
        dto.setPatientId(domain.getPatientId());
        dto.setFirstName(domain.getFirstName());
        dto.setLastName(domain.getLastName());
        dto.setDateOfBirth(domain.getDateOfBirth());
        dto.setAddress(domain.getAddress());
        return dto;
    }
}
