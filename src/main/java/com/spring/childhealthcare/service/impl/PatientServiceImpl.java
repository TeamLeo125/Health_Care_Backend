package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.PatientDTO;
import com.spring.childhealthcare.entity.Patient;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.mapper.PatientMapper;
import com.spring.childhealthcare.repository.PatientRepository;
import com.spring.childhealthcare.service.PatientService;
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
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    @Override
    public CommonResponse getAllPatientDetails() {
        log.info("PatientServiceImpl.getAllPatientDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<PatientDTO> patientDTOList = new ArrayList<>();
        List<Patient> patientList = patientRepository.findAll();
        patientList.forEach(patient ->  patientDTOList.add(patientMapper.domainToDto(patient)));
        if (patientList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Patient details list not available!");
            log.warn("Patient details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Patient details are fetching success!");
        commonResponse.setData(patientDTOList);
        log.info("PatientServiceImpl.getAllPatientDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getPatientDetailsByPatientId(String patientId) {
        log.info("PatientServiceImpl.getPatientDetailsByPatientId method accessed");
        PatientDTO patientDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Patient> patient = patientRepository.findPatientByPatientId(patientId);
        if(patient.isPresent()) {
            patientDTO = patientMapper.domainToDto(patient.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Patient details is not available!");
            log.warn("Patient details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Patient details is fetching success!");
        commonResponse.setData(patientDTO);
        log.info("PatientServiceImpl.getPatientDetailsByPatientId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse savePatient(PatientDTO patientDTO) {
        log.info("PatientServiceImpl.savePatient method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Patient> patient = patientRepository.findPatientByPatientId(patientDTO.getPatientId());
        if(patient.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Patient details already exist!");
            commonResponse.setData(patientMapper.domainToDto(patient.get()));
            log.warn("Patient details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        String patientId = sequentialPatientIdGenerator();
        Patient patientDetails;
        if(patientId.matches("PNT"+"\\d{3}") && patientRepository.findPatientByPatientId(patientId).isEmpty()) {
            patientDTO.setPatientId(patientId);
            patientDetails = patientRepository.save(patientMapper.dtoToDomain(patientDTO, new Patient()));
        } else {
            throw new ReferenceNotFoundException("The patientId no matches require pattern or the patientId is already exist!");
        }
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Patient details saved success!");
        commonResponse.setData(patientMapper.domainToDto(patientDetails));
        log.info("PatientServiceImpl.savePatient method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updatePatient(PatientDTO patientDTO) {
        log.info("PatientServiceImpl.updatePatient method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Patient> patient = patientRepository.findPatientByPatientId(patientDTO.getPatientId());
        if(patient.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Patient details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Patient details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Patient patientUpdatedDetails = patientRepository.save(patientMapper.dtoToDomain(patientDTO, patient.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Patient details is update success!");
        commonResponse.setData(patientMapper.domainToDto(patientUpdatedDetails));
        log.info("PatientServiceImpl.updatePatient method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deletePatientDetailsByPatientId(String patientId) {
        log.info("PatientServiceImpl.deletePatientDetailsByPatientId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Patient> patient = patientRepository.findPatientByPatientId(patientId);
        if(patient.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete patient details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Patient details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        patientRepository.deletePatientByPatientId(patientId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Patient details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("PatientServiceImpl.deletePatientDetailsByPatientId method end");
        return commonResponse;
    }

    private String sequentialPatientIdGenerator() {
        int patientNumber;
        List<Patient> patientList = patientRepository.findAll().stream().toList();
        String patientId = "";
        if (!patientList.isEmpty())
            patientId = patientList.get(patientList.size() - 1).getPatientId();
        patientId = patientId.isEmpty()? "0" : patientId.substring(patientId.length() - 3);
        patientNumber = Integer.parseInt(patientId);
        patientNumber++;
        return String.format("PNT%03d", patientNumber);
    }

}
