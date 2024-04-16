package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.ReportDTO;

public interface ReportService {
    /**
     * Get all report
     *
     * @return success or fail response of report creation
     */
    CommonResponse getAllReportDetails();

    /**
     * Get report by report id
     *
     * @param reportId - required data for get report by report id
     * @return success or fail response of get report by report id
     */
    CommonResponse getReportDetailsByReportId(Long reportId);

    /**
     * Create report
     *
     * @param reportDTO - required data for report save
     * @return success or fail response of report save
     */
    CommonResponse saveReport(ReportDTO reportDTO);

    /**
     * Update report
     *
     * @param reportDTO - required data for report update
     * @return success or fail response of report update
     */
    CommonResponse updateReport(ReportDTO reportDTO);

    /**
     * Delete report by report id
     *
     * @param reportId - required data for delete report by report id
     * @return success or fail response of delete report by report id
     */
    CommonResponse deleteReportDetailsByReportId(Long reportId);
}
