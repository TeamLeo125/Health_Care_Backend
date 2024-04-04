package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.PatientDTO;
import com.spring.childhealthcare.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/patient")
@Slf4j
public class PatientController {
    private final PatientService patientService;

    /**
     * Get all patient
     *
     * @return success or fail response of patient creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllPatientDetails() {
        CommonResponse commonResponse = patientService.getAllPatientDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get patient by patient id
     *
     * @param patientId - required data for get patient by patient id
     * @return success or fail response of get patient by patient id
     */
    @GetMapping("/{patientId}")
    public ResponseEntity<CommonResponse> getPatientDetailsByPatientId(@PathVariable("patientId") @NotNull String patientId) {
        CommonResponse commonResponse = patientService.getPatientDetailsByPatientId(patientId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create patient
     *
     * @param patientDTO - required data for patient save
     * @return success or fail response of patient save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> savePatient(@Valid @RequestBody PatientDTO patientDTO) {
        CommonResponse commonResponse = patientService.savePatient(patientDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update patient
     *
     * @param patientDTO - required data for patient update
     * @return success or fail response of patient update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updatePatient(@Valid @RequestBody PatientDTO patientDTO) {
        CommonResponse commonResponse = patientService.updatePatient(patientDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete patient by patient id
     *
     * @param patientId - required data for delete patient by patient id
     * @return success or fail response of delete patient by patient id
     */
    @DeleteMapping("/{patientId}")
    public ResponseEntity<CommonResponse> deletePatientDetailsByPatientId(@PathVariable("patientId") @NotNull String patientId) {
        CommonResponse commonResponse = patientService.deletePatientDetailsByPatientId(patientId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
