package com.cigt.mapper;

import com.cigt.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {


    /**
     * 查询所有用户信息
     */
    @Select(" select * from t_user ")
    List<UserDto> findAllUser();

    /**
     *查询单个用户信息
     */
    @Select("select * from t_user where  name LIKE #{name} ")
    UserDto findByName(@Param("name") String name);

    /**
     * 插入用户信息
     */
    @Insert(" INSERT INTO t_user (name,address,phone,Information_state,updated_at,real_name ) VALUES ( #{name},#{address},#{phone},#{Information_state},#{updated_at},#{real_name} ) ")
    int insertUser(UserDto userDto);

    /**
     * 修改用户信息
     */
    @Update(" UPDATE t_user SET real_name=#{real_name},image=#{image},address=#{address},sex=#{sex},phone=#{phone},autograph=#{autograph},Information_state = #{Information_state}，updated_at=#{updated_at} where id = #{id}")
    int updateUser(UserDto userDto);

    /**
     * 删除用户信息
     */
    @Delete(" DELETE FROM t_user WHERE id= #{id} ")
    int Delete(int id);

}
