package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByDoctorId(String doctorId);

    void deleteDoctorByDoctorId(String doctorId);
}
