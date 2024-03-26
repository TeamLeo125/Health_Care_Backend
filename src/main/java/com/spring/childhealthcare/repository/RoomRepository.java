package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Report, Long> {
}
