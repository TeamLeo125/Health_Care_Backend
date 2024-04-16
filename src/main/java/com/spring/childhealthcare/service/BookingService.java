package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.BookingDTO;

public interface BookingService {
    /**
     * Get all booking
     *
     * @return success or fail response of booking creation
     */
    CommonResponse getAllBookingDetails();

    /**
     * Get booking by booking id
     *
     * @param bookingId - required data for get booking by booking id
     * @return success or fail response of get booking by booking id
     */
    CommonResponse getBookingDetailsByBookingId(Long bookingId);

    /**
     * Create booking
     *
     * @param bookingDTO - required data for booking save
     * @return success or fail response of booking save
     */
    CommonResponse saveBooking(BookingDTO bookingDTO);

    /**
     * Update booking
     *
     * @param bookingDTO - required data for booking update
     * @return success or fail response of booking update
     */
    CommonResponse updateBooking(BookingDTO bookingDTO);

    /**
     * Delete booking by booking id
     *
     * @param bookingId - required data for delete booking by booking id
     * @return success or fail response of delete booking by booking id
     */
    CommonResponse deleteBookingDetailsByBookingId(Long bookingId);
}
