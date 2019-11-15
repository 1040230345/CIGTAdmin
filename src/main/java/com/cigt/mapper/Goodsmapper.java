package com.cigt.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface Goodsmapper {

    /**
     *查询所有商品信息
     */
    @Select(" select * from t_goods ")
    Goodsmapper findAll();

    /**
     * 查询单个商品信息
     */
    @Select(" select * from t_goods where id = #{id} or name like #{name} ")
    Goodsmapper findById(@Param("id") int id);

    /**
     * 修改单个商品信息
     */
    @Update(" update t_good SET name=#{name},price=#{price},images=#{images},num=#{num},category=#{category},updated_at=#{updated_at} where id = #{id} ")
    int updateById(Goodsmapper goodsmapper);

    /**
     * 插入单个商品信息
     */
    @Insert(" INSERT INTO t_goods (name, price, images, time, updated_at, user_id, num, category) VALUES ( #{name}, #{price}, #{images}, #{time}, #{updated_at}, #{user_id}, #{num}, #{category} ) ")
    int insertGoods(Goodsmapper goodsmapper);

    /**
     * 删除单个商品信息
     */
    @Delete(" DELETE FROM t_user WHERE id= #{id} ")
    int delectGoods(Goodsmapper goodsmapper);
}
