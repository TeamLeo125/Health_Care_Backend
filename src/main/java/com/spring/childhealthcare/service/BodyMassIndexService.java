package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.BodyMassIndexDTO;

public interface BodyMassIndexService {
    /**
     * Get all bodyMassIndex
     *
     * @return success or fail response of bodyMassIndex creation
     */
    CommonResponse getAllBodyMassIndexDetails();

    /**
     * Get bodyMassIndex by id
     *
     * @param bodyMassIndexId - required data for get bodyMassIndex by id
     * @return success or fail response of get bodyMassIndex by id
     */
    CommonResponse getBodyMassIndexDetailsById(Long bodyMassIndexId);

    /**
     * Create bodyMassIndex
     *
     * @param bodyMassIndexDTO - required data for bodyMassIndex save
     * @return success or fail response of bodyMassIndex save
     */
    CommonResponse saveBodyMassIndex(BodyMassIndexDTO bodyMassIndexDTO);

    /**
     * Update bodyMassIndex
     *
     * @param bodyMassIndexDTO - required data for bodyMassIndex update
     * @return success or fail response of bodyMassIndex update
     */
    CommonResponse updateBodyMassIndex(BodyMassIndexDTO bodyMassIndexDTO);

    /**
     * Delete bodyMassIndex by id
     *
     * @param bodyMassIndexId - required data for delete bodyMassIndex by id
     * @return success or fail response of delete bodyMassIndex by id
     */
    CommonResponse deleteBodyMassIndexDetailsById(Long bodyMassIndexId);
}
