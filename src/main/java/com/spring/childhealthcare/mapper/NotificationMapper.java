package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.NotificationDTO;
import com.spring.childhealthcare.entity.Notification;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationMapper {
    public Notification dtoToDomain(NotificationDTO dto, Notification domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The NotificationDTO should not be null");
        }
        domain.setId(dto.getId());
        domain.setMessage(dto.getMessage());
        domain.setTimestamp(dto.getTimestamp());
        return domain;
    }

    public NotificationDTO domainToDto(Notification domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Notification should not be null");
        }
        NotificationDTO dto = new NotificationDTO();
        dto.setId(domain.getId());
        dto.setMessage(domain.getMessage());
        dto.setTimestamp(domain.getTimestamp());
        return dto;
    }
}
