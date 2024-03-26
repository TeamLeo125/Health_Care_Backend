package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.MedicineDTO;
import com.spring.childhealthcare.service.MedicineService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/medicine")
@Slf4j
public class MedicineController {
    private final MedicineService medicineService;

    /**
     * Get all medicine
     *
     * @return success or fail response of medicine creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllMedicineDetails() {
        CommonResponse commonResponse = medicineService.getAllMedicineDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get medicine by medicine id
     *
     * @param medicineId - required data for get medicine by medicine id
     * @return success or fail response of get medicine by medicine id
     */
    @GetMapping("/{medicineId}")
    public ResponseEntity<CommonResponse> getMedicineDetailsByMedicineId(@PathVariable("medicineId") @NotNull Long medicineId) {
        CommonResponse commonResponse = medicineService.getMedicineDetailsByMedicineId(medicineId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create medicine
     *
     * @param medicineDTO - required data for medicine save
     * @return success or fail response of medicine save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveMedicine(@Valid @RequestBody MedicineDTO medicineDTO) {
        CommonResponse commonResponse = medicineService.saveMedicine(medicineDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update medicine
     *
     * @param medicineDTO - required data for medicine update
     * @return success or fail response of medicine update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateMedicine(@Valid @RequestBody MedicineDTO medicineDTO) {
        CommonResponse commonResponse = medicineService.updateMedicine(medicineDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete medicine by medicine id
     *
     * @param medicineId - required data for delete medicine by medicine id
     * @return success or fail response of delete medicine by medicine id
     */
    @DeleteMapping("/{medicineId}")
    public ResponseEntity<CommonResponse> deleteMedicineDetailsByMedicineId(@PathVariable("medicineId") @NotNull Long medicineId) {
        CommonResponse commonResponse = medicineService.deleteMedicineDetailsByMedicineId(medicineId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

}
