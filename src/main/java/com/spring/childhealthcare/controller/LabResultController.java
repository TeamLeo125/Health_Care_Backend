package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.LabResultDTO;
import com.spring.childhealthcare.service.LabResultService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/labResult")
@Slf4j
public class LabResultController {

    private final LabResultService labResultService;

    /**
     * Get all labResult
     *
     * @return success or fail response of labResult creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllLabResultDetails() {
        CommonResponse commonResponse = labResultService.getAllLabResultDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get labResult by labResult id
     *
     * @param labResultId - required data for get labResult by labResult id
     * @return success or fail response of get labResult by labResult id
     */
    @GetMapping("/{labResultId}")
    public ResponseEntity<CommonResponse> getLabResultDetailsByLabResultId(@PathVariable("labResultId") @NotNull Long labResultId) {
        CommonResponse commonResponse = labResultService.getLabResultDetailsByLabResultId(labResultId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create labResult
     *
     * @param labResultDTO - required data for labResult save
     * @return success or fail response of labResult save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveLabResult(@Valid @RequestBody LabResultDTO labResultDTO) {
        CommonResponse commonResponse = labResultService.saveLabResult(labResultDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update labResult
     *
     * @param labResultDTO - required data for labResult update
     * @return success or fail response of labResult update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateLabResult(@Valid @RequestBody LabResultDTO labResultDTO) {
        CommonResponse commonResponse = labResultService.updateLabResult(labResultDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete labResult by labResult id
     *
     * @param labResultId - required data for delete labResult by labResult id
     * @return success or fail response of delete labResult by labResult id
     */
    @DeleteMapping("/{labResultId}")
    public ResponseEntity<CommonResponse> deleteLabResultDetailsByLabResultId(@PathVariable("labResultId") @NotNull Long labResultId) {
        CommonResponse commonResponse = labResultService.deleteLabResultDetailsByLabResultId(labResultId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
