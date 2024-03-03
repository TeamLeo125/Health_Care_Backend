package com.spring.childhealthcare.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class BookingDTO {
    @NotNull(message = "Date should be not null")
    private LocalDate date;
    @NotNull(message = "Bookingfor cannot be empty")
    private String bookingFor;
    @NotNull(message = "Status cannot be empty")
    private String status;
}
