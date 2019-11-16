package com.cigt.service;

import com.cigt.dto.UserDto;
import com.cigt.dto.adminDto;

import java.util.List;


public interface UserService {
    
    /**
     * 登录校验
     */
    adminDto checkLogin(String account, String password);

    /**
     * 查询所有用户信息
     */
    List<UserDto> allUser();

    /**
     *查询单个用户信息
     */
    UserDto findUserByName(String name);

    /**
     * 修改用户信息
     */
    UserDto updateUser(UserDto userDto);

    /**
     * 插入数据事务
     */
    UserDto  register(UserDto userDto);

    /**
     * 删除用户
     */
    boolean delectUser(int id);

}
