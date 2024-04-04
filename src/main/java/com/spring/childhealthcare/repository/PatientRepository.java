package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findPatientByPatientId(String patientId);

    void deletePatientByPatientId(String patientId);
}
