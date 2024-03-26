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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_birth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "patient")
    private BodyMassIndex bodyMassIndex;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "patient")
    private List<LabResult> labResultList;

    @OneToMany(mappedBy = "patient")
    private List<Report> reportList;

    @OneToOne(mappedBy = "patient")
    private Booking booking;

    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptionList;
}
