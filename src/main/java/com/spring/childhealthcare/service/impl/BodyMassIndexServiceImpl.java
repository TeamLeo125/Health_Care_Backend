package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.BodyMassIndexDTO;
import com.spring.childhealthcare.entity.BodyMassIndex;
import com.spring.childhealthcare.mapper.BodyMassIndexMapper;
import com.spring.childhealthcare.repository.BodyMassIndexRepository;
import com.spring.childhealthcare.service.BodyMassIndexService;
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
public class BodyMassIndexServiceImpl implements BodyMassIndexService {
    private final BodyMassIndexRepository bodyMassIndexRepository;
    private final BodyMassIndexMapper bodyMassIndexMapper;

    @Override
    public CommonResponse getAllBodyMassIndexDetails() {
        log.info("BodyMassIndexServiceImpl.getAllBodyMassIndexDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<BodyMassIndexDTO> bodyMassIndexDTOList = new ArrayList<>();
        List<BodyMassIndex> bodyMassIndexList = bodyMassIndexRepository.findAll();
        bodyMassIndexList.forEach(bodyMassIndex ->  bodyMassIndexDTOList.add(bodyMassIndexMapper.domainToDto(bodyMassIndex)));
        if (bodyMassIndexList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("BodyMassIndex details list not available!");
            log.warn("BodyMassIndex details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("BodyMassIndex details are fetching success!");
        commonResponse.setData(bodyMassIndexDTOList);
        log.info("BodyMassIndexServiceImpl.getAllBodyMassIndexDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getBodyMassIndexDetailsById(Long bodyMassIndexId) {
        log.info("BodyMassIndexServiceImpl.getBodyMassIndexDetailsById method accessed");
        BodyMassIndexDTO bodyMassIndexDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<BodyMassIndex> bodyMassIndex = bodyMassIndexRepository.findById(bodyMassIndexId);
        if(bodyMassIndex.isPresent()) {
            bodyMassIndexDTO = bodyMassIndexMapper.domainToDto(bodyMassIndex.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("BodyMassIndex details is not available!");
            log.warn("BodyMassIndex details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("BodyMassIndex details is fetching success!");
        commonResponse.setData(bodyMassIndexDTO);
        log.info("BodyMassIndexServiceImpl.getBodyMassIndexDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveBodyMassIndex(BodyMassIndexDTO bodyMassIndexDTO) {
        log.info("BodyMassIndexServiceImpl.saveBodyMassIndex method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<BodyMassIndex> bodyMassIndex = bodyMassIndexRepository.findById(bodyMassIndexDTO.getId());
        if(bodyMassIndex.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("BodyMassIndex details already exist!");
            commonResponse.setData(bodyMassIndexMapper.domainToDto(bodyMassIndex.get()));
            log.warn("BodyMassIndex details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        BodyMassIndex bodyMassIndexDetails = bodyMassIndexRepository.save(bodyMassIndexMapper.dtoToDomain(bodyMassIndexDTO, new BodyMassIndex()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("BodyMassIndex details saved success!");
        commonResponse.setData(bodyMassIndexMapper.domainToDto(bodyMassIndexDetails));
        log.info("BodyMassIndexServiceImpl.saveBodyMassIndex method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateBodyMassIndex(BodyMassIndexDTO bodyMassIndexDTO) {
        log.info("BodyMassIndexServiceImpl.updateBodyMassIndex method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<BodyMassIndex> bodyMassIndex = bodyMassIndexRepository.findById(bodyMassIndexDTO.getId());
        if(bodyMassIndex.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("BodyMassIndex details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("BodyMassIndex details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        BodyMassIndex bodyMassIndexUpdatedDetails = bodyMassIndexRepository.save(bodyMassIndexMapper.dtoToDomain(bodyMassIndexDTO, bodyMassIndex.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("BodyMassIndex details is update success!");
        commonResponse.setData(bodyMassIndexMapper.domainToDto(bodyMassIndexUpdatedDetails));
        log.info("BodyMassIndexServiceImpl.updateBodyMassIndex method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteBodyMassIndexDetailsById(Long bodyMassIndexId) {
        log.info("BodyMassIndexServiceImpl.deleteBodyMassIndexDetailsById method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<BodyMassIndex> bodyMassIndex = bodyMassIndexRepository.findById(bodyMassIndexId);
        if(bodyMassIndex.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete bodyMassIndex details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("BodyMassIndex details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        bodyMassIndexRepository.deleteById(bodyMassIndexId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("BodyMassIndex details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("BodyMassIndexServiceImpl.deleteBodyMassIndexDetailsById method end");
        return commonResponse;
    }
}
