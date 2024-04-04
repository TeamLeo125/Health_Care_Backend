package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.ReportDTO;
import com.spring.childhealthcare.entity.Doctor;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.entity.Report;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.repository.DoctorRepository;
import com.spring.childhealthcare.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ReportMapper {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    public Report dtoToDomain(ReportDTO dto, Report domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The ReportDTO should not be null");
        }
        domain.setId(dto.getId());
        domain.setTitle(dto.getTitle());
        domain.setDescription(dto.getDescription());
        Doctor doctor = doctorRepository.findDoctorByDoctorId(dto.getDoctorId()).orElse(new Doctor());
        domain.setDoctor(doctor);
        Patient patient = patientRepository.findPatientByPatientId(dto.getPatientId()).orElse(new Patient());
        domain.setPatient(patient);
        domain.setDate(dto.getDate());
        return domain;
    }

    public ReportDTO domainToDto(Report domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The LabResult should not be null");
        }
        ReportDTO dto = new ReportDTO();
        dto.setId(domain.getId());
        dto.setTitle(domain.getTitle());
        dto.setDescription(domain.getDescription());
        dto.setDoctorId(domain.getDoctor().getDoctorId());
        dto.setPatientId(domain.getPatient().getPatientId());
        dto.setDate(domain.getDate());
        return dto;
    }
}
