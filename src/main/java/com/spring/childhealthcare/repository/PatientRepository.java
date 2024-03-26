package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
