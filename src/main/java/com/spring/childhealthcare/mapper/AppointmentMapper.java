package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class AppointmentMapper {
    private final DoctorRepository doctorRepository;

}
