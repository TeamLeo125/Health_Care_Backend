package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.AppointmentDTO;
import com.spring.childhealthcare.entity.Appointment;
import com.spring.childhealthcare.entity.Doctor;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.repository.DoctorRepository;
import com.spring.childhealthcare.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class AppointmentMapper {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment dtoToDomain(AppointmentDTO dto, Appointment domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The AppointmentDTO should not be null");
        }
        domain.setId(dto.getId());
        Patient patient = patientRepository.findPatientByPatientId(dto.getPatientId()).orElse(new Patient());
        domain.setPatient(patient);
        Doctor doctor = doctorRepository.findDoctorByDoctorId(dto.getDoctorId()).orElse(new Doctor());
        domain.setDoctor(doctor);
        domain.setDate(dto.getDate());
        domain.setStartTime(dto.getStartTime());
        domain.setEndTime(dto.getEndTime());
        domain.setAppointmentType(dto.getAppointmentType());
        domain.setStatus(dto.getStatus());
        domain.setAmount(dto.getAmount());
        return domain;
    }

    public AppointmentDTO domainToDto(Appointment domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Appointment should not be null");
        }
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(domain.getId());
        dto.setDoctorId(domain.getDoctor().getDoctorId());
        dto.setPatientId(domain.getPatient().getPatientId());
        dto.setDate(domain.getDate());
        dto.setStartTime(domain.getStartTime());
        dto.setEndTime(domain.getEndTime());
        dto.setAppointmentType(domain.getAppointmentType());
        dto.setStatus(domain.getStatus());
        dto.setAmount(domain.getAmount());
        return dto;
    }

}
