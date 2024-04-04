package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.RoomDTO;
import com.spring.childhealthcare.entity.Room;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RoomMapper {
    public Room dtoToDomain(RoomDTO dto, Room domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The RoomDTO should not be null");
        }
        domain.setId(dto.getId());
        domain.setLocation(dto.getLocation());
        domain.setCapacity(dto.getCapacity());
        domain.setRoomType(dto.getRoomType());
        domain.setStatus(dto.getStatus());
        return domain;
    }

    public RoomDTO domainToDto(Room domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Room should not be null");
        }
        RoomDTO dto = new RoomDTO();
        dto.setId(domain.getId());
        dto.setLocation(domain.getLocation());
        dto.setCapacity(domain.getCapacity());
        dto.setRoomType(domain.getRoomType());
        dto.setStatus(domain.getStatus());
        return dto;
    }
}
