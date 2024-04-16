package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.AppointmentDTO;
import com.spring.childhealthcare.entity.Appointment;
import com.spring.childhealthcare.mapper.AppointmentMapper;
import com.spring.childhealthcare.repository.AppointmentRepository;
import com.spring.childhealthcare.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    @Override
    public CommonResponse getAllAppointmentDetails() {
        log.info("AppointmentServiceImpl.getAllAppointmentDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        List<Appointment> appointmentList = appointmentRepository.findAll();
        appointmentList.forEach(medicine ->  appointmentDTOList.add(appointmentMapper.domainToDto(medicine)));
        if (appointmentList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Appointment details list not available!");
            log.warn("Appointment details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Appointment details are fetching success!");
        commonResponse.setData(appointmentDTOList);
        log.info("AppointmentServiceImpl.getAllAppointmentDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getAppointmentDetailsByAppointmentId(Long appointmentId) {
        log.info("AppointmentServiceImpl.getAppointmentDetailsByAppointmentId method accessed");
        AppointmentDTO appointmentDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        if(appointment.isPresent()) {
            appointmentDTO = appointmentMapper.domainToDto(appointment.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Appointment details is not available!");
            log.warn("Appointment details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Appointment details is fetching success!");
        commonResponse.setData(appointmentDTO);
        log.info("AppointmentServiceImpl.getAppointmentDetailsByAppointmentId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveAppointment(AppointmentDTO appointmentDTO) {
        log.info("AppointmentServiceImpl.saveAppointment method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentDTO.getId());
        if(appointment.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Appointment details already exist!");
            commonResponse.setData(appointmentMapper.domainToDto(appointment.get()));
            log.warn("Appointment details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Appointment appointmentSavedDetails = appointmentRepository.save(appointmentMapper.dtoToDomain(appointmentDTO, new Appointment()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Appointment details saved success!");
        commonResponse.setData(appointmentMapper.domainToDto(appointmentSavedDetails));
        log.info("AppointmentServiceImpl.saveAppointment method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateAppointment(AppointmentDTO appointmentDTO) {
        log.info("AppointmentServiceImpl.updateAppointment method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentDTO.getId());
        if(appointment.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Appointment details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Appointment details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Appointment appointmentUpdatedDetails = appointmentRepository.save(appointmentMapper.dtoToDomain(appointmentDTO, appointment.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Appointment details is update success!");
        commonResponse.setData(appointmentMapper.domainToDto(appointmentUpdatedDetails));
        log.info("AppointmentServiceImpl.updateAppointment method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteAppointmentDetailsByAppointmentId(Long appointmentId) {
        log.info("AppointmentServiceImpl.deleteAppointmentDetailsByAppointmentId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        if(appointment.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete appointment details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Appointment details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        appointmentRepository.deleteById(appointmentId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Appointment details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("AppointmentServiceImpl.deleteAppointmentDetailsByAppointmentId method end");
        return commonResponse;
    }
}
