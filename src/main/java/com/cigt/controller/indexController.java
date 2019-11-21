package com.cigt.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags="首页接口（管理员操作）")
public class indexController {
    @PostMapping("/home")
    public String toLogin(){
        return "home";
    }

    @PostMapping("/index")
    public String toIndex(){
        return "index";
    }
}
