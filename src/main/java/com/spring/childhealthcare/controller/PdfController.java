package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.dto.LabResultDTO;
import com.spring.childhealthcare.dto.PrescriptionDTO;
import com.spring.childhealthcare.dto.ReceiptDTO;
import com.spring.childhealthcare.entity.PdfDocument;
import com.spring.childhealthcare.repository.PdfRepository;
import com.spring.childhealthcare.service.PdfService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pdf")
@Slf4j
@AllArgsConstructor
public class PdfController {
    private final PdfService pdfService;
    private final PdfRepository pdfRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPdf(@RequestBody ReceiptDTO receiptDTO){
        byte[] pdf = pdfService.generatePdf(receiptDTO.getTitle(), receiptDTO.getContent());
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.setData(pdf);
        pdfRepository.save(pdfDocument);
        return ResponseEntity.ok("PDF uploaded with ID: " + pdfDocument.getId());
    }

    @PostMapping("/upload-prescription")
    public ResponseEntity<String> uploadPrescription(@RequestBody PrescriptionDTO prescriptionDTO){
        byte[] pdf = pdfService.generatePrescription(prescriptionDTO);
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.setData(pdf);
        pdfRepository.save(pdfDocument);
        return ResponseEntity.ok("Prescription PDF uploaded with ID: " + pdfDocument.getId());
    }

    @PostMapping("/upload-lab-report")
    public ResponseEntity<String> uploadLabReport(@RequestBody LabResultDTO labResultDTO){
        byte[] pdf = pdfService.generateLabReport(labResultDTO);
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.setData(pdf);
        pdfRepository.save(pdfDocument);
        return ResponseEntity.ok("Lab report PDF uploaded with ID: " + pdfDocument.getId());
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id){
        PdfDocument pdfDocument = pdfRepository.findById(id).orElseThrow();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfDocument.getData());
    }

}
