package com.sunglowsys.web;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.domain.RatePlanCalender;
import com.sunglowsys.service.RatePlanCalenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class RatePlanCalenderController {

    private final RatePlanCalenderService planCalenderService;

    public RatePlanCalenderController(RatePlanCalenderService planCalenderService) {
        this.planCalenderService = planCalenderService;
    }

    @GetMapping("/plan-calender")
    public ModelAndView getPlanCalender() {
        List<RatePlanCalender> result = planCalenderService.findAll();
        return new ModelAndView("rate-plan-calender", "calenders", result);
    }

    @GetMapping("/plan-calender-form")
    public ModelAndView loadForm() {
        return new ModelAndView("new-rate-plan-calender", "calender", new RatePlanCalender());
    }

    @PostMapping("/plan-calender-create")
    public ModelAndView createCalender(@ModelAttribute RatePlanCalender planCalender) {
        RatePlanCalender result = planCalenderService.save(planCalender);
        return new ModelAndView("redirect:/plan-calender");
    }

    @GetMapping("/plan-calender-update-{id}")
    public ModelAndView updateCalender(@PathVariable Long id) {
        RatePlanCalender result = planCalenderService.findById(id).get();

        Hotel hotels = result.getHotel();
        RatePlan ratePlans = result.getRatePlan();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("hotels", hotels);
        modelAndView.addObject("ratePlans", ratePlans);
        modelAndView.addObject("calender", result);
        modelAndView.setViewName("new-rate-plan-calender");

        return modelAndView;
    }
}
