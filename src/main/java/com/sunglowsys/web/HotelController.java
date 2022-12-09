package com.sunglowsys.web;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels-form")
    public ModelAndView loadForm() {
        return new ModelAndView("new-hotel", "hotel", new Hotel());
    }

    @PostMapping("/hotels-create")
    public ModelAndView createHotel(@ModelAttribute Hotel hotel) {
        hotelService.save(hotel);
        return new ModelAndView("redirect:/hotels");
    }

    @GetMapping("/hotels")
    public ModelAndView getHotels() {
        return new ModelAndView("hotel", "hotels", hotelService.getAll());
    }

    @GetMapping("/hotels-{id}")
    public ModelAndView getHotel(@PathVariable Long id) {
        Hotel result = hotelService.getById(id).get();
        return new ModelAndView("hotel-details", "hotel", result);
    }

    @GetMapping("/hotels-update-{id}")
    public ModelAndView updateHotel(@PathVariable Long id) {
        Hotel result = hotelService.getById(id).get();
        return new ModelAndView("new-hotel", "hotel", result);
    }

}
