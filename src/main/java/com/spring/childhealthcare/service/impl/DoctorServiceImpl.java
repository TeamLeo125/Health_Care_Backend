package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.DoctorDTO;
import com.spring.childhealthcare.entity.Doctor;
import com.spring.childhealthcare.mapper.DoctorMapper;
import com.spring.childhealthcare.repository.DoctorRepository;
import com.spring.childhealthcare.service.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    @Override
    public CommonResponse getAllDoctorDetails() {
            log.info("DoctorServiceImpl.getAllDoctorDetails method accessed");
            CommonResponse commonResponse = new CommonResponse();
            List<DoctorDTO> doctorDTOList = new ArrayList<>();
            List<Doctor> doctorList = doctorRepository.findAll();
            doctorList.forEach(doctor ->  doctorDTOList.add(doctorMapper.domainToDto(doctor)));
            if (doctorList.isEmpty()) {
                commonResponse.setStatus(HttpStatus.OK);
                commonResponse.setData(new ArrayList<>());
                commonResponse.setMessage("Doctor details list not available!");
                log.warn("Doctor details not available. message :{}", commonResponse.getMessage());
                return commonResponse;
            }
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage("Doctor details are fetching success!");
            commonResponse.setData(doctorDTOList);
            log.info("DoctorServiceImpl.getAllDoctorDetails method end");
            return commonResponse;
        }

    @Override
    public CommonResponse getDoctorDetailsByDoctorId(Long doctorId) {
        log.info("DoctorServiceImpl.getDoctorDetailsByDoctorId method accessed");
        DoctorDTO doctorDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isPresent()) {
            doctorDTO = doctorMapper.domainToDto(doctor.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Doctor details is not available!");
            log.warn("Doctor details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Doctor details is fetching success!");
        commonResponse.setData(doctorDTO);
        log.info("DoctorServiceImpl.getDoctorDetailsByDoctorId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveDoctor(DoctorDTO doctorDTO) {
        log.info("DoctorServiceImpl.saveDoctor method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Doctor> doctor = doctorRepository.findById(doctorDTO.getId());
        if(doctor.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Doctor details already exist!");
            commonResponse.setData(doctorMapper.domainToDto(doctor.get()));
            log.warn("Doctor details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Doctor doctorSavedDetails = doctorRepository.save(doctorMapper.dtoToDomain(doctorDTO, new Doctor()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Doctor details saved success!");
        commonResponse.setData(doctorMapper.domainToDto(doctorSavedDetails));
        log.info("DoctorServiceImpl.saveDoctor method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateDoctor(DoctorDTO doctorDTO) {
        log.info("DoctorServiceImpl.updateDoctor method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Doctor> doctor = doctorRepository.findById(doctorDTO.getId());
        if(doctor.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Doctor details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Doctor details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Doctor doctorUpdatedDetails = doctorRepository.save(doctorMapper.dtoToDomain(doctorDTO, doctor.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Doctor details is update success!");
        commonResponse.setData(doctorMapper.domainToDto(doctorUpdatedDetails));
        log.info("DoctorServiceImpl.updateDoctor method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteDoctorDetailsByDoctorId(Long doctorId) {
        log.info("DoctorServiceImpl.deleteDoctorDetailsByDoctorId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete doctor details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Doctor details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        doctorRepository.deleteById(doctorId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Doctor details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("DoctorServiceImpl.deleteDoctorDetailsByDoctorId method end");
        return commonResponse;
    }
}

