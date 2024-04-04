package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.DoctorDTO;
import com.spring.childhealthcare.service.DoctorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/doctor")
@Slf4j
public class DoctorController {
    private final DoctorService doctorService;

    /**
     * Get all doctor
     *
     * @return success or fail response of doctor creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllDoctorDetails() {
        CommonResponse commonResponse = doctorService.getAllDoctorDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get doctor by doctor id
     *
     * @param doctorId - required data for get doctor by doctor id
     * @return success or fail response of get doctor by doctor id
     */
    @GetMapping("/{doctorId}")
    public ResponseEntity<CommonResponse> getDoctorDetailsByDoctorId(@PathVariable("doctorId") @NotNull String doctorId) {
        CommonResponse commonResponse = doctorService.getDoctorDetailsByDoctorId(doctorId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create doctor
     *
     * @param doctorDTO - required data for doctor save
     * @return success or fail response of doctor save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        CommonResponse commonResponse = doctorService.saveDoctor(doctorDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update doctor
     *
     * @param doctorDTO - required data for doctor update
     * @return success or fail response of doctor update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        CommonResponse commonResponse = doctorService.updateDoctor(doctorDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete doctor by doctor id
     *
     * @param doctorId - required data for delete doctor by doctor id
     * @return success or fail response of delete doctor by doctor id
     */
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<CommonResponse> deleteDoctorDetailsByDoctorId(@PathVariable("doctorId") @NotNull String doctorId) {
        CommonResponse commonResponse = doctorService.deleteDoctorDetailsByDoctorId(doctorId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

}
