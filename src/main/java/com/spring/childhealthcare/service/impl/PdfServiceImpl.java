package com.spring.childhealthcare.service.impl;

import com.itextpdf.html2pdf.HtmlConverter;
import com.spring.childhealthcare.dto.PrescriptionDTO;
import com.spring.childhealthcare.entity.Medicine;
import com.spring.childhealthcare.entity.Prescription;
import com.spring.childhealthcare.exception.ReferenceNotFoundException;
import com.spring.childhealthcare.mapper.PrescriptionMapper;
import com.spring.childhealthcare.repository.PrescriptionRepository;
import com.spring.childhealthcare.service.PdfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PdfServiceImpl implements PdfService {
    private final SpringTemplateEngine templateEngine;
    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;
    @Override
    public byte[] generatePdf(String title, String content) {
        Context context = new Context();
        context.setVariable("title", title);
        context.setVariable("content", content);
        String processedHtml = templateEngine.process("prescription-receipt", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            HtmlConverter.convertToPdf(processedHtml, outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @Override
    public byte[] generatePrescription(PrescriptionDTO prescriptionDTO) {
        Context context = new Context();
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionDTO.getId());
        if (prescription.isPresent()){
            log.info("The prescription is already exist!");
            return new byte[0];
        }
        Prescription savedPrescription = prescriptionRepository.save(prescriptionMapper.dtoToDomain(prescriptionDTO, new Prescription()));

        context.setVariable("id", savedPrescription.getId());
        context.setVariable("date", savedPrescription.getDate());
        context.setVariable("doctorId", savedPrescription.getDoctor().getDoctorId());
        context.setVariable("doctorFirstName", savedPrescription.getDoctor().getFirstName());
        context.setVariable("doctorJobTitle", savedPrescription.getDoctor().getJobTitle());
        context.setVariable("doctorSpecialization", savedPrescription.getDoctor().getSpecialization());
        context.setVariable("patientId", savedPrescription.getPatient().getPatientId());
        context.setVariable("patientFirstName", savedPrescription.getPatient().getFirstName());
        context.setVariable("patientAddress", savedPrescription.getPatient().getAddress());
        context.setVariable("patientBodyMassIndex", savedPrescription.getPatient().getBodyMassIndex());
        context.setVariable("medicine", savedPrescription.getMedicine());
        double subtotal = 0.0;
        double discount = 0.0;
        double tax = 0.0;
        double total = 0.0;
        for (Medicine medicine: savedPrescription.getMedicine()){
            subtotal = subtotal + medicine.getRate();
        }
        total = total + subtotal;
        context.setVariable("subtotal", subtotal);
        context.setVariable("discount", discount);
        context.setVariable("tax", tax);
        context.setVariable("total", total);


        String processedHtml = templateEngine.process("prescription-receipt", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            HtmlConverter.convertToPdf(processedHtml, outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
