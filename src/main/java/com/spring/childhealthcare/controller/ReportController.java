package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.ReportDTO;
import com.spring.childhealthcare.service.ReportService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/report")
@Slf4j
public class ReportController {
    private final ReportService reportService;

    /**
     * Get all report
     *
     * @return success or fail response of report creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllReportDetails() {
        CommonResponse commonResponse = reportService.getAllReportDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get report by report id
     *
     * @param reportId - required data for get report by report id
     * @return success or fail response of get report by report id
     */
    @GetMapping("/{reportId}")
    public ResponseEntity<CommonResponse> getReportDetailsByReportId(@PathVariable("reportId") @NotNull Long reportId) {
        CommonResponse commonResponse = reportService.getReportDetailsByReportId(reportId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create report
     *
     * @param reportDTO - required data for report save
     * @return success or fail response of report save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveReport(@Valid @RequestBody ReportDTO reportDTO) {
        CommonResponse commonResponse = reportService.saveReport(reportDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update report
     *
     * @param reportDTO - required data for report update
     * @return success or fail response of report update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateReport(@Valid @RequestBody ReportDTO reportDTO) {
        CommonResponse commonResponse = reportService.updateReport(reportDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete report by report id
     *
     * @param reportId - required data for delete report by report id
     * @return success or fail response of delete report by report id
     */
    @DeleteMapping("/{reportId}")
    public ResponseEntity<CommonResponse> deleteReportDetailsByReportId(@PathVariable("reportId") @NotNull Long reportId) {
        CommonResponse commonResponse = reportService.deleteReportDetailsByReportId(reportId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
