package com.sunglowsys.web;

import com.sunglowsys.domain.RatePlanCalender;
import com.sunglowsys.service.RatePlanCalenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
