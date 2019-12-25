package com.cigt.controller;

import com.cigt.dto.UserDto;
import com.cigt.dto.adminDto;
import com.cigt.mapper.Adminmapper;
import com.cigt.service.UserService;
import com.cigt.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags="用户操作接口（管理员操作）")
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private Adminmapper adminmapper;
    /**
     * 登录--controller
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录接口")
    @ResponseBody
    public Map<String, String> login(@RequestParam(required = false) String remember, String account, String password, Model model, HttpServletResponse response, HttpServletRequest request) {
        System.out.println(account);
        System.out.println(password);
        Map<String, String> map = new HashMap<>();
        //验证登录账号密码
        adminDto adminDto = adminmapper.findUser_login(account,password);
        if (adminDto != null) {
            // 获取Session
            HttpSession session=request.getSession();
            //添加到session里面
            session.setAttribute("Admin",adminDto);
            map.put("loginSuccess", "success");
            return map;
        }
//      model.addAttribute("login_error","请检查密码后再次尝试登陆，谢谢");
        map.put("login_error", "请检查密码后再次尝试登陆，谢谢");
        return map;
    }

    /**
     * 退出登陆的逻辑页面
     * @param request
     * @return
     */
    @GetMapping("/loginout")
    @ApiOperation(value = "登出信息")
    public String login_out(HttpServletRequest request){
        //销毁session
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
    /**
     * 查询所有用户--controller
     */
    @PostMapping("/api/findAllUserInfo")
    @ApiOperation(value = "查询用户信息")
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
    @ApiOperation(value = "查询用户信息")
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
    @ApiOperation(value = "修改用户信息")
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
    @ApiOperation(value = "插入用户信息")
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
    @ApiOperation(value = "删除用户信息")
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
