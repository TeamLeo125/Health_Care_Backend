package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.LabResultDTO;
import com.spring.childhealthcare.entity.LabResult;
import com.spring.childhealthcare.mapper.LabResultMapper;
import com.spring.childhealthcare.repository.LabResultRepository;
import com.spring.childhealthcare.service.LabResultService;
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
public class LabResultServiceImpl implements LabResultService {
    private final LabResultRepository labResultRepository;
    private final LabResultMapper labResultMapper;
    @Override
    public CommonResponse getAllLabResultDetails() {
        log.info("LabResultServiceImpl.getAllLabResultDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<LabResultDTO> labResultDTOList = new ArrayList<>();
        List<LabResult> labResultList = labResultRepository.findAll();
        labResultList.forEach(labResult ->  labResultDTOList.add(labResultMapper.domainToDto(labResult)));
        if (labResultList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("LabResult details list not available!");
            log.warn("LabResult details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("LabResult details are fetching success!");
        commonResponse.setData(labResultDTOList);
        log.info("LabResultServiceImpl.getAllLabResultDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getLabResultDetailsByLabResultId(Long labResultId) {
        log.info("LabResultServiceImpl.getLabResultDetailsByLabResultId method accessed");
        LabResultDTO labResultDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<LabResult> labResult = labResultRepository.findById(labResultId);
        if(labResult.isPresent()) {
            labResultDTO = labResultMapper.domainToDto(labResult.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("LabResult details is not available!");
            log.warn("LabResult details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("LabResult details is fetching success!");
        commonResponse.setData(labResultDTO);
        log.info("LabResultServiceImpl.getLabResultDetailsByLabResultId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveLabResult(LabResultDTO labResultDTO) {
        log.info("LabResultServiceImpl.saveLabResult method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<LabResult> labResult = labResultRepository.findById(labResultDTO.getId());
        if(labResult.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("LabResult details already exist!");
            commonResponse.setData(labResultMapper.domainToDto(labResult.get()));
            log.warn("LabResult details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        LabResult labResultSavedDetails = labResultRepository.save(labResultMapper.dtoToDomain(labResultDTO, new LabResult()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("LabResult details saved success!");
        commonResponse.setData(labResultMapper.domainToDto(labResultSavedDetails));
        log.info("LabResultServiceImpl.saveLabResult method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateLabResult(LabResultDTO labResultDTO) {
        log.info("LabResultServiceImpl.updateLabResult method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<LabResult> labResult = labResultRepository.findById(labResultDTO.getId());
        if(labResult.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("LabResult details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("LabResult details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        LabResult labResultUpdatedDetails = labResultRepository.save(labResultMapper.dtoToDomain(labResultDTO, labResult.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("LabResult details is update success!");
        commonResponse.setData(labResultMapper.domainToDto(labResultUpdatedDetails));
        log.info("LabResultServiceImpl.updateLabResult method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteLabResultDetailsByLabResultId(Long labResultId) {
        log.info("LabResultServiceImpl.deleteLabResultDetailsByLabResultId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<LabResult> labResult = labResultRepository.findById(labResultId);
        if(labResult.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete labResult details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("LabResult details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        labResultRepository.deleteById(labResultId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("LabResult details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("LabResultServiceImpl.deleteLabResultDetailsByLabResultId method end");
        return commonResponse;
    }
}
