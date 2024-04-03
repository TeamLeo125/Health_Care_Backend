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
     * Get medicine by medicine id
     *
     * @param appointmentId - required data for get medicine by medicine id
     * @return success or fail response of get medicine by medicine id
     */
//    CommonResponse getAppointmentDetailsByAppointmentId(Long appointmentId);
//
//    /**
//     * Create medicine
//     *
//     * @param appointmentDTO - required data for medicine save
//     * @return success or fail response of medicine save
//     */
//    CommonResponse saveAppointment(AppointmentDTO appointmentDTO);
//
//    /**
//     * Update medicine
//     *
//     * @param appointmentDTO - required data for medicine update
//     * @return success or fail response of medicine update
//     */
//    CommonResponse updateAppointment(AppointmentDTO appointmentDTO);
//
//    /**
//     * Delete medicine by medicine id
//     *
//     * @param appointmentId - required data for delete medicine by medicine id
//     * @return success or fail response of delete medicine by medicine id
//     */
//    CommonResponse deleteAppointmentDetailsByAppointmentId(Long appointmentId);
}
