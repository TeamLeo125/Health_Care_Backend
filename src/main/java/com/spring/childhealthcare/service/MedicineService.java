package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.MedicineDTO;

public interface MedicineService {
    /**
     * Get all medicine
     *
     * @return success or fail response of medicine creation
     */
    CommonResponse getAllMedicineDetails();

    /**
     * Get medicine by medicine id
     *
     * @param medicineId - required data for get medicine by medicine id
     * @return success or fail response of get medicine by medicine id
     */
    CommonResponse getMedicineDetailsByMedicineId(Long medicineId);

    /**
     * Create medicine
     *
     * @param medicineDTO - required data for medicine save
     * @return success or fail response of medicine save
     */
    CommonResponse saveMedicine(MedicineDTO medicineDTO);

    /**
     * Update medicine
     *
     * @param medicineDTO - required data for medicine update
     * @return success or fail response of medicine update
     */
    CommonResponse updateMedicine(MedicineDTO medicineDTO);

    /**
     * Delete medicine by medicine id
     *
     * @param medicineId - required data for delete medicine by medicine id
     * @return success or fail response of delete medicine by medicine id
     */
    CommonResponse deleteMedicineDetailsByMedicineId(Long medicineId);

}
