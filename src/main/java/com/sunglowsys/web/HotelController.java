package com.sunglowsys.web;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels/form")
    public ModelAndView loadForm() {
        return new ModelAndView("add-hotel", "hotel", new Hotel());
    }

    @PostMapping("/hotels/create")
    public ModelAndView createHotel(@ModelAttribute Hotel hotel) {
        hotelService.save(hotel);
        return new ModelAndView("redirect:/hotels");
    }

    @GetMapping("/hotels")
    public ModelAndView getHotels() {
        return new ModelAndView("hotel", "hotels", hotelService.getAll());
    }
}
