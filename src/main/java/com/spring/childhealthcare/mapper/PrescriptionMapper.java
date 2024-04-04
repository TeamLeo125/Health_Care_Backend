package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.PrescriptionDTO;
import com.spring.childhealthcare.entity.Doctor;
import com.spring.childhealthcare.entity.Medicine;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.entity.Prescription;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.repository.DoctorRepository;
import com.spring.childhealthcare.repository.MedicineRepository;
import com.spring.childhealthcare.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class PrescriptionMapper {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;

    public Prescription dtoToDomain(PrescriptionDTO dto, Prescription domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The PrescriptionDTO should not be null");
        }
        domain.setId(dto.getId());
        domain.setDescription(dto.getDescription());
        Doctor doctor = doctorRepository.findDoctorByDoctorId(dto.getDoctorId()).orElse(new Doctor());
        domain.setDoctor(doctor);
        Patient patient = patientRepository.findPatientByPatientId(dto.getPatientId()).orElse(new Patient());
        domain.setPatient(patient);
        Medicine medicine = medicineRepository.findById(dto.getMedicineId()).orElse(new Medicine());
        domain.setMedicine(List.of(medicine));
        domain.setDate(dto.getDate());
        return domain;
    }

    public PrescriptionDTO domainToDto(Prescription domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Prescription should not be null");
        }
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setId(domain.getId());
        dto.setDescription(domain.getDescription());
        dto.setDoctorId(domain.getDoctor().getDoctorId());
        dto.setPatientId(domain.getPatient().getPatientId());
        dto.setMedicineId(domain.getMedicine().stream().findFirst().orElse(new Medicine()).getId());
        dto.setDate(domain.getDate());
        return dto;
    }
}
