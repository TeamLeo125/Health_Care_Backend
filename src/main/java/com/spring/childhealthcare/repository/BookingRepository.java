package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
