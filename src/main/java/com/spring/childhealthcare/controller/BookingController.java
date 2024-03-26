package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.BookingDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/booking")
public class BookingController {
    @PostMapping("")
    public ResponseEntity<CommonResponse> createBooking(@RequestBody BookingDTO bookingDTO){
        CommonResponse commonResponse = new CommonResponse();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
