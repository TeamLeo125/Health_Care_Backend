package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.LabResultDTO;

public interface LabResultService {
    /**
     * Get all labResult
     *
     * @return success or fail response of labResult creation
     */
    CommonResponse getAllLabResultDetails();

    /**
     * Get labResult by labResult id
     *
     * @param labResultId - required data for get labResult by labResult id
     * @return success or fail response of get labResult by labResult id
     */
    CommonResponse getLabResultDetailsByLabResultId(Long labResultId);

    /**
     * Create labResult
     *
     * @param labResultDTO - required data for labResult save
     * @return success or fail response of labResult save
     */
    CommonResponse saveLabResult(LabResultDTO labResultDTO);

    /**
     * Update labResult
     *
     * @param labResultDTO - required data for labResult update
     * @return success or fail response of labResult update
     */
    CommonResponse updateLabResult(LabResultDTO labResultDTO);

    /**
     * Delete labResult by labResult id
     *
     * @param labResultId - required data for delete labResult by labResult id
     * @return success or fail response of delete labResult by labResult id
     */
    CommonResponse deleteLabResultDetailsByLabResultId(Long labResultId);
}
