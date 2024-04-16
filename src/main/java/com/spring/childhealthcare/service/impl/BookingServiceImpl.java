package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.BookingDTO;
import com.spring.childhealthcare.entity.Booking;
import com.spring.childhealthcare.mapper.BookingMapper;
import com.spring.childhealthcare.repository.BookingRepository;
import com.spring.childhealthcare.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    @Override
    public CommonResponse getAllBookingDetails() {
        log.info("BookingServiceImpl.getAllBookingDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<BookingDTO> bookingDTOList = new ArrayList<>();
        List<Booking> bookingList = bookingRepository.findAll();
        bookingList.forEach(medicine ->  bookingDTOList.add(bookingMapper.domainToDto(medicine)));
        if (bookingList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Booking details list not available!");
            log.warn("Booking details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Booking details are fetching success!");
        commonResponse.setData(bookingDTOList);
        log.info("BookingServiceImpl.getAllBookingDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getBookingDetailsByBookingId(Long bookingId) {
        log.info("BookingServiceImpl.getBookingDetailsByBookingId method accessed");
        BookingDTO bookingDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if(booking.isPresent()) {
            bookingDTO = bookingMapper.domainToDto(booking.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Booking details is not available!");
            log.warn("Booking details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Booking details is fetching success!");
        commonResponse.setData(bookingDTO);
        log.info("BookingServiceImpl.getBookingDetailsByBookingId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveBooking(BookingDTO bookingDTO) {
        log.info("BookingServiceImpl.saveBooking method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Booking> booking = bookingRepository.findById(bookingDTO.getId());
        if(booking.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Booking details already exist!");
            commonResponse.setData(bookingMapper.domainToDto(booking.get()));
            log.warn("Booking details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Booking bookingSavedDetails = bookingRepository.save(bookingMapper.dtoToDomain(bookingDTO, new Booking()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Booking details saved success!");
        commonResponse.setData(bookingMapper.domainToDto(bookingSavedDetails));
        log.info("BookingServiceImpl.saveBooking method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateBooking(BookingDTO bookingDTO) {
        log.info("BookingServiceImpl.updateBooking method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Booking> booking = bookingRepository.findById(bookingDTO.getId());
        if(booking.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Booking details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Booking details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Booking bookingUpdatedDetails = bookingRepository.save(bookingMapper.dtoToDomain(bookingDTO, booking.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Booking details is update success!");
        commonResponse.setData(bookingMapper.domainToDto(bookingUpdatedDetails));
        log.info("BookingServiceImpl.updateBooking method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteBookingDetailsByBookingId(Long bookingId) {
        log.info("BookingServiceImpl.deleteBookingDetailsByBookingId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if(booking.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete booking details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Booking details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        bookingRepository.deleteById(bookingId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Booking details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("BookingServiceImpl.deleteBookingDetailsByBookingId method end");
        return commonResponse;
    }
}
