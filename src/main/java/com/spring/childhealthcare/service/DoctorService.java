package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.DoctorDTO;

public interface DoctorService {
    /**
     * Get all doctor
     *
     * @return success or fail response of doctor creation
     */
    CommonResponse getAllDoctorDetails();

    /**
     * Get doctor by doctor id
     *
     * @param doctorId - required data for get doctor by doctor id
     * @return success or fail response of get doctor by doctor id
     */
    CommonResponse getDoctorDetailsByDoctorId(Long doctorId);

    /**
     * Create doctor
     *
     * @param doctorDTO - required data for doctor save
     * @return success or fail response of doctor save
     */
    CommonResponse saveDoctor(DoctorDTO doctorDTO);

    /**
     * Update doctor
     *
     * @param doctorDTO - required data for doctor update
     * @return success or fail response of doctor update
     */
    CommonResponse updateDoctor(DoctorDTO doctorDTO);

    /**
     * Delete doctor by doctor id
     *
     * @param doctorId - required data for delete doctor by doctor id
     * @return success or fail response of delete doctor by doctor id
     */
    CommonResponse deleteDoctorDetailsByDoctorId(Long doctorId);
}
