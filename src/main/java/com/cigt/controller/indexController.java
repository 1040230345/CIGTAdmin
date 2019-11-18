package com.cigt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/home")
    public String toLogin(){
        return "home";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
}
