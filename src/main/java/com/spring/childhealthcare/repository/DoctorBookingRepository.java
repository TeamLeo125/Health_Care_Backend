package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.DoctorBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorBookingRepository extends JpaRepository<DoctorBooking, Integer> {
}
