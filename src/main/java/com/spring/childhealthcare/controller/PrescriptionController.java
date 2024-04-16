package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.PrescriptionDTO;
import com.spring.childhealthcare.service.PrescriptionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/prescription")
@Slf4j
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    /**
     * Get all prescription
     *
     * @return success or fail response of prescription creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllPrescriptionDetails() {
        CommonResponse commonResponse = prescriptionService.getAllPrescriptionDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get prescription by prescription id
     *
     * @param prescriptionId - required data for get prescription by prescription id
     * @return success or fail response of get prescription by prescription id
     */
    @GetMapping("/{prescriptionId}")
    public ResponseEntity<CommonResponse> getPrescriptionDetailsByPrescriptionId(@PathVariable("prescriptionId") @NotNull Long prescriptionId) {
        CommonResponse commonResponse = prescriptionService.getPrescriptionDetailsByPrescriptionId(prescriptionId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create prescription
     *
     * @param prescriptionDTO - required data for prescription save
     * @return success or fail response of prescription save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> savePrescription(@Valid @RequestBody PrescriptionDTO prescriptionDTO) {
        CommonResponse commonResponse = prescriptionService.savePrescription(prescriptionDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update prescription
     *
     * @param prescriptionDTO - required data for prescription update
     * @return success or fail response of prescription update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updatePrescription(@Valid @RequestBody PrescriptionDTO prescriptionDTO) {
        CommonResponse commonResponse = prescriptionService.updatePrescription(prescriptionDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete prescription by prescription id
     *
     * @param prescriptionId - required data for delete prescription by prescription id
     * @return success or fail response of delete prescription by prescription id
     */
    @DeleteMapping("/{prescriptionId}")
    public ResponseEntity<CommonResponse> deletePrescriptionDetailsByPrescriptionId(@PathVariable("prescriptionId") @NotNull Long prescriptionId) {
        CommonResponse commonResponse = prescriptionService.deletePrescriptionDetailsByPrescriptionId(prescriptionId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
