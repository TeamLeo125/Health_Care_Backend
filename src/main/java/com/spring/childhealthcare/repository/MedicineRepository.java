package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
