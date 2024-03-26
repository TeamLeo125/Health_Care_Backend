package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.MedicineDTO;
import com.spring.childhealthcare.entity.Medicine;
import com.spring.childhealthcare.mapper.MedicineMapper;
import com.spring.childhealthcare.repository.MedicineRepository;
import com.spring.childhealthcare.service.MedicineService;
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
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository medicineRepository;
    private final MedicineMapper medicineMapper;
    @Override
    public CommonResponse getAllMedicineDetails() {
        log.info("MedicineServiceImpl.getAllMedicineDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<MedicineDTO> medicineDTOList = new ArrayList<>();
        List<Medicine> medicineList = medicineRepository.findAll();
        medicineList.forEach(medicine ->  medicineDTOList.add(medicineMapper.domainToDto(medicine)));
        if (medicineList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Medicine details list not available!");
            log.warn("Medicine details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Medicine details are fetching success!");
        commonResponse.setData(medicineDTOList);
        log.info("MedicineServiceImpl.getAllMedicineDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getMedicineDetailsByMedicineId(Long medicineId) {
        log.info("MedicineServiceImpl.getMedicineDetailsByMedicineId method accessed");
        MedicineDTO medicineDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Medicine> medicine = medicineRepository.findById(medicineId);
        if(medicine.isPresent()) {
            medicineDTO = medicineMapper.domainToDto(medicine.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Medicine details is not available!");
            log.warn("Medicine details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Medicine details is fetching success!");
        commonResponse.setData(medicineDTO);
        log.info("MedicineServiceImpl.getMedicineDetailsByMedicineId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveMedicine(MedicineDTO medicineDTO) {
        log.info("MedicineServiceImpl.saveMedicine method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Medicine> medicine = medicineRepository.findById(medicineDTO.getId());
        if(medicine.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Medicine details already exist!");
            commonResponse.setData(medicineMapper.domainToDto(medicine.get()));
            log.warn("Medicine details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Medicine medicineSavedDetails = medicineRepository.save(medicineMapper.dtoToDomain(medicineDTO, new Medicine()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Medicine details saved success!");
        commonResponse.setData(medicineMapper.domainToDto(medicineSavedDetails));
        log.info("MedicineServiceImpl.saveMedicine method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateMedicine(MedicineDTO medicineDTO) {
        log.info("MedicineServiceImpl.updateMedicine method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Medicine> medicine = medicineRepository.findById(medicineDTO.getId());
        if(medicine.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Medicine details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Medicine details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Medicine medicineUpdatedDetails = medicineRepository.save(medicineMapper.dtoToDomain(medicineDTO, medicine.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Medicine details is update success!");
        commonResponse.setData(medicineMapper.domainToDto(medicineUpdatedDetails));
        log.info("MedicineServiceImpl.updateMedicine method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteMedicineDetailsByMedicineId(Long medicineId) {
        log.info("MedicineServiceImpl.deleteMedicineDetailsByMedicineId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Medicine> medicine = medicineRepository.findById(medicineId);
        if(medicine.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete medicine details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Medicine details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        medicineRepository.deleteById(medicineId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Medicine details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("MedicineServiceImpl.deleteMedicineDetailsByMedicineId method end");
        return commonResponse;
    }
}
