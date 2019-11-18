package com.cigt.controller;

import com.cigt.dto.UserDto;
import com.cigt.dto.adminDto;
import com.cigt.mapper.Adminmapper;
import com.cigt.service.UserService;
import com.cigt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private Adminmapper adminmapper;
    /**
     * 登录--controller
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestParam(required = false) String remember, String account , String password, Model model, HttpServletResponse response, HttpServletRequest request) {
        System.out.println(account);
        System.out.println(password);
        Map<String, String> map = new HashMap<>();
        //验证登录账号密码
        adminDto adminDto = adminmapper.findUser_login(account,password);
        if (adminDto != null) {
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
     * 登录成功后
     */
    @PostMapping(value = "/login")
    public String requestLogin(){
        System.out.println("登录成功");
        return "home";
    }

    /**
     * 退出登陆的逻辑页面
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/loginout")
    public String login_out(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("TOKEN")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        //销毁session
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/";
    }
    /**
     * 查询所有用户--controller
     */
    @PostMapping("/api/findAllUserInfo")
    @ResponseBody
    public Map allUser(){
        Map map = new HashMap<>();
        List<UserDto> list = userService.allUser();
        if(list != null ){
            map.put("findAllUser",list);
            return map;
        }
        map.put("findAllUser","false");
        return map;
    }

    /**
     *查询单个用户
     */
    @PostMapping("/api/findAllUserInfo/{name}")
    @ResponseBody
    public Map oneUser(String name){
        Map map = new HashMap<>();
        UserDto userDto = userService.findUserByName(name);
        if( userDto != null ){
            map.put("findAllUserByName",userDto);
        }
        map.put("findAllUserByName","名字不存在");
        return map;
    }

    /**
     * 修改用户信息---controller
     */
    @PostMapping("/api/updateUserInfo")
    @ResponseBody
    public Map updateUser(UserDto userDto){
        Map map =new HashMap();
        try {
            userService.updateUser(userDto);
            map.put("updateUser",userDto);
            return  map;
        }catch (Exception e){
            System.out.println(e);
            map.put("updateUser","false");
            return map;
        }
    }

    /**
     * 插入操作
     */
    @PostMapping("/api/insertUserInfo")
    @ResponseBody
    public Map insertUser(UserDto userDto){
        Map map = new HashMap();
        try{
            userService.register(userDto);
            map.put("insertUser",userDto);
            return map;
        }catch (Exception e){
            System.out.println(e);
            if(userDto.getName() == null || userDto.getPassword() == null || userDto.getInformation_state() == null ){
                map.put("insertUser","name or password or information_state is null ");
                return map;
            }
            map.put("insertUser","false");
            return map;
        }
    }

    /**
     * 删除操作
     */
    @PostMapping("/api/delectUserInfo")
    @ResponseBody
    public Map delectUser(int id){
        Map map = new HashMap();
        try{
            userService.delectUser(id);
            map.put("delectUser","ture");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("delectUser","false");
            return map;
        }
    }
}
