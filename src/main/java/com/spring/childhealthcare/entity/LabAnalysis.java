package com.spring.childhealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lab_analysis")
public class LabAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "test")
    private String test;
    @Column(name = "result")
    private String result;
    @Column(name = "referenceRage")
    private String referenceRage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "labResult")
    private LabResult labResult;

}
