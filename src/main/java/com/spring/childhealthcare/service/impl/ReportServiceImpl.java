package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.ReportDTO;
import com.spring.childhealthcare.entity.Report;
import com.spring.childhealthcare.mapper.ReportMapper;
import com.spring.childhealthcare.repository.ReportRepository;
import com.spring.childhealthcare.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    public CommonResponse getAllReportDetails() {
        log.info("ReportServiceImpl.getAllReportDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<ReportDTO> reportDTOList = new ArrayList<>();
        List<Report> reportList = reportRepository.findAll();
        reportList.forEach(report ->  reportDTOList.add(reportMapper.domainToDto(report)));
        if (reportList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Report details list not available!");
            log.warn("Report details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Report details are fetching success!");
        commonResponse.setData(reportDTOList);
        log.info("ReportServiceImpl.getAllReportDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getReportDetailsByReportId(Long reportId) {
        log.info("ReportServiceImpl.getReportDetailsByReportId method accessed");
        ReportDTO reportDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Report> report = reportRepository.findById(reportId);
        if(report.isPresent()) {
            reportDTO = reportMapper.domainToDto(report.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Report details is not available!");
            log.warn("Report details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Report details is fetching success!");
        commonResponse.setData(reportDTO);
        log.info("ReportServiceImpl.getReportDetailsByReportId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveReport(ReportDTO reportDTO) {
        log.info("ReportServiceImpl.saveReport method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Report> report = reportRepository.findById(reportDTO.getId());
        if(report.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Report details already exist!");
            commonResponse.setData(reportMapper.domainToDto(report.get()));
            log.warn("Report details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Report reportSavedDetails = reportRepository.save(reportMapper.dtoToDomain(reportDTO, new Report()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Report details saved success!");
        commonResponse.setData(reportMapper.domainToDto(reportSavedDetails));
        log.info("ReportServiceImpl.saveReport method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateReport(ReportDTO reportDTO) {
        log.info("ReportServiceImpl.updateReport method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Report> report = reportRepository.findById(reportDTO.getId());
        if(report.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Report details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Report details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Report reportUpdatedDetails = reportRepository.save(reportMapper.dtoToDomain(reportDTO, report.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Report details is update success!");
        commonResponse.setData(reportMapper.domainToDto(reportUpdatedDetails));
        log.info("ReportServiceImpl.updateReport method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteReportDetailsByReportId(Long reportId) {
        log.info("ReportServiceImpl.deleteReportDetailsByReportId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Report> report = reportRepository.findById(reportId);
        if(report.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete report details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Report details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        reportRepository.deleteById(reportId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Report details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("ReportServiceImpl.deleteReportDetailsByReportId method end");
        return commonResponse;
    }
}
