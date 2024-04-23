package com.spring.childhealthcare.repository;

import com.spring.childhealthcare.entity.PdfDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfRepository extends JpaRepository<PdfDocument, Long> {
}
