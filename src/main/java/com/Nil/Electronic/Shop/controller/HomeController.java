package com.Nil.Electronic.Shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class HomeController {
    public String testing(){

        return "Welcome to Electrical Store";
    }
}
