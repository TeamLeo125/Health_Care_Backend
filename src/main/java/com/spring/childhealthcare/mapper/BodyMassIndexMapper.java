package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.BodyMassIndexDTO;
import com.spring.childhealthcare.entity.BodyMassIndex;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class BodyMassIndexMapper {
    private final PatientRepository patientRepository;
    public BodyMassIndex dtoToDomain(BodyMassIndexDTO dto, BodyMassIndex domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The BodyMassIndexDTO should not be null");
        }
        domain.setId(dto.getId());
        domain.setHeight(dto.getHeight());
        domain.setWeight(dto.getWeight());
        domain.setResult(dto.getResult());
        Optional<Patient> patient = patientRepository.findById(dto.getId());
        domain.setPatient(patient.orElse(new Patient()));
        return domain;
    }

    public BodyMassIndexDTO domainToDto(BodyMassIndex domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The BodyMassIndex should not be null");
        }
        BodyMassIndexDTO dto = new BodyMassIndexDTO();
        dto.setId(domain.getId());
        dto.setHeight(domain.getHeight());
        dto.setWeight(domain.getWeight());
        dto.setResult(domain.getResult());
        dto.setPatientId(domain.getPatient().getPatientId());
        return dto;
    }
}
