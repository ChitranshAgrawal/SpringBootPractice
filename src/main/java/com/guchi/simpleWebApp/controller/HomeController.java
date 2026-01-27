package com.guchi.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Welcome to our page";
    }

    @RequestMapping("/about")
    public String about() {
        return "About Section";
    }
}

