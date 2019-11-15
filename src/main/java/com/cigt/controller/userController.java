package com.cigt.controller;

import com.cigt.dto.UserDto;
import com.cigt.service.UserService;
import com.cigt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class userController {

    @Autowired
    private UserService userService;

    /**
     * 登录--controller
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestParam(required = false) String remember, String name , String password, Model model, HttpServletResponse response, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        //验证登录账号密码
        UserDto userDto = userService.checkLogin(name, password);
        if (userDto != null) {
            //创建token，缓存用户数据
            //  String token = userService.updateCookie(userDto);
            //model.addAttribute("USER",userDto);
            //创建新cookie
            //  Cookie cookie = new Cookie("TOKEN",token);
            //发送给浏览器
            //  response.addCookie(cookie);
            // 获取Session
            //HttpSession session=request.getSession();
            //添加到session里面
            // session.setAttribute("User_id",userDto.getId());
            map.put("loginSuccess", "success");
            return map;
        }
//      model.addAttribute("login_error","请检查密码后再次尝试登陆，谢谢");
        map.put("login_error", "请检查密码后再次尝试登陆，谢谢");
        return map;
    }

    /**
     * 查询所有用户--controller
     */
    @PostMapping("/findAllUserInfo")
    @ResponseBody
    public Map allUser(UserDto userDto , Model model, HttpServletResponse response, HttpServletRequest request ){
        Map map = new HashMap<>();
        List<UserDto> list = userService.allUser(userDto);
        if(list != null ){
            map.put("findAllUser",list);
            return map;
        }
        map.put("findAllUser","false");
        return map;
    }

    /**
     * 修改用户信息---controller
     */

}
