package com.sunglowsys.web;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.service.HotelService;
import com.sunglowsys.service.RatePlanService;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class RatePlanController {

    private final RatePlanService planService;

    private final HotelService hotelService;

    private final RoomTypeService roomTypeService;

    public RatePlanController(RatePlanService planService, HotelService hotelService, RoomTypeService roomTypeService) {
        this.planService = planService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/rate-plan")
    public ModelAndView getPlans() {
        List<RatePlan> result = planService.findAll();
        return new ModelAndView("rate-plan","plans", result);
    }

    @GetMapping("/rate-plan-form")
    public ModelAndView loadForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("roomTypes", roomTypeService.findAll());
        modelAndView.addObject("plan", new RatePlan());
        modelAndView.setViewName("new-rate-plan");
        return modelAndView;
    }

    @PostMapping("/rate-plan-create")
    public ModelAndView createRatePlan(@ModelAttribute RatePlan ratePlan) {
        RatePlan result = planService.save(ratePlan);
        return new ModelAndView("redirect:/rate-plan");
    }
}
