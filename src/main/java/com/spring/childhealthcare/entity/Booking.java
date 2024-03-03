package com.spring.childhealthcare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Integer id;
    @Column(name = "booking_date")
    private LocalDate date;
    @Column(name = "booking_for")
    private String bookingFor;
    @Column(name = "booking_status")
    private String status;
}
