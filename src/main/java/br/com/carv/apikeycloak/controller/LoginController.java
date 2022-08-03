package br.com.carv.apikeycloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/contact-us")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("contact-us");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/manage")
    @PreAuthorize("hasAuthority('PROFESSOR')")
    public ModelAndView manage() {
        ModelAndView modelAndView = new ModelAndView("manage");
        return modelAndView;
    }

    @GetMapping("/access-denied")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView("access-denied");
        return modelAndView;
    }

}
