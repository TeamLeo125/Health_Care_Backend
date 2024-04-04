package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.BookingDTO;
import com.spring.childhealthcare.entity.Booking;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.entity.Room;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.repository.PatientRepository;
import com.spring.childhealthcare.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class BookingMapper {
    private final PatientRepository patientRepository;
    private final RoomRepository roomRepository;
    public Booking dtoToDomain(BookingDTO dto, Booking domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The BookingDTO should not be null");
        }
        domain.setId(dto.getId());
        Room room = roomRepository.findRoomByRoomId(dto.getRoomId()).orElse(new Room());
        domain.setRoom(room);
        Patient patient = patientRepository.findPatientByPatientId(dto.getPatientId()).orElse(new Patient());
        domain.setPatient(patient);
        domain.setAmount(dto.getAmount());
        domain.setPurpose(dto.getPurpose());
        domain.setStatus(dto.getStatus());
        domain.setStartDate(dto.getStartDate());
        domain.setEndDate(dto.getEndDate());
        domain.setRoomType(dto.getRoomType());
        return domain;
    }

    public BookingDTO domainToDto(Booking domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Booking should not be null");
        }
        BookingDTO dto = new BookingDTO();
        dto.setId(domain.getId());
        dto.setRoomId(domain.getRoom().getRoomId());
        dto.setPatientId(domain.getPatient().getPatientId());
        dto.setAmount(domain.getAmount());
        dto.setPurpose(domain.getPurpose());
        dto.setStatus(domain.getStatus());
        dto.setStartDate(domain.getStartDate());
        dto.setEndDate(domain.getEndDate());
        dto.setRoomType(domain.getRoomType());
        return dto;
    }
}
