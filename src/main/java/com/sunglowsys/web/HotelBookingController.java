package com.sunglowsys.web;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.dto.BookingDetailsDto;
import com.sunglowsys.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class HotelBookingController {

    private final HotelBookingService bookingService;

    private final HotelService hotelService;

    private final RoomTypeService roomTypeService;

    private final RatePlanService planService;

    private final CustomerService customerService;

    public HotelBookingController(HotelBookingService bookingService, HotelService hotelService, RoomTypeService roomTypeService, RatePlanService planService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
        this.planService = planService;
        this.customerService = customerService;
    }

    @GetMapping("/bookings")
    public ModelAndView getBookings() {
        List<HotelBooking> result = bookingService.findAll();
        return new ModelAndView("booking", "bookings", result);
    }

    @GetMapping("/bookings-form")
    public ModelAndView loadForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("roomTypes", roomTypeService.findAll());
        modelAndView.addObject("ratePlans", planService.findAll());
        modelAndView.addObject("booking", new BookingDetailsDto());
        modelAndView.setViewName("new-booking");
        return modelAndView;
    }

    @PostMapping("/bookings-create")
    public ModelAndView createBooking(@ModelAttribute BookingDetailsDto bookingDetailsDto) {
        Customer customer = new Customer(
                bookingDetailsDto.getFirstName(),
                bookingDetailsDto.getLastName(),
                bookingDetailsDto.getEmail(),
                bookingDetailsDto.getMobile(),
                bookingDetailsDto.getGender(),
                bookingDetailsDto.getAge(),
                bookingDetailsDto.getIdType(),
                bookingDetailsDto.getIdNumber()
        );

        Customer result = customerService.save(customer);

        HotelBooking booking = new HotelBooking(
                bookingDetailsDto.getCheckInDate(),
                bookingDetailsDto.getCheckOutDate(),
                bookingDetailsDto.getNoOfAdult(),
                bookingDetailsDto.getNoOfChild(),
                bookingDetailsDto.getNoOfRoom(),
                bookingDetailsDto.getNoOfNight(),
                result,
                bookingDetailsDto.getHotel(),
                bookingDetailsDto.getRoomType(),
                bookingDetailsDto.getRatePlan()
        );
        bookingService.save(booking);
        return new  ModelAndView("redirect:/bookings");
    }
}
