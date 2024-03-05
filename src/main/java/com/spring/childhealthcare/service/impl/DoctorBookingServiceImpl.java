package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.dto.DoctorBookingDTO;
import com.spring.childhealthcare.entity.DoctorBooking;
import com.spring.childhealthcare.repository.DoctorBookingRepository;
import com.spring.childhealthcare.service.DoctorBookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DoctorBookingServiceImpl implements DoctorBookingService {

    private final DoctorBookingRepository doctorBookingRepository;

    @Override
    public DoctorBooking saveDoctorBooking(DoctorBookingDTO doctorBookingDTO) {

        DoctorBooking doctorBooking = new DoctorBooking();
        doctorBooking.setDoctorName(doctorBookingDTO.getDoctorName());
        doctorBooking.setDate(doctorBookingDTO.getDate());
        doctorBooking.setTime(doctorBookingDTO.getTime());

        doctorBookingRepository.save(doctorBooking);

        return doctorBooking;
    }

    @Override
    public List<DoctorBooking> getAllDoctorDetails() {

        return doctorBookingRepository.findAll();
    }
}
