package com.cigt.mapper;

import com.cigt.dto.adminDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Adminmapper {
    /**
     * 查询登录信息
     */
    @Select("select * from t_admin where account=#{account} and password=#{password} ")
    adminDto findUser_login(@Param("account") String account, @Param("password") String password);
}
