package com.sunglowsys.service.impl;

import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.repository.HotelBookingRepository;
import com.sunglowsys.service.HotelBookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HotelBookingServiceImpl implements HotelBookingService {

    private final HotelBookingRepository bookingRepository;

    public HotelBookingServiceImpl(HotelBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public HotelBooking save(HotelBooking hotelBooking) {
        hotelBooking.setBookingDate(LocalDate.now());
        hotelBooking.setTotalGuest(hotelBooking.getNoOfAdult() + hotelBooking.getNoOfChild());
        return bookingRepository.save(hotelBooking);
    }

    @Override
    public HotelBooking update(HotelBooking hotelBooking) {
        return bookingRepository.save(hotelBooking);
    }

    @Override
    public List<HotelBooking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<HotelBooking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}
