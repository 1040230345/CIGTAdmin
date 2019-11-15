package com.cigt.mapper;

import com.cigt.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {

    /**
     * 查询登录信息
     */
    @Select("select * from t_user where name=#{name} and password=#{password} ")
    UserDto findUser_login(@Param("name") String name, @Param("password") String password);

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
    @Insert(" INSERT INTO t_user (id, name, password, created_at, updated_at,real_name ) VALUES ( #{id}, #{name}, #{password}, #{created_at}, #{updated_at},#{real_name} ) ")
    int insertUser(UserDto userDto);

    /**
     * 修改用户信息
     */
    @Update(" UPDATE t_user SET name,=#{name},image=#{image},address=#{address},sex=#{sex},phone=#{phone},autograph=#{autograph},Information_state = #{Information_state}，updated_at=#{updated_at} where user_id = #{user_id},real_name=#{real_name} ")
    int updateUser(UserDto userDto);

    /**
     * 删除用户信息
     */
    @Delete(" DELETE FROM t_user WHERE id= #{id} ")
    int Delete(UserDto userDto);

}
