package com.cigt.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;


@ApiIgnore //Swagger屏蔽此接口！
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
