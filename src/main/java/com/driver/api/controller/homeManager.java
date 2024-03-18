package com.driver.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class homeManager {
    @GetMapping("/")
    String homePage(){
        return "home";
    }
}
