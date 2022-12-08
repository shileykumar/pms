package com.sunglowsys.web;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.service.HotelInventoryService;
import com.sunglowsys.service.HotelService;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HotelInventoryController {

    private final HotelInventoryService inventoryService;

    private final HotelService hotelService;

    private final RoomTypeService roomTypeService;

    public HotelInventoryController(HotelInventoryService inventoryService, HotelService hotelService, RoomTypeService roomTypeService) {
        this.inventoryService = inventoryService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/inventories")
    public ModelAndView getInventories() {
        return new ModelAndView("inventory", "inventories", inventoryService.findAll());
    }

    @GetMapping("/inventories-form")
    public ModelAndView loadForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("roomTypes", roomTypeService.findAll());
        modelAndView.addObject("inventory", new HotelInventory());
        modelAndView.setViewName("new-inventory");
        return modelAndView;
    }

    @PostMapping("/inventories-create")
    public ModelAndView createInventory(@ModelAttribute HotelInventory inventory) {
        HotelInventory result = inventoryService.save(inventory);
        return new ModelAndView("redirect:/inventories");
    }
}
