package com.sunglowsys.web;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ModelAndView getCustomers() {
        List<Customer> result = customerService.findAll();
        return new ModelAndView("customer", "customers", result);
    }

    @GetMapping("/customers-form")
    public ModelAndView loadForm() {
        return new ModelAndView("new-customer", "customer", new Customer());
    }

    @PostMapping("/customers-create")
    public ModelAndView createCustomer(@ModelAttribute Customer customer) {
        Customer result = customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }
}
