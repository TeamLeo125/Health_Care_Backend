package com.spring.childhealthcare.mapper;

import com.spring.childhealthcare.dto.MedicineDTO;
import com.spring.childhealthcare.entity.Medicine;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class MedicineMapper {

    public Medicine dtoToDomain(MedicineDTO dto, Medicine domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The MedicineDTO should not be null");
        }
        domain.setId(dto.getId());
        domain.setName(dto.getName());
        domain.setDescription(dto.getDescription());
        domain.setDosage(dto.getDosage());
        return domain;
    }

    public MedicineDTO domainToDto(Medicine domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Medicine should not be null");
        }
        MedicineDTO dto = new MedicineDTO();
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setDescription(domain.getDescription());
        dto.setDosage(domain.getDosage());
        return dto;
    }

}
