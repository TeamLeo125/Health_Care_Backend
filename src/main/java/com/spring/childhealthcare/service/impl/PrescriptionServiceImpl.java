package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.PrescriptionDTO;
import com.spring.childhealthcare.entity.Prescription;
import com.spring.childhealthcare.mapper.PrescriptionMapper;
import com.spring.childhealthcare.repository.PrescriptionRepository;
import com.spring.childhealthcare.service.PrescriptionService;
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
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;
    @Override
    public CommonResponse getAllPrescriptionDetails() {
        log.info("PrescriptionServiceImpl.getAllPrescriptionDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<PrescriptionDTO> prescriptionDTOList = new ArrayList<>();
        List<Prescription> prescriptionList = prescriptionRepository.findAll();
        prescriptionList.forEach(prescription ->  prescriptionDTOList.add(prescriptionMapper.domainToDto(prescription)));
        if (prescriptionList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Prescription details list not available!");
            log.warn("Prescription details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Prescription details are fetching success!");
        commonResponse.setData(prescriptionDTOList);
        log.info("PrescriptionServiceImpl.getAllPrescriptionDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getPrescriptionDetailsByPrescriptionId(Long prescriptionId) {
        log.info("PrescriptionServiceImpl.getPrescriptionDetailsByPrescriptionId method accessed");
        PrescriptionDTO prescriptionDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionId);
        if(prescription.isPresent()) {
            prescriptionDTO = prescriptionMapper.domainToDto(prescription.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Prescription details is not available!");
            log.warn("Prescription details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Prescription details is fetching success!");
        commonResponse.setData(prescriptionDTO);
        log.info("PrescriptionServiceImpl.getPrescriptionDetailsByPrescriptionId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse savePrescription(PrescriptionDTO prescriptionDTO) {
        log.info("PrescriptionServiceImpl.savePrescription method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionDTO.getId());
        if(prescription.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Prescription details already exist!");
            commonResponse.setData(prescriptionMapper.domainToDto(prescription.get()));
            log.warn("Prescription details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Prescription prescriptionSavedDetails = prescriptionRepository.save(prescriptionMapper.dtoToDomain(prescriptionDTO, new Prescription()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Prescription details saved success!");
        commonResponse.setData(prescriptionMapper.domainToDto(prescriptionSavedDetails));
        log.info("PrescriptionServiceImpl.savePrescription method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updatePrescription(PrescriptionDTO prescriptionDTO) {
        log.info("PrescriptionServiceImpl.updatePrescription method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionDTO.getId());
        if(prescription.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Prescription details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Prescription details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Prescription prescriptionUpdatedDetails = prescriptionRepository.save(prescriptionMapper.dtoToDomain(prescriptionDTO, prescription.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Prescription details is update success!");
        commonResponse.setData(prescriptionMapper.domainToDto(prescriptionUpdatedDetails));
        log.info("PrescriptionServiceImpl.updatePrescription method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deletePrescriptionDetailsByPrescriptionId(Long prescriptionId) {
        log.info("PrescriptionServiceImpl.deletePrescriptionDetailsByPrescriptionId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionId);
        if(prescription.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete prescription details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Prescription details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        prescriptionRepository.deleteById(prescriptionId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Prescription details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("PrescriptionServiceImpl.deletePrescriptionDetailsByPrescriptionId method end");
        return commonResponse;
    }
}
