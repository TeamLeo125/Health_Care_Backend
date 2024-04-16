package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.AppointmentDTO;
import com.spring.childhealthcare.dto.MedicineDTO;

public interface AppointmentService {
    /**
     * Get all Appointment
     *
     * @return success or fail response of Appointment creation
     */
    CommonResponse getAllAppointmentDetails();

    /**
     * Get Appointment by Appointment id
     *
     * @param appointmentId - required data for get Appointment by Appointment id
     * @return success or fail response of get Appointment by Appointment id
     */
    CommonResponse getAppointmentDetailsByAppointmentId(Long appointmentId);

    /**
     * Create Appointment
     *
     * @param appointmentDTO - required data for Appointment save
     * @return success or fail response of Appointment save
     */
    CommonResponse saveAppointment(AppointmentDTO appointmentDTO);

    /**
     * Update Appointment
     *
     * @param appointmentDTO - required data for Appointment update
     * @return success or fail response of Appointment update
     */
    CommonResponse updateAppointment(AppointmentDTO appointmentDTO);

    /**
     * Delete Appointment by Appointment id
     *
     * @param appointmentId - required data for delete Appointment by Appointment id
     * @return success or fail response of delete Appointment by Appointment id
     */
    CommonResponse deleteAppointmentDetailsByAppointmentId(Long appointmentId);
}
