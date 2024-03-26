package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
