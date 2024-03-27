package com.spring.childhealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "medical_school")
    private String medicalSchool;

    @Column(name = "year_of_experience")
    private Integer yearOfExperience;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "doctor")
    private List<Report> reportList;

    @OneToMany(mappedBy = "doctor")
    private List<Prescription> prescriptionList;
}
