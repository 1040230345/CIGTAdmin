package com.cigt.service;

import com.cigt.dto.UserDto;
import com.cigt.dto.adminDto;
import com.cigt.mapper.Adminmapper;
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
    @Autowired
    private Adminmapper adminmapper;

    /**
     * 登录的账号密码验证
     * @param account
     * @param password
     * @return
     */
    @Override
    public adminDto checkLogin(String account, String password) {
        adminDto adminDto = adminmapper.findUser_login(account,password);
        if(adminDto != null){
            return adminDto;
        }
        return null;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<UserDto> allUser(int currPage, int pageSize){
        int index = currPage * pageSize - pageSize;
        List<UserDto> list = usermapper.findAllUser(index,pageSize);
        return list;

//        List<UserDto> list = usermapper.findAllUser();
//        if(list != null ){
//            return  list;
//        }
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
        System.out.println(userDto.getUpdated_at());
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
