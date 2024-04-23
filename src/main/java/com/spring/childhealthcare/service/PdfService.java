package com.spring.childhealthcare.service;

import com.spring.childhealthcare.dto.PrescriptionDTO;

public interface PdfService {
    byte[] generatePdf(String title, String content);

    byte[] generatePrescription(PrescriptionDTO prescriptionDTO);
}
