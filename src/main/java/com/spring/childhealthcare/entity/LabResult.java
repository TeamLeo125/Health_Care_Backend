package com.spring.childhealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lab_result")
public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient")
    private Patient patient;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "details")
    private String details;

    @Column(name = "testName")
    private String testName;

    @Column(name = "labNo")
    private String labNo;

    @Column(name = "referredBy")
    private String referredBy;

    @OneToMany(mappedBy = "labResult")
    private List<LabAnalysis> labAnalysisList;

}

