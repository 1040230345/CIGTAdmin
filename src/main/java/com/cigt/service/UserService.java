package com.cigt.service;

import com.cigt.dto.UserDto;
import com.cigt.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    
    /**
     * 登录校验
     */
    UserDto checkLogin(String name,String password);

    /**
     * 查询所有用户信息
     */
    List<UserDto> allUser(UserDto userDto);

    /**
     * 修改用户信息
     */
    UserDto updateUser(UserDto userDto);

    /**
     * 插入数据事务
     */
    UserDto  register(UserDto userDto);


}
