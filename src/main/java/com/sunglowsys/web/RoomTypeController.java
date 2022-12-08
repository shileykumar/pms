package com.sunglowsys.web;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/roomType")
    public ModelAndView getRoomTypes() {
        return new ModelAndView("room-type", "roomTypes", roomTypeService.findAll());
    }

    @GetMapping("/roomType-form")
    public ModelAndView loadForm() {
        return new ModelAndView("new-room-type", "roomType", new RoomType());
    }

    @PostMapping("/roomType-create")
    public ModelAndView createRoomType(@ModelAttribute RoomType roomType) {
        RoomType result = roomTypeService.save(roomType);
        return new ModelAndView("redirect:/roomType");
    }
}
