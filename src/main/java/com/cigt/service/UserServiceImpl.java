package com.cigt.service;

import com.cigt.dto.UserDto;
import com.cigt.mapper.Usermapper;
import com.cigt.my_util.GetTime_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private Usermapper usermapper;
    @Autowired
    private GetTime_util getTime_util;

    /**
     * 登录的账号密码验证
     * @param name
     * @param password
     * @return
     */
    @Override
    public UserDto checkLogin(String name, String password) {
        UserDto userDto = usermapper.findUser_login(name,password);
        if(userDto != null){
            return userDto;
        }
        return null;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<UserDto> allUser(){
        List<UserDto> list = usermapper.findAllUser();
        if(list != null ){
            return  list;
        }
        return null;
    }

    /**
     * 查询单个用户
     * @param name
     * @return
     */
    @Override
    public UserDto findUserByName(String name) {
        UserDto userDto =usermapper.findByName(name);
        if(userDto != null ){
            return userDto;
        }
        return null;
    }

    /**
     * 更新操作
     * @param userDto
     * @return
     */
    @Override
    public UserDto updateUser(UserDto userDto) {
        //赋值更新时间
        userDto.setUpdated_at(getTime_util.GetNowTime_util());
        int num = usermapper.updateUser(userDto);
        if ( num>0 ){
            return userDto;
        }
        return null;
    }

    /**
     * 插入操作
     * @param userDto
     * @return
     */
    @Override
    public UserDto register(UserDto userDto) {
        // 赋值修改时间
        userDto.setUpdated_at(getTime_util.GetNowTime_util());
        //插入数据库
        int num = usermapper.insertUser(userDto);
        // System.out.println(userDto.toString());
        if(num>0){
            //获取用户信息
            userDto = usermapper.findByName(userDto.getName());
            if(userDto!=null){
                //boolean bl = mkdirCookie(userDto.getId());
                return userDto;
            }
        }
        return null;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public boolean delectUser(int id) {
        int num = usermapper.Delete(id);
        if( num >0 ){
            return true;
        }
        return false;
    }
}
