package com.sunglowsys.web;

import com.sunglowsys.domain.User;
import com.sunglowsys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register/form")
    public ModelAndView registrationForm() {
        return new ModelAndView("register", "user", new User());
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute User user) {
        userService.save(user);
        return new ModelAndView("redirect:/register");
    }
}
