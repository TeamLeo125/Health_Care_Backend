package com.spring.childhealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_booking_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "doctor_booking_id")
    private Integer id;
    @Column(name = "doctor_name")
    private String doctorName;
    @Column(name = "doctor_booking_date")
    private String date;
    @Column(name = "doctor_booking_time")
    private String time;
}
