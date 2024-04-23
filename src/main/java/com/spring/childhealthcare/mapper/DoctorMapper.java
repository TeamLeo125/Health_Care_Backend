package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.DoctorDTO;
import com.spring.childhealthcare.entity.Doctor;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DoctorMapper {
    public Doctor dtoToDomain(DoctorDTO dto, Doctor domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The DoctorDTO should not be null");
        }
        domain.setDoctorId(dto.getDoctorId());
        domain.setFirstName(dto.getFirstName());
        domain.setLastName(dto.getLastName());
        domain.setJobTitle(dto.getJobTitle());
        domain.setSpecialization(dto.getSpecialization());
        domain.setMedicalSchool(dto.getMedicalSchool());
        domain.setYearOfExperience(dto.getYearOfExperience());
        domain.setStatus(dto.getStatus());
        return domain;
    }

    public DoctorDTO domainToDto(Doctor domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Doctor should not be null");
        }
        DoctorDTO dto = new DoctorDTO();
        dto.setId(domain.getId());
        dto.setDoctorId(domain.getDoctorId());
        dto.setFirstName(domain.getFirstName());
        dto.setLastName(domain.getLastName());
        dto.setJobTitle(domain.getJobTitle());
        dto.setSpecialization(domain.getSpecialization());
        dto.setMedicalSchool(domain.getMedicalSchool());
        dto.setYearOfExperience(domain.getYearOfExperience());
        dto.setStatus(domain.getStatus());
        return dto;
    }
}
