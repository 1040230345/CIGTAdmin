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
     * @param userDto
     * @return
     */
    public List<UserDto> allUser(UserDto userDto){
        List<UserDto> list = usermapper.findAllUser();
        if(list != null ){
            return  list;
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
        // 赋值创建时间和修改时间
        userDto.setCreated_at(getTime_util.GetNowTime_util());
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
}
