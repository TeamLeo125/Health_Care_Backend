package com.spring.childhealthcare.service;

import com.spring.childhealthcare.dto.DoctorBookingDTO;
import com.spring.childhealthcare.entity.DoctorBooking;

import java.util.List;

public interface DoctorBookingService {

    DoctorBooking saveDoctorBooking(DoctorBookingDTO doctorBookingDTO);

    List<DoctorBooking> getAllDoctorDetails();
}
