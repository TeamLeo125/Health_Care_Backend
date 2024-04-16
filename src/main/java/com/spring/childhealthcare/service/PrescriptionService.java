package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.PrescriptionDTO;

public interface PrescriptionService {
    /**
     * Get all prescription
     *
     * @return success or fail response of prescription creation
     */
    CommonResponse getAllPrescriptionDetails();

    /**
     * Get prescription by prescription id
     *
     * @param prescriptionId - required data for get prescription by prescription id
     * @return success or fail response of get prescription by prescription id
     */
    CommonResponse getPrescriptionDetailsByPrescriptionId(Long prescriptionId);

    /**
     * Create prescription
     *
     * @param prescriptionDTO - required data for prescription save
     * @return success or fail response of prescription save
     */
    CommonResponse savePrescription(PrescriptionDTO prescriptionDTO);

    /**
     * Update prescription
     *
     * @param prescriptionDTO - required data for prescription update
     * @return success or fail response of prescription update
     */
    CommonResponse updatePrescription(PrescriptionDTO prescriptionDTO);

    /**
     * Delete prescription by prescription id
     *
     * @param prescriptionId - required data for delete prescription by prescription id
     * @return success or fail response of delete prescription by prescription id
     */
    CommonResponse deletePrescriptionDetailsByPrescriptionId(Long prescriptionId);
}
