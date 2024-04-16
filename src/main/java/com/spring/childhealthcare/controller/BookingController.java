package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.BookingDTO;
import com.spring.childhealthcare.dto.MedicineDTO;
import com.spring.childhealthcare.service.BookingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/booking")
public class BookingController {
    private final BookingService bookingService;

    /**
     * Get all booking
     *
     * @return success or fail response of booking creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllBookingDetails() {
        CommonResponse commonResponse = bookingService.getAllBookingDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get booking by booking id
     *
     * @param bookingId - required data for get booking by booking id
     * @return success or fail response of get booking by booking id
     */
    @GetMapping("/{bookingId}")
    public ResponseEntity<CommonResponse> getBookingDetailsByBookingId(@PathVariable("bookingId") @NotNull Long bookingId) {
        CommonResponse commonResponse = bookingService.getBookingDetailsByBookingId(bookingId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create booking
     *
     * @param bookingDTO - required data for booking save
     * @return success or fail response of booking save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        CommonResponse commonResponse = bookingService.saveBooking(bookingDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update booking
     *
     * @param bookingDTO - required data for booking update
     * @return success or fail response of booking update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        CommonResponse commonResponse = bookingService.updateBooking(bookingDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete booking by booking id
     *
     * @param bookingId - required data for delete booking by booking id
     * @return success or fail response of delete booking by booking id
     */
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<CommonResponse> deleteBookingDetailsByBookingId(@PathVariable("bookingId") @NotNull Long bookingId) {
        CommonResponse commonResponse = bookingService.deleteBookingDetailsByBookingId(bookingId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
