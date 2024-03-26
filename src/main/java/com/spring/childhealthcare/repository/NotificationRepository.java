package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
