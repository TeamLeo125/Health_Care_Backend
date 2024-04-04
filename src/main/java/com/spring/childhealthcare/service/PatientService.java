package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.PatientDTO;

public interface PatientService {
    /**
     * Get all patient
     *
     * @return success or fail response of patient creation
     */
    CommonResponse getAllPatientDetails();

    /**
     * Get patient by patient id
     *
     * @param patientId - required data for get patient by patient id
     * @return success or fail response of get patient by patient id
     */
    CommonResponse getPatientDetailsByPatientId(String patientId);

    /**
     * Create patient
     *
     * @param patientDTO - required data for patient save
     * @return success or fail response of patient save
     */
    CommonResponse savePatient(PatientDTO patientDTO);

    /**
     * Update patient
     *
     * @param patientDTO - required data for patient update
     * @return success or fail response of patient update
     */
    CommonResponse updatePatient(PatientDTO patientDTO);

    /**
     * Delete patient by patient id
     *
     * @param patientId - required data for delete patient by patient id
     * @return success or fail response of delete patient by patient id
     */
    CommonResponse deletePatientDetailsByPatientId(String patientId);
}
