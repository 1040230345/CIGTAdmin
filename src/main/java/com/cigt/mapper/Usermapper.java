package com.cigt.mapper;

import com.cigt.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {


    /**
     * 查询所有用户信息
     */
    @Select(" select * from t_user limit #{index},#{pageSize} ")
    List<UserDto> findAllUser(@Param("index")int index,
                              @Param("pageSize")int pageSize);

    /**
     * 计算总记录数值
     */
    @Select("SELECT count(*) FROM t_user")
    int countGoods();

    /**
     *查询单个用户信息
     */
    @Select("select * from t_user where name LIKE '%${name}%'")
    List<UserDto> findByName(@Param("name") String name);

    /**
     * 插入用户信息
     */
    @Insert(" INSERT INTO t_user (name,image,password,address,sex,phone,autograph,Information_state,created_at,updated_at,real_name ) VALUES ( #{name},#{image},#{password},#{address},#{sex},#{phone},#{autograph},#{Information_state},#{created_at},#{updated_at},#{real_name} ) ")
    int insertUser(UserDto userDto);

    /**
     * 修改用户信息
     */
    @Update(" UPDATE t_user SET name=#{name},image=#{image},password=#{password},address=#{address},sex=#{sex},phone=#{phone},real_name=#{real_name},autograph=#{autograph},Information_state = #{Information_state},updated_at=#{updated_at} where id = #{id}")
    int updateUser(UserDto userDto);

    /**
     * 修改用户修改日期
     */


    /**
     * 删除用户信息
     */
    @Delete(" DELETE FROM t_user WHERE id= #{id} ")
    int Delete(int id);

}
