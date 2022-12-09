package com.sunglowsys.web;

import com.sunglowsys.domain.InventoryCalender;
import com.sunglowsys.service.InventoryCalenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class InventoryCalenderController {

    private final InventoryCalenderService calenderService;

    public InventoryCalenderController(InventoryCalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @GetMapping("/inventory-calender")
    public ModelAndView getCalender() {
        List<InventoryCalender> result = calenderService.findAll();
        return new ModelAndView("inventory-calender", "calenders", result);
    }
}
