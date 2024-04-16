package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.AppointmentDTO;
import com.spring.childhealthcare.service.AppointmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/appointment")
@Slf4j
public class AppointmentController {
    private final AppointmentService appointmentService;

    /**
     * Get all Appointment
     *
     * @return success or fail response of Appointment creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllAppointmentDetails() {
        CommonResponse commonResponse = appointmentService.getAllAppointmentDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get Appointment by Appointment id
     *
     * @param appointmentId - required data for get Appointment by Appointment id
     * @return success or fail response of get Appointment by Appointment id
     */
    @GetMapping("/{appointmentId}")
    public ResponseEntity<CommonResponse> getAppointmentDetailsByAppointmentId(@PathVariable("appointmentId") @NotNull Long appointmentId) {
        CommonResponse commonResponse = appointmentService.getAppointmentDetailsByAppointmentId(appointmentId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create Appointment
     *
     * @param appointmentDTO - required data for Appointment save
     * @return success or fail response of Appointment save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
        CommonResponse commonResponse = appointmentService.saveAppointment(appointmentDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update Appointment
     *
     * @param appointmentDTO - required data for Appointment update
     * @return success or fail response of Appointment update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
        CommonResponse commonResponse = appointmentService.updateAppointment(appointmentDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete Appointment by Appointment id
     *
     * @param appointmentId - required data for delete Appointment by Appointment id
     * @return success or fail response of delete Appointment by Appointment id
     */
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<CommonResponse> deleteAppointmentDetailsByAppointmentId(@PathVariable("appointmentId") @NotNull Long appointmentId) {
        CommonResponse commonResponse = appointmentService.deleteAppointmentDetailsByAppointmentId(appointmentId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
