package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.dto.DoctorBookingDTO;
import com.spring.childhealthcare.entity.DoctorBooking;
import com.spring.childhealthcare.service.DoctorBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/booking/doctor")
public class DoctorBookingController {

    private final DoctorBookingService doctorBookingService;

    @PostMapping("/save")
    public ResponseEntity<DoctorBooking> saveDoctorBooking(@RequestBody DoctorBookingDTO doctorBookingDTO) {
        DoctorBooking doctorBooking =  doctorBookingService.saveDoctorBooking(doctorBookingDTO);
        return new ResponseEntity<>(doctorBooking, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DoctorBooking>> getAllDoctorDetails(){
        List<DoctorBooking> doctorBooking =  doctorBookingService.getAllDoctorDetails();
        return new ResponseEntity<>(doctorBooking, HttpStatus.OK);
    }

}
