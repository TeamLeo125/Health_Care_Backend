//package com.spring.childhealthcare.mapper;
//
//import com.spring.childhealthcare.dto.AppointmentDTO;
//import com.spring.childhealthcare.entity.Appointment;
//import com.spring.childhealthcare.entity.Doctor;
//import com.spring.childhealthcare.exception.ReferenceNotFoundException;
//import com.spring.childhealthcare.repository.AppointmentRepository;
//import com.spring.childhealthcare.repository.DoctorRepository;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@AllArgsConstructor
//public class AppointmentMapper {
//    private final DoctorRepository doctorRepository;
//    public Appointment dtoToDomain(AppointmentDTO dto, Appointment domain) {
//        if (dto == null) {
//            throw new ReferenceNotFoundException("The MedicineDTO should not be null");
//        }
//        domain.setId(dto.getId());
//        Doctor doctor = doctorRepository.
//        domain.setPatient(dto.getPatientId());
//        domain.setDoctor(dto.getDoctorId());
//        domain.setDate(dto.getDate());
//        domain.setStartTime(dto.getStartTime());
//        domain.getEndTime(dto.getDosage());
//        domain.setDosage(dto.getDosage());
//
//        return domain;
//    }
//
//    public AppointmentDTO domainToDto(Appointment domain) {
//        if (domain == null) {
//            throw new ReferenceNotFoundException("The Medicine should not be null");
//        }
//        AppointmentDTO dto = new AppointmentDTO();
//        dto.setId(domain.getId());
//        dto.setName(domain.getName());
//        dto.setDescription(domain.getDescription());
//        dto.setDosage(domain.getDosage());
//        return dto;
//    }
//}
