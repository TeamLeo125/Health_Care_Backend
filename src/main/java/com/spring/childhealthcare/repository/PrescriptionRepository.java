package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
